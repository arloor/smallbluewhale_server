package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jone.sun on 2017/6/30.
 */
@Mapper
public interface UserDao {

    List<User> listSchoolBuildingAdmin();

    User findByUserNumber(String userNumber);

    User findByWeChat(String weChat);

    User get(Integer userId);

    int insert(User user);

    int delete(User user);

    int update(User user);

    int updateStatus(Integer userId, int status);

}
