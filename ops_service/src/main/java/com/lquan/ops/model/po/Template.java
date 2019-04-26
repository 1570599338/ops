package com.lquan.ops.model.po;

import java.util.Date;

public class Template {
    private Integer id;

    private Integer projectid;

    private String name;

    private String alias;

    private String remark;

    private Short state;

    private String guide;

    private Boolean signagreement;

    private Short rank;

    private Boolean goback;

    private Short participantmask;

    private Integer waitbeforenext;

    private Boolean active;

    private Date createdat;

    private String createdby;

    private Date updatedat;

    private String updatedby;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide == null ? null : guide.trim();
    }

    public Boolean getSignagreement() {
        return signagreement;
    }

    public void setSignagreement(Boolean signagreement) {
        this.signagreement = signagreement;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public Boolean getGoback() {
        return goback;
    }

    public void setGoback(Boolean goback) {
        this.goback = goback;
    }

    public Short getParticipantmask() {
        return participantmask;
    }

    public void setParticipantmask(Short participantmask) {
        this.participantmask = participantmask;
    }

    public Integer getWaitbeforenext() {
        return waitbeforenext;
    }

    public void setWaitbeforenext(Integer waitbeforenext) {
        this.waitbeforenext = waitbeforenext;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby == null ? null : createdby.trim();
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby == null ? null : updatedby.trim();
    }
}