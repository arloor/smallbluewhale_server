package com.colorfulword.smallbluewhale.service;

import com.alibaba.fastjson.JSON;
import com.colorfulword.smallbluewhale.dao.PersonalStyleDao;
import com.colorfulword.smallbluewhale.domain.PersonalStyle;
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
public class PersonalStyleService extends FileUploadDownloadService {

    @Autowired
    private PersonalStyleDao dao;

    @Override
    String getModelName() {
        return "personalStyle";
    }

    public ResponseBody<List<PersonalStyle>> listByCampusAndType(String campus, String type) {
        return new ResponseBody<>(SUCCESS, "", dao.listByCampusAndType(campus, type));
    }

    public ResponseBody<Boolean> insert(String userNumber, String userName, String mobile,
                                        String content, String campus, String type, Integer buildingId,
                                        MultipartFile file1, MultipartFile file2, MultipartFile file3,
                                        MultipartFile file4, MultipartFile file5) {
        List<String> picUrlList = saveWithReturnUrls(userNumber, "pic", file1, file2, file3, file4, file5);
        PersonalStyle personalStyle = new PersonalStyle();
        setData(personalStyle, userNumber, userName, mobile, content, campus, type, buildingId);
        personalStyle.setPics(JSON.toJSONString(picUrlList));
        if (dao.insert(personalStyle) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<Boolean> update(Integer personalStyleId, String userNumber, String userName, String mobile,
                                        String content, String campus, String type, Integer buildingId,
                                        MultipartFile file1, MultipartFile file2, MultipartFile file3,
                                        MultipartFile file4, MultipartFile file5) {
        PersonalStyle personalStyle = dao.get(personalStyleId);
        if (personalStyleId == null) {
            return new ResponseBody<>(ERROR, "不存在", false);
        }
        String dirName = personalStyle.getUserNumber();
        setData(personalStyle, userNumber, userName, mobile, content, campus, type, buildingId);
        List<String> picUrlList = saveWithReturnUrlsWithUpdate(personalStyle.getPics(), dirName, "pic",
                file1, file2, file3, file4, file5);
        if (picUrlList != null && picUrlList.size() > 0) {
            personalStyle.setPics(JSON.toJSONString(picUrlList));
        }
        if (dao.update(personalStyle) > 0) {
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

    private void setData(PersonalStyle personalStyle, String userNumber, String userName, String mobile,
                         String content, String campus, String type, Integer buildingId) {
        personalStyle.setUserNumber(userNumber);
        personalStyle.setUserName(userName);
        personalStyle.setMobile(mobile);
        personalStyle.setContent(content);
        personalStyle.setCampus(campus);
        personalStyle.setType(type);
        personalStyle.setBuildingId(buildingId);
    }

}
