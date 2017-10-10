package com.colorfulword.smallbluewhale.service;

import com.alibaba.fastjson.JSON;
import com.colorfulword.smallbluewhale.dao.CampusRecordEventDao;
import com.colorfulword.smallbluewhale.domain.CampusRecordEvent;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Service
public class CampusRecordEventService extends FileUploadDownloadService {

    @Autowired
    private CampusRecordEventDao dao;

    @Override
    String getModelName() {
        return "campusRecord";
    }

    public ResponseBody<List<CampusRecordEvent>> listByCampus(String campus) {
        return new ResponseBody<>(SUCCESS, "", dao.listByCampus(campus));
    }

    public ResponseBody<Boolean> insert(String title, String recordTime,
                                        String campus, String organizationSide,
                                        String content,
                                        MultipartFile file1, MultipartFile file2, MultipartFile file3,
                                        MultipartFile file4, MultipartFile file5) {
        List<String> picUrlList = saveWithReturnUrls(title, "pic", file1, file2, file3, file4, file5);
        CampusRecordEvent campusRecordEvent = new CampusRecordEvent();
        setData(campusRecordEvent, title, recordTime, campus, organizationSide, content);
        campusRecordEvent.setPics(JSON.toJSONString(picUrlList));
        if (dao.insert(campusRecordEvent) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<Boolean> update(Integer recordEventId, String title, String recordTime,
                                        String campus, String organizationSide,
                                        String content,
                                        MultipartFile file1, MultipartFile file2, MultipartFile file3,
                                        MultipartFile file4, MultipartFile file5) {
        CampusRecordEvent campusRecordEvent = dao.get(recordEventId);
        if (campusRecordEvent == null) {
            return new ResponseBody<>(ERROR, "不存在", false);
        }
        String dirName = campusRecordEvent.getTitle();
        setData(campusRecordEvent, title, recordTime, campus, organizationSide, content);
        List<String> picUrlList = saveWithReturnUrlsWithUpdate(campusRecordEvent.getPics(), dirName, "pic",
                file1, file2, file3, file4, file5);
        if (picUrlList != null && picUrlList.size() > 0) {
            campusRecordEvent.setPics(JSON.toJSONString(picUrlList));
        }
        if (dao.update(campusRecordEvent) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public Object delete(Integer recordEventId) {
        if (dao.delete(recordEventId) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    private void setData(CampusRecordEvent campusRecordEvent, String title, String recordTime,
                         String campus, String organizationSide, String content) {
        campusRecordEvent.setTitle(title);
        campusRecordEvent.setRecordTime(recordTime);
        campusRecordEvent.setCampus(campus);
        campusRecordEvent.setOrganizationSide(organizationSide);
        campusRecordEvent.setContent(content);
    }

}
