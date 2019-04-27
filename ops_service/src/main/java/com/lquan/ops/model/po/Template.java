package com.lquan.ops.model.po;

import java.util.Date;

public class Template {
    private Integer ID;

    private Integer projectID;

    private String name;

    private String alias;

    private String remark;

    private Integer state;

    private String guide;

    private Boolean signAgreement;

    private Integer rank;

    private Boolean goBack;

    private Integer participantMask;

    private Integer waitBeforeNext;

    private Boolean active;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide == null ? null : guide.trim();
    }

    public Boolean getSignAgreement() {
        return signAgreement;
    }

    public void setSignAgreement(Boolean signAgreement) {
        this.signAgreement = signAgreement;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Boolean getGoBack() {
        return goBack;
    }

    public void setGoBack(Boolean goBack) {
        this.goBack = goBack;
    }

    public Integer getParticipantMask() {
        return participantMask;
    }

    public void setParticipantMask(Integer participantMask) {
        this.participantMask = participantMask;
    }

    public Integer getWaitBeforeNext() {
        return waitBeforeNext;
    }

    public void setWaitBeforeNext(Integer waitBeforeNext) {
        this.waitBeforeNext = waitBeforeNext;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }
}