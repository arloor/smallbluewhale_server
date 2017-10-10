package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.domain.Feedback;
import com.colorfulword.smallbluewhale.service.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Api(value = "feedback-api", description = "意见反馈")
@RestController
@RequestMapping(value = "/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @ApiOperation(value = "根据状态查询列表", notes = "状态 0-新发布未回复 1-已回复")
    @RequestMapping(value = "/listByStatus", method = RequestMethod.GET)
    public Object listByStatus(@RequestParam("feedbackStatus") int feedbackStatus) {
        return service.listByStatus(feedbackStatus);
    }

    @ApiOperation(value = "查询某楼栋下所有列表", notes = "状态 0-新发布未回复 1-已回复")
    @RequestMapping(value = "/listBySchoolBuildingId", method = RequestMethod.GET)
    public Object listBySchoolBuildingId(@RequestParam("schoolBuildingId") Integer schoolBuildingId,
                                         @RequestParam("feedbackStatus") int feedbackStatus) {
        return service.listBySchoolBuildingId(schoolBuildingId, feedbackStatus);
    }

    @ApiOperation(value = "添加意见反馈",
            notes = "feedbackQuestion|feedbackType[投诉；建议；赞赏]|feedbackContent|publisherId")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody Feedback feedback) {
        return service.insert(feedback);
    }

    @ApiOperation(value = "回复意见反馈",
            notes = "feedbackId|replyContent|replyUserId")
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public Object reply(@RequestBody Feedback feedback) {
        return service.reply(feedback);
    }
}
