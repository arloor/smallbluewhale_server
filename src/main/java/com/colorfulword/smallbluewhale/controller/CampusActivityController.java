package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.service.CampusActivityService;
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
@Api(value = "campus-activity-api", description = "校园活动")
@RestController
public class CampusActivityController {
    @Autowired
    private CampusActivityService service;

    @ApiOperation(value = "根据校区查询活动列表", notes = "0 进行中 -1 已过期")
    @RequestMapping(value = "/api/activity/list", method = RequestMethod.GET)
    public Object listByCampus(@RequestParam("campus") String campus, @RequestParam("status") int status) {
        return service.listByCampus(campus, status);
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/api/activity/insert", method = RequestMethod.POST)
    public Object insert(@RequestParam("campusActivityName") String campusActivityName,
                         @RequestParam("campusActivityDetail") String campusActivityDetail,
                         @RequestParam("campusActivityCampus") String campusActivityCampus,
                         @RequestParam("campusActivityTime") String campusActivityTime,
                         @RequestParam(value = "file1", required = false) MultipartFile file1,
                         @RequestParam(value = "file2", required = false) MultipartFile file2,
                         @RequestParam(value = "file3", required = false) MultipartFile file3,
                         @RequestParam(value = "file4", required = false) MultipartFile file4,
                         @RequestParam(value = "file5", required = false) MultipartFile file5) {
        return service.insert(campusActivityName, campusActivityDetail, campusActivityCampus, campusActivityTime,
                file1, file2, file3, file4, file5);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/api/activity/update/{campusActivityId}", method = RequestMethod.POST)
    public Object update(@PathVariable Integer campusActivityId,
                         @RequestParam("campusActivityName") String campusActivityName,
                         @RequestParam("campusActivityDetail") String campusActivityDetail,
                         @RequestParam("campusActivityCampus") String campusActivityCampus,
                         @RequestParam("campusActivityTime") String campusActivityTime,
                         @RequestParam(value = "file1", required = false) MultipartFile file1,
                         @RequestParam(value = "file2", required = false) MultipartFile file2,
                         @RequestParam(value = "file3", required = false) MultipartFile file3,
                         @RequestParam(value = "file4", required = false) MultipartFile file4,
                         @RequestParam(value = "file5", required = false) MultipartFile file5) {
        return service.update(campusActivityId, campusActivityName, campusActivityDetail, campusActivityCampus, campusActivityTime,
                file1, file2, file3, file4, file5);
    }

    @ApiOperation(value = "下线")
    @RequestMapping(value = "/api/activity/offline/{campusActivityId}", method = RequestMethod.POST)
    public Object offline(@PathVariable Integer campusActivityId) {
        return service.offline(campusActivityId);
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/api/activity/{campusActivityId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer campusActivityId) {
        return service.delete(campusActivityId);
    }

    @ApiIgnore
    @RequestMapping(value = "/download/campusActivity/{fileDir}/{fileName:.+}", method = RequestMethod.GET)
    public void download(@PathVariable String fileDir, @PathVariable String fileName, HttpServletResponse res) throws UnsupportedEncodingException {
        service.download(fileDir, fileName, res);
    }
}
