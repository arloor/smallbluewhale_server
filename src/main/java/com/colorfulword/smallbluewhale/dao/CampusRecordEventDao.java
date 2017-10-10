package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.CampusRecordEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Mapper
public interface CampusRecordEventDao {

    List<CampusRecordEvent> listByCampus(String campus);

    int insert(CampusRecordEvent campusRecordEvent);

    int delete(Integer recordEventId);

    int update(CampusRecordEvent campusRecordEvent);

    CampusRecordEvent get(Integer recordEventId);
}
