package com.colorfulword.smallbluewhale.service;

import com.alibaba.fastjson.JSON;
import com.colorfulword.smallbluewhale.dao.CampusActivityDao;
import com.colorfulword.smallbluewhale.domain.CampusActivity;
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
public class CampusActivityService extends FileUploadDownloadService {
    @Autowired
    private CampusActivityDao dao;

    @Override
    String getModelName() {
        return "campusActivity";
    }

    public ResponseBody<List<CampusActivity>> listByCampus(String campus, int status) {
        return new ResponseBody<>(SUCCESS, "", dao.listByCampus(campus, status));
    }

    public ResponseBody<Boolean> insert(String campusActivityName, String campusActivityDetail,
                                        String campusActivityCampus, String campusActivityTime,
                                        MultipartFile file1, MultipartFile file2, MultipartFile file3,
                                        MultipartFile file4, MultipartFile file5) {
        List<String> picUrlList = saveWithReturnUrls(campusActivityName, "pic", file1, file2, file3, file4, file5);
        CampusActivity campusActivity = new CampusActivity();
        setData(campusActivity, campusActivityName, campusActivityDetail, campusActivityCampus, campusActivityTime);
        campusActivity.setPics(JSON.toJSONString(picUrlList));
        if (dao.insert(campusActivity) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<Boolean> update(Integer campusActivityId, String campusActivityName, String campusActivityDetail,
                                        String campusActivityCampus, String campusActivityTime,
                                        MultipartFile file1, MultipartFile file2, MultipartFile file3,
                                        MultipartFile file4, MultipartFile file5) {
        CampusActivity campusActivity = dao.get(campusActivityId);
        if (campusActivity == null) {
            return new ResponseBody<>(ERROR, "不存在", false);
        }
        String dirName = campusActivity.getCampusActivityName();
        setData(campusActivity, campusActivityName, campusActivityDetail, campusActivityCampus, campusActivityTime);
        List<String> picUrlList = saveWithReturnUrlsWithUpdate(campusActivity.getPics(), dirName, "pic",
                file1, file2, file3, file4, file5);
        if (picUrlList != null && picUrlList.size() > 0) {
            campusActivity.setPics(JSON.toJSONString(picUrlList));
        }
        if (dao.update(campusActivity) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public Object offline(Integer campusActivityId) {
        if (dao.offline(campusActivityId) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public Object delete(Integer campusActivityId) {
        if (dao.delete(campusActivityId) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    private void setData(CampusActivity campusActivity, String campusActivityName, String campusActivityDetail,
                         String campusActivityCampus, String campusActivityTime) {
        campusActivity.setCampusActivityName(campusActivityName);
        campusActivity.setCampusActivityDetail(campusActivityDetail);
        campusActivity.setCampusActivityCampus(campusActivityCampus);
        campusActivity.setCampusActivityTime(campusActivityTime);
    }

}
