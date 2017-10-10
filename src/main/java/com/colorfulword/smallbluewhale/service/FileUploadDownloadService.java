package com.colorfulword.smallbluewhale.service;

import com.alibaba.fastjson.JSON;
import com.colorfulword.smallbluewhale.util.MD5Util;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传下载
 * Created by jone.sun on 2017/7/3.
 */
public abstract class FileUploadDownloadService {
    private File fileRootDir = new File("C:\\smallbluewhale\\files");

    abstract String getModelName();

    private File getParentDir(){
        return new File(fileRootDir, getModelName());
    }

    List<String> saveWithReturnUrls(String dirName, String fileName, MultipartFile... multipartFiles){
        List<String> stringList = new ArrayList<>();
        if(multipartFiles != null && multipartFiles.length > 0){
            for (int i = 0; i < multipartFiles.length; i++) {
                String url = saveWithReturnUrl(dirName, fileName + "_" + i, multipartFiles[i]);
                if(url != null){
                    stringList.add(url);
                }
            }
        }
        return stringList;
    }

    String saveWithReturnUrl(String dirName, String fileName, MultipartFile multipartFile){
        String md5 = null;
        if (multipartFile != null && !multipartFile.isEmpty()) {
            try {
                fileName = fileName + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."));
                File outFile = new File(getParentDir(), dirName + File.separator + fileName);
                outFile.getParentFile().mkdirs();
                multipartFile.transferTo(outFile);
                md5 = MD5Util.getFileMD5String(outFile);
                return new StringBuilder("download").append("/")
                        .append(getModelName()).append("/")
                        .append(dirName).append("/")
                        .append(fileName).toString();
            } catch (Exception e) {
                md5 = null;
                return null;
            }
        }
        return null;
    }

    public void download(String fileDir, String fileName, HttpServletResponse res) {
        // System.out.println("fileDir: " + fileDir + " fileName: " + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            //the request doesn't contain a multipart/form-data or multipart/mixed stream, content type header is application/x-www-form-urlencoded
            res.setHeader("conent-type", "application/octet-stream");
            res.setContentType("application/octet-stream");
            if (fileName.endsWith(".apk")) {
                res.setContentType("application/force-download");// 设置强制下载不打开
                res.setHeader("conent-type", "application/vnd.android.package-archive");
                res.setContentType("application/vnd.android.package-archive");
            }
            //res.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("ISO-8859-1"), "UTF-8"));
            res.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            String relativePath = fileDir + File.separator + fileName;
            os = res.getOutputStream();
            copyFileToStream(new File(getParentDir(), relativePath), os);
//            bis = new BufferedInputStream(new FileInputStream(new File(fileRootDir, relativePath)));
//            int i = bis.read(buff);
//            while (i != -1) {
//                os.write(buff, 0, buff.length);
//                os.flush();
//                i = bis.read(buff);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    List<String> saveWithReturnUrlsWithUpdate(String oldPicsStr, String dirName, String fileName, MultipartFile... files){

        List<String> picUrlList = saveWithReturnUrls(dirName, fileName, files);
        List<String> oldPicUrlList = new ArrayList<>();
        if(oldPicsStr != null && oldPicsStr.length() > 0){
            oldPicUrlList = JSON.parseArray(oldPicsStr, String.class);
        }
        if (picUrlList != null && picUrlList.size() > 0) {
            picUrlList.removeAll(oldPicUrlList);
            picUrlList.addAll(oldPicUrlList);
        }
        return picUrlList;
    }

    private void copyFileToStream(File f, OutputStream ostream) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            byte[] buffer = new byte[2048];
            while (true) {
                int bytesReceived = fis.read(buffer);
                if (bytesReceived < 1) {
                    break;
                }
                ostream.write(buffer, 0, bytesReceived);
            }
        } catch (FileNotFoundException e){
            System.err.println("文件不存在: " + f.getPath());
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}
