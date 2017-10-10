package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.CampusActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Mapper
public interface CampusActivityDao {

    List<CampusActivity> listByCampus(String campus, int status);

    int insert(CampusActivity campusActivity);

    int delete(Integer campusActivityId);

    int update(CampusActivity campusActivity);

    CampusActivity get(Integer campusActivityId);

    int offline(Integer campusActivityId);

}
