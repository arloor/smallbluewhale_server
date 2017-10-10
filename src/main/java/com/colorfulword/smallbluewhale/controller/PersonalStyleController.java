package com.colorfulword.smallbluewhale.controller;

import com.colorfulword.smallbluewhale.service.CampusRecordEventService;
import com.colorfulword.smallbluewhale.service.PersonalStyleService;
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
@Api(value = "personal-style-event-api", description = "个人风采")
@RestController
public class PersonalStyleController {

    @Autowired
    private PersonalStyleService service;

    @ApiOperation(value = "根据校区和类型查询个人风采列表", notes = "type 宿管|保洁")
    @RequestMapping(value = "/api/personalStyle/list", method = RequestMethod.GET)
    public Object listByCampus(@RequestParam("campus") String campus, @RequestParam("type") String type) {
        return service.listByCampusAndType(campus, type);
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/api/personalStyle/insert", method = RequestMethod.POST)
    public Object insert(@RequestParam("userNumber") String userNumber,
                         @RequestParam("userName") String userName,
                         @RequestParam("mobile") String mobile,
                         @RequestParam("content") String content,
                         @RequestParam("campus") String campus,
                         @RequestParam("type") String type,
                         @RequestParam("buildingId") Integer buildingId,
                         @RequestParam(value = "file1", required = false) MultipartFile file1,
                         @RequestParam(value = "file2", required = false) MultipartFile file2,
                         @RequestParam(value = "file3", required = false) MultipartFile file3,
                         @RequestParam(value = "file4", required = false) MultipartFile file4,
                         @RequestParam(value = "file5", required = false) MultipartFile file5) {
        return service.insert(userNumber, userName, mobile, content, campus, type, buildingId,
                file1, file2, file3, file4, file5);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/api/personalStyle/update/{personalStyleId}", method = RequestMethod.POST)
    public Object update(@PathVariable Integer personalStyleId,
                         @RequestParam("userNumber") String userNumber,
                         @RequestParam("userName") String userName,
                         @RequestParam("mobile") String mobile,
                         @RequestParam("content") String content,
                         @RequestParam("campus") String campus,
                         @RequestParam("type") String type,
                         @RequestParam("buildingId") Integer buildingId,
                         @RequestParam(value = "file1", required = false) MultipartFile file1,
                         @RequestParam(value = "file2", required = false) MultipartFile file2,
                         @RequestParam(value = "file3", required = false) MultipartFile file3,
                         @RequestParam(value = "file4", required = false) MultipartFile file4,
                         @RequestParam(value = "file5", required = false) MultipartFile file5) {
        return service.update(personalStyleId, userNumber, userName, mobile, content, campus, type, buildingId,
                file1, file2, file3, file4, file5);
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/api/personalStyle/{recordEventId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer recordEventId) {
        return service.delete(recordEventId);
    }

    @ApiIgnore
    @RequestMapping(value = "/download/personalStyle/{fileDir}/{fileName:.+}", method = RequestMethod.GET)
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
