package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.domain.Notice;
import com.colorfulword.smallbluewhale.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Api(value = "notice-api", description = "通知")
@RestController
@RequestMapping(value = "/api/notice")
public class NoticeController {

    @Autowired
    private NoticeService service;

    @ApiOperation(value = "列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        return service.list();
    }

    @ApiOperation(value = "查看发送到楼栋的列表")
    @RequestMapping(value = "/listByToBuildingId", method = RequestMethod.GET)
    public Object listByToBuildingId(@RequestParam("noticeToBuildingId") Integer noticeToBuildingId) {
        return service.listByToBuildingId(noticeToBuildingId);
    }

    @ApiOperation(value = "查询发送给某个学生的通知列表")
    @RequestMapping(value = "/listToUser", method = RequestMethod.GET)
    public Object listToUser(@RequestParam("userId") Integer userId) {
        return service.listToUser(userId);
    }

    @ApiOperation(value = "发布通知")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody Notice notice) {
        return service.insert(notice);
    }
}
