package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.DormRepair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
@Mapper
public interface DormRepairDao {

    //根据报修人查看报修记录
    List<DormRepair> listByUserId(Integer repairUserId);

    //根据状态查看报修记录
    List<DormRepair> listByStatus(Integer repairStatus);

    //根据状态和楼栋查看报修记录
    List<DormRepair> listByStatusAndBuilding(Integer repairStatus, Integer repairSchoolBuildingId);

    //报修
    int insert(DormRepair dormRepair);

    //确认反馈
    int reply(DormRepair dormRepair);
}
