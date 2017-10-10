package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.service.CampusRecordEventService;
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
@Api(value = "campus-record-event-api", description = "校园纪事")
@RestController
public class CampusRecordEventController {

    @Autowired
    private CampusRecordEventService service;

    @ApiOperation(value = "根据校区查询校园纪事列表")
    @RequestMapping(value = "/api/recordevent/list", method = RequestMethod.GET)
    public Object listByCampus(@RequestParam("campus") String campus) {
        return service.listByCampus(campus);
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/api/recordevent/insert", method = RequestMethod.POST)
    public Object insert(@RequestParam("title") String title,
                         @RequestParam("recordTime") String recordTime,
                         @RequestParam("campus") String campus,
                         @RequestParam("organizationSide") String organizationSide,
                         @RequestParam("content") String content,
                         @RequestParam(value = "file1", required = false) MultipartFile file1,
                         @RequestParam(value = "file2", required = false) MultipartFile file2,
                         @RequestParam(value = "file3", required = false) MultipartFile file3,
                         @RequestParam(value = "file4", required = false) MultipartFile file4,
                         @RequestParam(value = "file5", required = false) MultipartFile file5) {
        return service.insert(title, recordTime, campus, organizationSide, content,
                file1, file2, file3, file4, file5);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/api/recordevent/update/{recordEventId}", method = RequestMethod.POST)
    public Object update(@PathVariable Integer recordEventId,
                         @RequestParam("title") String title,
                         @RequestParam("recordTime") String recordTime,
                         @RequestParam("campus") String campus,
                         @RequestParam("organizationSide") String organizationSide,
                         @RequestParam("content") String content,
                         @RequestParam(value = "file1", required = false) MultipartFile file1,
                         @RequestParam(value = "file2", required = false) MultipartFile file2,
                         @RequestParam(value = "file3", required = false) MultipartFile file3,
                         @RequestParam(value = "file4", required = false) MultipartFile file4,
                         @RequestParam(value = "file5", required = false) MultipartFile file5) {
        return service.update(recordEventId, title, recordTime, campus, organizationSide, content,
                file1, file2, file3, file4, file5);
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/api/recordevent/{recordEventId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer recordEventId) {
        return service.delete(recordEventId);
    }

    @ApiIgnore
    @RequestMapping(value = "/download/campusRecord/{fileDir}/{fileName:.+}", method = RequestMethod.GET)
    public void download(@PathVariable String fileDir, @PathVariable String fileName, HttpServletResponse res) throws UnsupportedEncodingException {
        service.download(fileDir, fileName, res);
    }

//    @ResponseBody
//    @RequestMapping(value = "/files_upload" ,method = RequestMethod.POST)
//    public Map<String, Object> uploadApkFile(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        request.setCharacterEncoding("UTF-8");
//
//        Map<String, Object> json = new HashMap<String, Object>();
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//
//        /** 页面控件的文件流* */
//        MultipartFile multipartFile = null;
//        Map map =multipartRequest.getFileMap();
//        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
//            Object obj = i.next();
//            multipartFile=(MultipartFile) map.get(obj);
//
//        }
//        /** 获取文件的后缀* */
//        String filename = multipartFile.getOriginalFilename();
//
//        InputStream inputStream;
//        String path = "";
//        String newVersionName = "";
//        String fileMd5 = "";
//        try {
//            inputStream = multipartFile.getInputStream();
//            File tmpFile = File.createTempFile(filename,
//                    filename.substring(filename.lastIndexOf(".")));
//            fileMd5 = Files.hash(tmpFile, Hashing.md5()).toString();
//            FileUtils.copyInputStreamToFile(inputStream, tmpFile);
//            System.err.println(tmpFile.getPath());
//            //tmpFile.delete();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        json.put("newVersionName", newVersionName);
//        json.put("fileMd5", fileMd5);
//        json.put("message", "应用上传成功");
//        json.put("status", true);
//        json.put("filePath", path);
//        return json;
//    }
}
