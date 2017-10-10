package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.domain.SchoolDorm;
import com.colorfulword.smallbluewhale.service.SchoolDormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Api(value = "school-dorm-api", description = "学校宿舍")
@RestController
@RequestMapping(value = "/api/schooldorm")
public class SchoolDormController {

    @Autowired
    private SchoolDormService service;

    @ApiOperation(value = "根据所在楼栋获取宿舍列表")
    @RequestMapping(value = "/listBySchoolBuildingId", method = RequestMethod.GET)
    public Object listBySchoolBuildingId(@RequestParam("schoolBuildingId") Integer schoolBuildingId) {
        return service.listBySchoolBuildingId(schoolBuildingId);
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody SchoolDorm schoolDorm) {
        return service.insert(schoolDorm);
    }

}
