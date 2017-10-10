package com.colorfulword.smallbluewhale.service;

import com.alibaba.fastjson.JSON;
import com.colorfulword.smallbluewhale.dao.DormRepairDao;
import com.colorfulword.smallbluewhale.dao.SchoolDormDao;
import com.colorfulword.smallbluewhale.domain.CampusActivity;
import com.colorfulword.smallbluewhale.domain.DormRepair;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import com.colorfulword.smallbluewhale.domain.SchoolDorm;
import com.colorfulword.smallbluewhale.requestbody.DormRepairReply;
import com.colorfulword.smallbluewhale.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Service
public class DormRepairService extends FileUploadDownloadService {

    @Autowired
    private DormRepairDao dao;

    @Autowired
    private SchoolDormDao schoolDormDao;

    @Override
    String getModelName() {
        return "dormRepair";
    }

    //根据报修人查看报修记录
    public ResponseBody<List<DormRepair>> listByUserId(Integer repairUserId){
        return new ResponseBody<>(SUCCESS, "", dao.listByUserId(repairUserId));
    }

    //根据状态查看报修记录
    public ResponseBody<List<DormRepair>> listByStatus(Integer repairStatus){
        return new ResponseBody<>(SUCCESS, "", dao.listByStatus(repairStatus));
    }

    //根据状态和楼栋查看报修记录
    public ResponseBody<List<DormRepair>> listByStatusAndBuilding(Integer repairStatus,
                                                                  Integer repairSchoolBuildingId){
        return new ResponseBody<>(SUCCESS, "",
                dao.listByStatusAndBuilding(repairStatus, repairSchoolBuildingId));
    }

    //报修
    public ResponseBody<Boolean> insert(Integer repairUserId, Integer repairDormId,
                                        String articleName, String reason, String desc,
                                        MultipartFile file1, MultipartFile file2, MultipartFile file3){
        List<String> picUrlList = saveWithReturnUrls(System.currentTimeMillis() + "", "pic", file1, file2, file3);
        DormRepair dormRepair = new DormRepair();
        dormRepair.setRepairUserId(repairUserId);
        dormRepair.setRepairDormId(repairDormId);
        dormRepair.setArticleName(articleName);
        dormRepair.setReason(reason);
        dormRepair.setDesc(desc);
        SchoolDorm schoolDorm = schoolDormDao.get(repairDormId);
        if(schoolDorm != null){
            dormRepair.setRepairSchoolBuildingId(schoolDorm.getSchoolBuildingId());
        }
        dormRepair.setPics(JSON.toJSONString(picUrlList));
        if (dao.insert(dormRepair) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    //确认反馈
    public ResponseBody<Boolean> reply(DormRepairReply dormRepairReply){
        DormRepair dormRepair = new DormRepair();
        dormRepair.setRepairId(dormRepairReply.getRepairId());
        dormRepair.setDormRepairReply(dormRepair.getDormRepairReply());
        if (dao.reply(dormRepair) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }
}
