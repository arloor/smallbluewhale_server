package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/7/2.
 */
@Mapper
public interface RoleDao {

    List<Role> list();
}
