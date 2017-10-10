package com.colorfulword.smallbluewhale.domain;

/**
 * 网址导航
 * Created by jone.sun on 2017/8/8.
 */
public class SiteNavigation {

    private Integer siteId;
    private String icon;
    private String name;
    private String url;
    private String group;


    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
