package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.service.LostArticleService;
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
@Api(value = "lost-article-api", description = "失物招领")
@RestController
public class LostArticleController {

    @Autowired
    private LostArticleService service;

    @ApiOperation(value = "列表(未下线的)")
    @RequestMapping(value = "/api/lostArticle/list", method = RequestMethod.GET)
    public Object list() {
        return service.list();
    }

    @ApiOperation(value = "根据校区查询列表(未下线的)")
    @RequestMapping(value = "/api/lostArticle/listByCampus", method = RequestMethod.GET)
    public Object listByCampus(@RequestParam("campus") String campus) {
        return service.listByCampus(campus);
    }

    @ApiOperation(value = "根据类型查询列表(未下线的)", notes = "type = 卡证|书籍|衣包|其他")
    @RequestMapping(value = "/api/lostArticle/listByType", method = RequestMethod.GET)
    public Object listByType(@RequestParam("lostArticleType") String lostArticleType) {
        return service.listByType(lostArticleType);
    }

    @ApiOperation(value = "列表(已下线的)")
    @RequestMapping(value = "/api/lostArticle/listOfOffline", method = RequestMethod.GET)
    public Object listOfOffline() {
        return service.listOfOffline();
    }

    @ApiOperation(value = "发布失物", notes = "type = 卡证|书籍|衣包|其他")
    @RequestMapping(value = "/api/lostArticle/insert", method = RequestMethod.POST)
    public Object insert(@RequestParam("publisherId") Integer publisherId,
                         @RequestParam("lostUser") String lostUser,
                         @RequestParam("lostUserMobile") String lostUserMobile,
                         @RequestParam("lostArticleName") String lostArticleName,
                         @RequestParam("campus") String campus,
                         @RequestParam("position") String position,
                         @RequestParam("lostArticleType") String lostArticleType,
                         @RequestParam(value = "file1", required = false) MultipartFile file1) {
        return service.insert(publisherId, lostUser, lostUserMobile, lostArticleName,
                campus, position, lostArticleType, file1);
    }

    @ApiOperation(value = "下线")
    @RequestMapping(value = "/api/lostArticle/offline", method = RequestMethod.POST)
    public Object offline(@RequestParam("lostArticleId") Integer lostArticleId) {
        return service.offline(lostArticleId);
    }

    @ApiIgnore
    @RequestMapping(value = "/download/lostArticle/{fileDir}/{fileName:.+}", method = RequestMethod.GET)
    public void download(@PathVariable String fileDir, @PathVariable String fileName, HttpServletResponse res) throws UnsupportedEncodingException {
        service.download(fileDir, fileName, res);
    }
}
