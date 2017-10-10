package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.LostArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Mapper
public interface LostArticleDao {

    //列表(未下线的)
    List<LostArticle> list();

    //根据校区查询列表
    List<LostArticle> listByCampus(String campus);

    //根据类型查询列表
    List<LostArticle> listByType(String lostArticleType);

    //查询所有已下线的列表
    List<LostArticle> listOfOffline();

    //发布失物
    int insert(LostArticle lostArticle);

    //下线
    int offline(Integer lostArticleId);

    //批量下线
    int offlineBatch(List<Integer> lostArticle);
}
