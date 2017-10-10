package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.ResponseBodyCode;
import com.colorfulword.smallbluewhale.dao.SiteNavigationDao;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
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
public class SiteNavigationService extends FileUploadDownloadService {

    @Autowired
    private SiteNavigationDao dao;

    @Override
    String getModelName() {
        return "siteNavigation";
    }

    public ResponseBody<List<SiteNavigation>> list() {
        return new ResponseBody<>(SUCCESS, "", dao.list());
    }

    public ResponseBody<Boolean> insert(String name, String url, String group, MultipartFile file){
        String picUrl = saveWithReturnUrl(name, "icon", file);
        SiteNavigation siteNavigation = new SiteNavigation();
        siteNavigation.setName(name);
        siteNavigation.setUrl(url);
        siteNavigation.setGroup(group);
        siteNavigation.setIcon(picUrl);
        if(dao.insert(siteNavigation) > 0){
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

}
