package com.lquan.ops.model.po;

import java.util.Date;

public class QueOption {
    private Integer ID;

    private Integer questionID;

    private String code;

    private String title;

    private String imageUrl;

    private String videoUrl;

    private Boolean open;

    private String help;

    private Integer dispIndex;

    private Integer blankType;

    private Integer blankMax;

    private Integer blankMin;

    private Boolean blankOptional;

    private Integer value;

    private Boolean exclusive;

    private String thumbUrl;

    private Integer blankRows;

    private Integer blankCols;

    private Integer orientation;

    private Boolean showValue;

    private Boolean showTip;

    private Boolean showCancel;

    private Integer selectionMax;

    private Integer selectionMin;

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

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help == null ? null : help.trim();
    }

    public Integer getDispIndex() {
        return dispIndex;
    }

    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
    }

    public Integer getBlankType() {
        return blankType;
    }

    public void setBlankType(Integer blankType) {
        this.blankType = blankType;
    }

    public Integer getBlankMax() {
        return blankMax;
    }

    public void setBlankMax(Integer blankMax) {
        this.blankMax = blankMax;
    }

    public Integer getBlankMin() {
        return blankMin;
    }

    public void setBlankMin(Integer blankMin) {
        this.blankMin = blankMin;
    }

    public Boolean getBlankOptional() {
        return blankOptional;
    }

    public void setBlankOptional(Boolean blankOptional) {
        this.blankOptional = blankOptional;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl == null ? null : thumbUrl.trim();
    }

    public Integer getBlankRows() {
        return blankRows;
    }

    public void setBlankRows(Integer blankRows) {
        this.blankRows = blankRows;
    }

    public Integer getBlankCols() {
        return blankCols;
    }

    public void setBlankCols(Integer blankCols) {
        this.blankCols = blankCols;
    }

    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    public Boolean getShowValue() {
        return showValue;
    }

    public void setShowValue(Boolean showValue) {
        this.showValue = showValue;
    }

    public Boolean getShowTip() {
        return showTip;
    }

    public void setShowTip(Boolean showTip) {
        this.showTip = showTip;
    }

    public Boolean getShowCancel() {
        return showCancel;
    }

    public void setShowCancel(Boolean showCancel) {
        this.showCancel = showCancel;
    }

    public Integer getSelectionMax() {
        return selectionMax;
    }

    public void setSelectionMax(Integer selectionMax) {
        this.selectionMax = selectionMax;
    }

    public Integer getSelectionMin() {
        return selectionMin;
    }

    public void setSelectionMin(Integer selectionMin) {
        this.selectionMin = selectionMin;
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