package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.SchoolDorm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Mapper
public interface SchoolDormDao {

    List<SchoolDorm> listBySchoolBuildingId(Integer schoolBuildingId);

    List<SchoolDorm> getByDorm(SchoolDorm schoolDorm);

    int insert(SchoolDorm schoolDorm);

    int delete(Integer schoolDormId);

    SchoolDorm get(Integer schoolDormId);
}
