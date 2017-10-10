package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Mapper
public interface NoticeDao {

    List<Notice> list();

    //查看发送到楼栋的列表
    List<Notice> listByToBuildingId(Integer noticeToBuildingId);

    int insert(Notice notice);
}
