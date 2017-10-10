package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.service.SchoolBuildingService;
import com.colorfulword.smallbluewhale.service.SiteNavigationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Api(value = "school-building-api", description = "学校宿舍楼栋")
@RestController
@RequestMapping(value = "/api/schoolbuilding")
public class SchoolBuildingController {

    @Autowired
    private SchoolBuildingService service;

    @ApiOperation(value = "列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        return service.list();
    }

    @ApiOperation(value = "获取所有组团片区")
    @RequestMapping(value = "/listArea", method = RequestMethod.GET)
    public Object listArea() {
        return service.listArea();
    }

    @ApiOperation(value = "根据组团片区查询楼栋列表")
    @RequestMapping(value = "/listByArea", method = RequestMethod.GET)
    public Object listByArea(@RequestParam("area") String area) {
        return service.listByArea(area);
    }
}
