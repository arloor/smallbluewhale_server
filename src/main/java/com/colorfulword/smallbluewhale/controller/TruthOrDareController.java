package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.domain.TruthOrDare;
import com.colorfulword.smallbluewhale.service.SiteNavigationService;
import com.colorfulword.smallbluewhale.service.TruthOrDareService;
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

@Api(value = "truthOrDare-api", description = "真心话大冒险")
@RestController
@RequestMapping(value = "/api/truthOrDare")
public class TruthOrDareController {

    @Autowired
    private TruthOrDareService service;

    @ApiOperation(value = "列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        return service.list();
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody TruthOrDare truthOrDare) {
        return service.insert(truthOrDare);
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/{truthOrDareId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer truthOrDareId) {
        return service.delete(truthOrDareId);
    }

}
