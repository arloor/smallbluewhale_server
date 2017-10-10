package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.domain.SiteNavigation;
import com.colorfulword.smallbluewhale.service.SiteNavigationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */

@Api(value = "site-navigation-api", description = "网址导航")
@RestController
public class SiteNavigationController {

    @Autowired
    private SiteNavigationService service;

    @ApiOperation(value = "列表")
    @RequestMapping(value = "/api/site/list", method = RequestMethod.GET)
    public Object list() {
        return service.list();
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/api/site/insert", method = RequestMethod.POST)
    public Object insert(@RequestParam("name") String name,
                         @RequestParam("url") String url,
                         @RequestParam("group") String group,
                         @RequestParam(value = "file", required = false) MultipartFile file) {
        return service.insert(name, url, group, file);
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/api/site/{siteId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer siteId) {
        return service.delete(siteId);
    }

    @ApiIgnore
    @RequestMapping(value = "/download/siteNavigation/{fileDir}/{fileName:.+}", method = RequestMethod.GET)
    public void download(@PathVariable String fileDir, @PathVariable String fileName, HttpServletResponse res) throws UnsupportedEncodingException {
        service.download(fileDir, fileName, res);
    }
}
