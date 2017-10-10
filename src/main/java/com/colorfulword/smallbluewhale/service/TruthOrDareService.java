package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.SiteNavigationDao;
import com.colorfulword.smallbluewhale.dao.TruthOrDareDao;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.SiteNavigation;
import com.colorfulword.smallbluewhale.domain.TruthOrDare;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Service
public class TruthOrDareService {

    @Autowired
    private TruthOrDareDao dao;

    public ResponseBody<List<TruthOrDare>> list() {
        return new ResponseBody<>(SUCCESS, "", dao.list());
    }

    public ResponseBody<Boolean> insert(TruthOrDare truthOrDare){
        if(dao.insert(truthOrDare) > 0){
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    public ResponseBody<Boolean> delete(Integer truthOrDareId){
        if(dao.delete(truthOrDareId) > 0){
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

}
