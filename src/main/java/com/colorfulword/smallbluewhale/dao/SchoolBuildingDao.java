package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.SchoolBuilding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Mapper
public interface SchoolBuildingDao {

    List<SchoolBuilding> list();

    List<SchoolBuilding> listArea();

    List<SchoolBuilding> listByArea(String area);

    SchoolBuilding get(Integer schoolBuildingId);
}
