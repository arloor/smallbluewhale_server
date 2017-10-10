package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.requestbody.DormRepairReply;
import com.colorfulword.smallbluewhale.service.DormRepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Api(value = "dorm-repair-api", description = "宿舍报修")
@RestController
public class DormRepairController {

    @Autowired
    private DormRepairService service;

    @ApiOperation(value = "根据报修人查看报修记录")
    @RequestMapping(value = "/api/dormRepair/listByUserId", method = RequestMethod.GET)
    public Object listByUserId(@RequestParam("repairUserId") Integer repairUserId) {
        return service.listByUserId(repairUserId);
    }

    @ApiOperation(value = "根据状态查看报修记录", notes = "报修状态 0未查看和1已确认")
    @RequestMapping(value = "/api/dormRepair/listByStatus", method = RequestMethod.GET)
    public Object listByStatus(@RequestParam("repairStatus") Integer repairStatus) {
        return service.listByStatus(repairStatus);
    }

    @ApiOperation(value = "根据状态和楼栋查看报修记录", notes = "报修状态 0未查看和1已确认")
    @RequestMapping(value = "/api/dormRepair/listByStatusAndBuilding", method = RequestMethod.GET)
    public Object listByStatusAndBuilding(@RequestParam("repairStatus") Integer repairStatus,
                                          @RequestParam("repairSchoolBuildingId") Integer repairSchoolBuildingId) {
        return service.listByStatusAndBuilding(repairStatus, repairSchoolBuildingId);
    }

    @ApiOperation(value = "报修")
    @RequestMapping(value = "/api/dormRepair/insert", method = RequestMethod.POST)
    public Object insert(@RequestParam("repairUserId") Integer repairUserId,
                         @RequestParam("repairDormId") Integer repairDormId,
                         @RequestParam("articleName") String articleName,
                         @RequestParam("reason") String reason,
                         @RequestParam("desc") String desc,
                         @RequestParam(value = "file1", required = false) MultipartFile file1,
                         @RequestParam(value = "file2", required = false) MultipartFile file2,
                         @RequestParam(value = "file3", required = false) MultipartFile file3) {
        return service.insert(repairUserId, repairDormId, articleName, reason, desc,
                file1, file2, file3);
    }

    @ApiOperation(value = "管理员确认反馈")
    @RequestMapping(value = "/api/dormRepair/reply", method = RequestMethod.POST)
    public Object reply(@RequestBody DormRepairReply dormRepairReply) {
        return service.reply(dormRepairReply);
    }

    @ApiIgnore
    @RequestMapping(value = "/download/dormRepair/{fileDir}/{fileName:.+}", method = RequestMethod.GET)
    public void download(@PathVariable String fileDir, @PathVariable String fileName, HttpServletResponse res) throws UnsupportedEncodingException {
        service.download(fileDir, fileName, res);
    }
}
