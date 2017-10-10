package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.SchoolStudyInfo;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
public interface SchoolStudyInfoDao {

    List<SchoolStudyInfo> list();

    int insert(SchoolStudyInfo schoolStudyInfo);

    int delete(Integer studyInfoId);

    int update(SchoolStudyInfo schoolStudyInfo);
}
