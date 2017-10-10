package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.SchoolStudyInfoDao;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.SchoolStudyInfo;
import com.colorfulword.smallbluewhale.domain.SiteNavigation;
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
public class SchoolStudyInfoService {

    @Autowired
    private SchoolStudyInfoDao dao;

    public ResponseBody<List<SchoolStudyInfo>> list() {
        return new ResponseBody<>(SUCCESS, "", dao.list());
    }

    public ResponseBody<Boolean> insert(SchoolStudyInfo schoolStudyInfo){
        if(dao.insert(schoolStudyInfo) > 0){
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<Boolean> delete(Integer siteId){
        if(dao.delete(siteId) > 0){
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<Boolean> update(SchoolStudyInfo schoolStudyInfo){
        if(dao.update(schoolStudyInfo) > 0){
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }
}
