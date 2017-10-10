package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.PersonalStyle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Mapper
public interface PersonalStyleDao {

    List<PersonalStyle> listByCampusAndType(String campus, String type);

    int insert(PersonalStyle personalStyle);

    int update(PersonalStyle personalStyle);

    int delete(Integer personalStyleId);

    PersonalStyle get(Integer personalStyleId);

}
