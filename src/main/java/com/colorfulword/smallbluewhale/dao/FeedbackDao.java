package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.Feedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Mapper
public interface FeedbackDao {

    List<Feedback> listByStatus(int feedbackStatus);

    List<Feedback> listBySchoolBuildingId(Integer schoolBuildingId, int feedbackStatus);

    int insert(Feedback feedback);

    int reply(Feedback feedback);
}
