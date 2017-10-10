package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.RoleDao;
import com.colorfulword.smallbluewhale.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jone.sun on 2017/7/2.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> list() {
        return roleDao.list();
    }
}
