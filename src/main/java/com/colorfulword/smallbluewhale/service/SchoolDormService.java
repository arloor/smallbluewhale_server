package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.SchoolDormDao;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.SchoolDorm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.CODE_HAS_EXIST;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Service
public class SchoolDormService {
    @Autowired
    private SchoolDormDao dao;

    public ResponseBody<List<SchoolDorm>> listBySchoolBuildingId(Integer schoolBuildingId) {
        return new ResponseBody<>(SUCCESS, "", dao.listBySchoolBuildingId(schoolBuildingId));
    }

    public ResponseBody<Boolean> insert(SchoolDorm schoolDorm) {
        List<SchoolDorm> schoolDormList = dao.getByDorm(schoolDorm);
        if(schoolDormList != null && schoolDormList.size() > 0){
            return new ResponseBody<>(CODE_HAS_EXIST, "error has exist", false);
        }
        if (dao.insert(schoolDorm) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }
}
