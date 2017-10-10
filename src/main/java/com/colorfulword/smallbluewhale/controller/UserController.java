package com.colorfulword.smallbluewhale.controller;

/**
 * Created by jone.sun on 2017/6/30.
 */

import com.colorfulword.smallbluewhale.domain.Student;
import com.colorfulword.smallbluewhale.domain.User;
import com.colorfulword.smallbluewhale.requestbody.UserChangePassword;
import com.colorfulword.smallbluewhale.entity.Error;
import com.colorfulword.smallbluewhale.exception.UserNotFountException;
import com.colorfulword.smallbluewhale.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "user-api", description = "用户")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有楼栋管理员")
    @RequestMapping(value = "/listSchoolBuildingAdmin", method = RequestMethod.GET)
    public Object listSchoolBuildingAdmin() {
        return userService.listSchoolBuildingAdmin();
    }

    @ApiOperation(value = "查询用户")
    @RequestMapping(value = "/{userNumber}", method = RequestMethod.GET)
    public Object get(@PathVariable String userNumber) {
        return userService.get(userNumber);
    }


    @ApiOperation(value = "禁言用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Object get(@RequestParam Integer Id, @RequestParam("status") int status) {
        return userService.updateStatus(Id,status);
    }


    @ApiOperation(value = "添加宿管或更新授权码", notes = "schoolBuildingId: 所在楼栋ID")
    @RequestMapping(value = "/addOrUpdateSchoolBuildingAdmin", method = RequestMethod.POST)
    public Object addOrUpdateSchoolBuildingAdmin(@RequestParam("userNumber") String userNumber, @RequestParam("code") String code,
                                                 @RequestParam("schoolBuildingId") Integer schoolBuildingId) {
        return userService.addOrUpdateSchoolBuildingAdmin(userNumber, code, schoolBuildingId);
    }

    @ApiOperation(value = "学生微信号绑定用户")
    @RequestMapping(value = "/bindWeChat", method = RequestMethod.POST)
    public Object bindWeChat(@RequestBody Student student) {
        return userService.bindWeChat(student);
    }

    @ApiOperation(value = "查询微信号是否绑定用户")
    @RequestMapping(value = "/isBindUser", method = RequestMethod.GET)
    public Object isBindUser(@RequestParam("weChat") String weChat) {
        return userService.isBindUser(weChat);
    }

    @ExceptionHandler(UserNotFountException.class)
    public ResponseEntity<Error> UserNotFound(UserNotFountException e) {
        String userId = e.getUserId();
        Error error = new Error(4, "User （" + userId + ") not found");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}
