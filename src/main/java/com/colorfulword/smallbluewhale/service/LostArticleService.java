package com.colorfulword.smallbluewhale.service;

import com.colorfulword.smallbluewhale.dao.LostArticleDao;
import com.colorfulword.smallbluewhale.domain.LostArticle;
import com.colorfulword.smallbluewhale.domain.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.colorfulword.smallbluewhale.ResponseBodyCode.ERROR;
import static com.colorfulword.smallbluewhale.ResponseBodyCode.SUCCESS;

/**
 * Created by jone.sun on 2017/8/10.
 */
@Service
public class LostArticleService extends FileUploadDownloadService {

    @Autowired
    private LostArticleDao dao;

    @Override
    String getModelName() {
        return "lostArticle";
    }

    //列表(未下线的)
    public ResponseBody<List<LostArticle>> list() {
        offlineBatch();
        return new ResponseBody<>(SUCCESS, "", dao.list());
    }

    //根据校区查询列表(未下线的)
    public ResponseBody<List<LostArticle>> listByCampus(String campus) {
        return new ResponseBody<>(SUCCESS, "", dao.listByCampus(campus));
    }

    //根据类型查询列表(未下线的)
    public ResponseBody<List<LostArticle>> listByType(String lostArticleType) {
        return new ResponseBody<>(SUCCESS, "", dao.listByType(lostArticleType));
    }

    //查询所有已下线的列表(未下线的)
    public ResponseBody<List<LostArticle>> listOfOffline() {
        return new ResponseBody<>(SUCCESS, "", dao.listOfOffline());
    }

    //发布失物
    public ResponseBody<Boolean> insert(Integer publisherId, String lostUser, String lostUserMobile,
                                        String lostArticleName, String campus, String position,
                                        String lostArticleType, MultipartFile file) {
        offlineBatch();
        String picUrl = saveWithReturnUrl(System.currentTimeMillis() + "", "pic", file);
        LostArticle lostArticle = new LostArticle();
        lostArticle.setPublisherId(publisherId);
        lostArticle.setLostUser(lostUser);
        lostArticle.setLostUserMobile(lostUserMobile);
        lostArticle.setLostArticleName(lostArticleName);
        lostArticle.setCampus(campus);
        lostArticle.setPosition(position);
        lostArticle.setLostArticleType(lostArticleType);
        lostArticle.setLostArticlePic(picUrl);
        if (dao.insert(lostArticle) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    //下线
    public ResponseBody<Boolean> offline(Integer lostArticleId) {
        if (dao.offline(lostArticleId) > 0) {
            return new ResponseBody<>(SUCCESS, "success", true);
        }
        return new ResponseBody<>(ERROR, "error", false);
    }

    //批量下线
    private void offlineBatch() {
        List<LostArticle> lostArticleList = dao.list();
        if (lostArticleList != null && lostArticleList.size() > 0) {
            List<Integer> lostArticleIdList = new ArrayList<>();
            Timestamp timestampBefore14 = getDate(-14);
            for (LostArticle lostArticle : lostArticleList) {
                if (lostArticle.getPublishTime().before(timestampBefore14)) { //超过14天自动下线
                    lostArticleIdList.add(lostArticle.getLostArticleId());
                }
            }
            if (lostArticleIdList.size() > 0) {
                try {
                    dao.offlineBatch(lostArticleIdList);
                } catch (Exception e) {
                    System.err.println("批量下线失败");
                }
            }
        }
    }

    /***
     * 获取前后日期 i为正数 向后推迟i天，负数时向前提前i天
     * @param i
     * @return
     */
    private Timestamp getDate(int i) {
        Date dat = null;
        Calendar cd = Calendar.getInstance();
        cd.add(Calendar.DATE, i);
        dat = cd.getTime();
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp date = Timestamp.valueOf(dformat.format(dat));
        return date;
    }
}
