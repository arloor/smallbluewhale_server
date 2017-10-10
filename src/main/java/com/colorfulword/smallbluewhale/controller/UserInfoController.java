package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by jiajun.jiang on 2017/8/10.
 */
@Api(value = "userInfo-api", description = "学生管理")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    @ApiOperation(value = "通过姓名查询学生")
    @RequestMapping(value = "/api/userInfo/searchByFullName", method = RequestMethod.POST)
    public Object getByFullName(@RequestParam("userName")  String userName) {
        return userService.getByFullName(userName);
    }

    @ApiOperation(value = "通过学号查询学生")
    @RequestMapping(value = "/api/userInfo/searchByUserNumber", method = RequestMethod.POST)
    public Object getByUserNumber(@RequestParam("userNumber")  String userNumber) {
        return userService.getByUserNumber(userNumber);
    }

    @ApiOperation(value = "通过楼栋查询学生")
    @RequestMapping(value = "/api/userInfo/searchBySchoolBuildingId", method = RequestMethod.POST)
    public Object getBySchoolBuildingId(@RequestParam("schoolBuildingId") Integer schoolBuildingId) {
        return userService.getBySchoolBuildingId(schoolBuildingId);
    }

    @ApiOperation(value = "通过宿舍查询学生")
    @RequestMapping(value = "/api/userInfo/searchBySchoolDormId", method = RequestMethod.POST)
    public Object getBySchoolDormId(@RequestParam("schoolDormId") Integer schoolDormId) {
        return userService.getBySchoolDormId(schoolDormId);
    }

    @ApiOperation(value = "通过院系年级查询学生")
    @RequestMapping(value = "/api/userInfo/searchBySchoolGrade", method = RequestMethod.POST)
    public Object getBySchoolGrade(@RequestParam("schoolStudyId")  Integer schoolStudyId, @RequestParam("grade") String grade) {
        return userService.getBySchoolGrade(schoolStudyId,grade);
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/api/userInfo/insert", method = RequestMethod.POST)
    public Object insert(@RequestParam("userNumber") String userNumber,
                         @RequestParam("fullName") String fullName,
                         @RequestParam("sex") String sex,
                         @RequestParam("mobile") String mobile,
                         @RequestParam("schoolBuildingId") Integer schoolBuildingId,
                         @RequestParam("schoolDormId") Integer schoolDormId,
                         @RequestParam("schoolStudyId") Integer schoolStudyId,
                         @RequestParam("grade") String grade,
                         @RequestParam(value = "file", required = false) MultipartFile file) {
        return userService.insert(userNumber, fullName,sex,mobile,schoolBuildingId,schoolDormId,schoolStudyId,grade,file);
    }

    @ApiIgnore
    @RequestMapping(value = "/download/userInfo/{fileDir}/{fileName:.+}", method = RequestMethod.GET)
    public void download(@PathVariable String fileDir, @PathVariable String fileName, HttpServletResponse res) throws UnsupportedEncodingException {
        userService.download(fileDir, fileName, res);
    }
}
