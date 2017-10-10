package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.SchoolBuildingDao;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.SchoolBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/8.
 */

@Service
public class SchoolBuildingService {
    @Autowired
    private SchoolBuildingDao dao;

    public ResponseBody<List<SchoolBuilding>> list() {
        return new ResponseBody<>(SUCCESS, "", dao.list());
    }

    public ResponseBody<List<SchoolBuilding>> listArea() {
        return new ResponseBody<>(SUCCESS, "", dao.listArea());
    }

    public ResponseBody<List<SchoolBuilding>> listByArea(String area) {
        return new ResponseBody<>(SUCCESS, "", dao.listByArea(area));
    }
}
