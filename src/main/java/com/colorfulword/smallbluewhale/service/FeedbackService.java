package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.FeedbackDao;
import com.colorfulword.smallbluewhale.dao.UserDao;
import com.colorfulword.smallbluewhale.domain.Feedback;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.CODE_USER_BAN;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Service
public class FeedbackService {
    @Autowired
    private FeedbackDao dao;

    @Autowired
    private UserDao userDao;

    public ResponseBody<List<Feedback>> listByStatus(int feedbackStatus) {
        return new ResponseBody<>(SUCCESS, "", dao.listByStatus(feedbackStatus));
    }

    public ResponseBody<List<Feedback>> listBySchoolBuildingId(Integer schoolBuildingId, int feedbackStatus) {
        return new ResponseBody<>(SUCCESS, "", dao.listBySchoolBuildingId(schoolBuildingId, feedbackStatus));
    }

    public ResponseBody<Boolean> insert(Feedback feedback) {
        if(feedback.getPublisherId() == null){
            return new ResponseBody<>(ERROR, "用户不存在", false);
        }
        User user = userDao.get(feedback.getPublisherId());
        if(user == null){
            return new ResponseBody<>(ERROR, "用户不存在", false);
        }
        if(user.getStatus() != null && user.getStatus() == 1){
            return new ResponseBody<>(CODE_USER_BAN, "用户被禁止发布意见反馈", false);
        }
        if (dao.insert(feedback) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<Boolean> reply(Feedback feedback) {
        if (dao.reply(feedback) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

}
