package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.domain.Role;
import com.colorfulword.smallbluewhale.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jone.sun on 2017/7/2.
 */
@Api(value = "role-api", description = "角色")
@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Role> list() {
        return roleService.list();
    }
}
