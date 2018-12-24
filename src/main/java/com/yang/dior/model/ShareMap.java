package com.yang.dior.model;

import java.util.Date;

public class ShareMap {
    private Integer id;

    private Integer shareUid;

    private Integer shareFromUid;

    private Integer shareToUid;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShareUid() {
        return shareUid;
    }

    public void setShareUid(Integer shareUid) {
        this.shareUid = shareUid;
    }

    public Integer getShareFromUid() {
        return shareFromUid;
    }

    public void setShareFromUid(Integer shareFromUid) {
        this.shareFromUid = shareFromUid;
    }

    public Integer getShareToUid() {
        return shareToUid;
    }

    public void setShareToUid(Integer shareToUid) {
        this.shareToUid = shareToUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}