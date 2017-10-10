package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.domain.SchoolStudyInfo;
import com.colorfulword.smallbluewhale.service.SchoolStudyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Api(value = "school-study-info-api", description = "学校院系")
@RestController
@RequestMapping(value = "/api/school")
public class SchoolStudyInfoController {

    @Autowired
    private SchoolStudyInfoService service;

    @ApiOperation(value = "列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        return service.list();
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody SchoolStudyInfo schoolStudyInfo) {
        return service.insert(schoolStudyInfo);
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/{studyInfoId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer studyInfoId) {
        return service.delete(studyInfoId);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/{studyInfoId}", method = RequestMethod.PUT)
    public Object update(@PathVariable Integer studyInfoId, @RequestBody SchoolStudyInfo schoolStudyInfo) {
        schoolStudyInfo.setStudyInfoId(studyInfoId);
        return service.update(schoolStudyInfo);
    }

}
