package com.lquan.ops.model.back.po;

import java.util.Date;

public class Question {
    private Integer ID;

    private Integer templateID;

    private Byte type;

    private String number;

    private String title;

    private String imageUrl;

    private String videoUrl;

    private Boolean optional;

    private String help;

    private Integer layout;

    private Integer dispIndex;

    private Integer selectionMax;

    private Integer selectionMin;

    private Boolean rowDisordered;

    private Boolean matrixPivot;

    private Boolean rowLastFixed;

    private Boolean colDisordered;

    private Boolean colLastFixed;

    private Integer columnCount;

    private Integer businessType;

    private Byte scoreType;

    private Boolean rowReverse;

    private Boolean colReverse;

    private Integer chartType;

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

    public Integer getTemplateID() {
        return templateID;
    }

    public void setTemplateID(Integer templateID) {
        this.templateID = templateID;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
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

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help == null ? null : help.trim();
    }

    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }

    public Integer getDispIndex() {
        return dispIndex;
    }

    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
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

    public Boolean getRowDisordered() {
        return rowDisordered;
    }

    public void setRowDisordered(Boolean rowDisordered) {
        this.rowDisordered = rowDisordered;
    }

    public Boolean getMatrixPivot() {
        return matrixPivot;
    }

    public void setMatrixPivot(Boolean matrixPivot) {
        this.matrixPivot = matrixPivot;
    }

    public Boolean getRowLastFixed() {
        return rowLastFixed;
    }

    public void setRowLastFixed(Boolean rowLastFixed) {
        this.rowLastFixed = rowLastFixed;
    }

    public Boolean getColDisordered() {
        return colDisordered;
    }

    public void setColDisordered(Boolean colDisordered) {
        this.colDisordered = colDisordered;
    }

    public Boolean getColLastFixed() {
        return colLastFixed;
    }

    public void setColLastFixed(Boolean colLastFixed) {
        this.colLastFixed = colLastFixed;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Byte getScoreType() {
        return scoreType;
    }

    public void setScoreType(Byte scoreType) {
        this.scoreType = scoreType;
    }

    public Boolean getRowReverse() {
        return rowReverse;
    }

    public void setRowReverse(Boolean rowReverse) {
        this.rowReverse = rowReverse;
    }

    public Boolean getColReverse() {
        return colReverse;
    }

    public void setColReverse(Boolean colReverse) {
        this.colReverse = colReverse;
    }

    public Integer getChartType() {
        return chartType;
    }

    public void setChartType(Integer chartType) {
        this.chartType = chartType;
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