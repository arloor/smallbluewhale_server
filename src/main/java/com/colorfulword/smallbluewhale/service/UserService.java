package com.colorfulword.smallbluewhale.service;

/**
 * Created by jone.sun on 2017/6/30.
 */

import com.alibaba.fastjson.JSON;
import com.colorfulword.smallbluewhale.dao.SchoolBuildingDao;
import com.colorfulword.smallbluewhale.dao.UserDao;
import com.colorfulword.smallbluewhale.dao.UserInfoDao;
import com.colorfulword.smallbluewhale.domain.*;
import com.colorfulword.smallbluewhale.requestbody.UserChangePassword;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

@Service //声明成一个spring beans
public class UserService {

    @Autowired //连接到UserDao Bean
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private SchoolBuildingDao schoolBuildingDao;

    public ResponseBody<List<User>> listSchoolBuildingAdmin() {
        return new ResponseBody<>(SUCCESS, "", userDao.listSchoolBuildingAdmin());
    }

    public ResponseBody<User> get(String userNumber) {
        return new ResponseBody<>(SUCCESS, "", userDao.findByUserNumber(userNumber));
    }

    public ResponseBody<User> findByWeChat(String weChat) {
        return new ResponseBody<>(SUCCESS, "", userDao.findByWeChat(weChat));
    }

    public ResponseBody<Boolean> updateStatus(Integer userId, int status) {
        int result = userDao.updateStatus(userId, status);
        System.out.println("result: " + result);
        if(result > 0){
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    /***
     * 添加宿管或更新授权码
     * @return
     */
    public ResponseBody<Boolean> addOrUpdateSchoolBuildingAdmin(String userNumber, String code, Integer schoolBuildingId){
        if(schoolBuildingId != null && schoolBuildingId > 0){
            if(schoolBuildingDao.get(schoolBuildingId) == null){
                return new ResponseBody<>(ERROR, "不存在该楼栋信息", false);
            }
            UserInfo userInfo = getUserInfoByUserNumber(userNumber);
            if(userInfo != null){
                if(!Objects.equals(userInfo.getSchoolBuildingId(), schoolBuildingId)){
                    userInfo.setSchoolBuildingId(schoolBuildingId);
                    userInfoDao.update(userInfo);
                }
            } else {
                userInfo = new UserInfo();
                userInfo.setUserNumber(userNumber);
                userInfo.setSchoolBuildingId(schoolBuildingId);
                userInfoDao.insert(userInfo);
            }
            User user = userDao.findByUserNumber(userNumber);
            if(user != null){
                user.setCode(code);
                user.setRoleId(2); //楼栋管理员
                user.setUserSchoolBuildingId(schoolBuildingId);
                if(userDao.update(user) > 0){
                    return new ResponseBody<>(SUCCESS, "update success", true);
                }
            }else {
                user = new User();
                user.setUserNumber(userNumber);
                user.setCode(code);
                user.setRoleId(2); //楼栋管理员
                user.setUserSchoolBuildingId(schoolBuildingId);
                if(userDao.insert(user) > 0){
                    return new ResponseBody<>(SUCCESS, "add success", true);
                }
            }
        }
        return new ResponseBody<>(ERROR, "楼栋不能为空", false);
    }

    /**
     * 学生绑定微信号
     * @param student
     * @return
     */
    public ResponseBody<Boolean> bindWeChat(Student student) {
        if (Strings.isNullOrEmpty(student.getWeChat()) || Strings.isNullOrEmpty(student.getUserNumber())) {
            return new ResponseBody<>(ERROR, "微信号和学号不能为空", false);
        }
        User user = userDao.findByUserNumber(student.getUserNumber());
        UserInfo userInfo = getUserInfoByUserNumber(student.getUserNumber());
        if (userInfo != null) {
            userInfo.setUserNumber(student.getUserNumber());
            if (!Strings.isNullOrEmpty(student.getFullName())) {
                userInfo.setFullName(student.getFullName());
            }
            if (!Strings.isNullOrEmpty(student.getSex())) {
                userInfo.setSex(student.getSex());
            }
            if (!Strings.isNullOrEmpty(student.getMobile())) {
                userInfo.setMobile(student.getMobile());
            }
            if (!Strings.isNullOrEmpty(student.getEmail())) {
                userInfo.setEmail(student.getEmail());
            }
            if (!Strings.isNullOrEmpty(student.getQq())) {
                userInfo.setQq(student.getQq());
            }
            try {
                userInfoDao.update(userInfo);
            } catch (Exception e) {
                System.err.println(student.getUserNumber() + ">>保存用户资料失败: " + e.getMessage());
            }
        } else {
            System.err.println("尚未存在学生信息: " + student.getUserNumber());
        }
        int result;
        if (user == null) {
            user = new User();
            user.setUserNumber(student.getUserNumber());
            user.setWeChat(student.getWeChat());
            user.setRoleId(3);//学生
            if(userInfo != null && userInfo.getSchoolBuildingId() != null){
                user.setUserSchoolBuildingId(userInfo.getSchoolBuildingId());
            }
            result = userDao.insert(user);
        } else {
            user.setUserNumber(student.getUserNumber());
            user.setWeChat(student.getWeChat());
            user.setRoleId(3);//学生
            if(userInfo != null && userInfo.getSchoolBuildingId() != null){
                user.setUserSchoolBuildingId(userInfo.getSchoolBuildingId());
            }
            result = userDao.update(user);
        }
        if (result > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<User> isBindUser(String weChat){
        User user = userDao.findByWeChat(weChat);
        if(user != null){
            return new ResponseBody<>(SUCCESS, "已经绑定", user);
        }
        return new ResponseBody<>(ERROR, "未绑定", user);
    }

    private UserInfo getUserInfoByUserNumber(String userNumber){
        UserInfo userInfo = null;
        List<UserInfo> userInfos = userInfoDao.getByUserNumber(userNumber);
        if (userInfos != null && userInfos.size() > 0) {
            userInfo = userInfos.get(0);
            if(userInfo.getSchoolBuilding() != null){
                userInfo.setSchoolBuildingId(userInfo.getSchoolBuilding().getSchoolBuildingId());
            }
            if(userInfo.getSchoolDorm() != null){
                userInfo.setSchoolDormId(userInfo.getSchoolDorm().getSchoolDormId());
            }
            if(userInfo.getSchoolStudyInfo() != null){
                userInfo.setSchoolStudyId(userInfo.getSchoolStudyInfo().getStudyInfoId());
            }
        }
        return userInfo;
    }

}
