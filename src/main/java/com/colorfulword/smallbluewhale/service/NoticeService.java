package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.NoticeDao;
import com.colorfulword.smallbluewhale.dao.UserDao;
import com.colorfulword.smallbluewhale.dao.UserInfoDao;
import com.colorfulword.smallbluewhale.domain.Notice;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.User;
import com.colorfulword.smallbluewhale.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Service
public class NoticeService {

    @Autowired
    private NoticeDao dao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    //列表
    public ResponseBody<List<Notice>> list() {
        return new ResponseBody<>(SUCCESS, "", dao.list());
    }

    //查看发送到楼栋的列表
    public ResponseBody<List<Notice>> listByToBuildingId(Integer noticeToBuildingId) {
        return new ResponseBody<>(SUCCESS, "", dao.listByToBuildingId(noticeToBuildingId));
    }

    public ResponseBody<List<Notice>> listToUser(Integer userId) {
        User user = userDao.get(userId);
        if (user == null || user.getSchoolBuilding() == null || user.getUserNumber() == null) {
            return new ResponseBody<>(SUCCESS, "success", Collections.emptyList());
        }
        UserInfo userInfo = null;
        List<UserInfo> list = userInfoDao.getByUserNumber(user.getUserNumber());
        if (list != null && list.size() > 0) {
            userInfo = list.get(0);
        }
        List<Notice> noticeList = dao.listByToBuildingId(user.getSchoolBuilding().getSchoolBuildingId());
        if (noticeList == null || noticeList.size() == 0) {
            return new ResponseBody<>(SUCCESS, "success", Collections.emptyList());
        }
        List<Notice> noticeResultList = new ArrayList<>();
        for (Notice notice : noticeList) {
            if (notice.getNoticeToUserId() == null
                    && notice.getNoticeToDormId() == null
                    && notice.getNoticeToStudyInfoId() == null) {
                noticeResultList.add(notice); //发送到本楼栋的
            } else if (notice.getNoticeToUserId() == null
                    && notice.getNoticeToDormId() != null
                    && notice.getNoticeToStudyInfoId() == null
                    && userInfo != null
                    && userInfo.getSchoolDorm() != null
                    && notice.getNoticeToDormId().equals(userInfo.getSchoolDorm().getSchoolDormId())) {
                noticeResultList.add(notice); //发送到宿舍的
            } else if (notice.getNoticeToUserId() == null
                    && notice.getNoticeToDormId() != null
                    && notice.getNoticeToStudyInfoId() == null
                    && userInfo != null
                    && userInfo.getSchoolDorm() != null
                    && userInfo.getSchoolStudyInfo() != null
                    && notice.getNoticeToDormId().equals(userInfo.getSchoolDorm().getSchoolDormId())
                    && notice.getNoticeToStudyInfoId().equals(userInfo.getSchoolStudyInfo().getStudyInfoId())) {
                noticeResultList.add(notice); //发送到宿舍的院系
            } else if (notice.getNoticeToUserId() == null
                    && notice.getNoticeToDormId() == null
                    && notice.getNoticeToStudyInfoId() != null
                    && userInfo != null
                    && userInfo.getSchoolStudyInfo() != null
                    && notice.getNoticeToStudyInfoId().equals(userInfo.getSchoolStudyInfo().getStudyInfoId())) {
                noticeResultList.add(notice); //发送到院系
            } else if (notice.getNoticeToUserId() != null
                    && notice.getNoticeToUserId().equals(userId)) {
                noticeResultList.add(notice); //发送给本人
            }
        }
        return new ResponseBody<>(SUCCESS, "", noticeResultList);
    }

    public ResponseBody<Boolean> insert(Notice notice) {
        if (dao.insert(notice) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

}
