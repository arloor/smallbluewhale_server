package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.UserInfoDao;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.CODE_HAS_EXIST;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jiajun.jiang on 2017/8/10.
 */
@Service
public class UserInfoService extends FileUploadDownloadService  {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    String getModelName() {
        return "userInfo";
    }

    public ResponseBody<List<UserInfo>> getByFullName(String userName) {
        return new ResponseBody<>(SUCCESS,"",userInfoDao.getByFullName(userName));
    }

    public ResponseBody<List<UserInfo>> getByUserNumber(String userNumber) {
        return new ResponseBody<>(SUCCESS,"",userInfoDao.getByUserNumber(userNumber));
    }

    public ResponseBody<List<UserInfo>> getBySchoolBuildingId(Integer schoolBuildingId) {
        List<UserInfo> userInfoList = new ArrayList<>();
        Stream<UserInfo> stream =  userInfoDao.getBySchoolBuildingId(schoolBuildingId).stream();
        stream.filter(userInfo -> {
            if (userInfo.getSchoolStudyInfo() != null && userInfo.getSchoolDorm()!=null){
                return true;
            }
            return false;
        }).forEach(userInfo -> userInfoList.add(userInfo));
        stream.close();
        return new ResponseBody<>(SUCCESS,"",userInfoList);
    }

    public ResponseBody<List<UserInfo>> getBySchoolDormId(Integer schoolDormId) {
        return new ResponseBody<>(SUCCESS,"",userInfoDao.getBySchoolDormId(schoolDormId));
    }

    public ResponseBody<List<UserInfo>> getBySchoolGrade(Integer schoolStudyId, String grade) {
        return new ResponseBody<>(SUCCESS,"",userInfoDao.getBySchoolGrade(schoolStudyId,grade));
    }


    public ResponseBody<Boolean> insert(String userNumber, String fullName, String sex, String mobile,Integer schoolBuildingId,Integer schoolDormId,
                                            Integer schoolStudyId,String grade,MultipartFile file){
        List<UserInfo> userInfoList = userInfoDao.getByUserNumber(userNumber);
        if(userInfoList != null && userInfoList.size() > 0){
            return new ResponseBody<>(CODE_HAS_EXIST, "error has exist", false);
        }
        String picUrl = saveWithReturnUrl(userNumber, "photo", file);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNumber(userNumber);
        userInfo.setFullName(fullName);
        userInfo.setSex(sex);
        userInfo.setMobile(mobile);
        userInfo.setSchoolBuildingId(schoolBuildingId);
        userInfo.setSchoolDormId(schoolDormId);
        userInfo.setSchoolStudyId(schoolStudyId);
        userInfo.setGrade(grade);
        userInfo.setHeadPic(picUrl);
        if(userInfoDao.insert(userInfo) > 0){
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }
}
