package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.SiteNavigation;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
public interface SiteNavigationDao {

    List<SiteNavigation> list();

    int insert(SiteNavigation siteNavigation);

    int delete(Integer siteId);

    int update(SiteNavigation siteNavigation);
}
