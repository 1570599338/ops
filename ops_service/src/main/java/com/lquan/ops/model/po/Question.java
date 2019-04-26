package com.lquan.ops.model.po;

import java.util.Date;

public class Question {
    private Integer id;

    private Integer templateid;

    private Byte type;

    private String number;

    private String title;

    private String imageurl;

    private String videourl;

    private Boolean optional;

    private String help;

    private Short layout;

    private Short dispindex;

    private Short selectionmax;

    private Short selectionmin;

    private Boolean rowdisordered;

    private Boolean matrixpivot;

    private Boolean rowlastfixed;

    private Boolean coldisordered;

    private Boolean collastfixed;

    private Short columncount;

    private Integer businesstype;

    private Byte scoretype;

    private Boolean rowreverse;

    private Boolean colreverse;

    private Short charttype;

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

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
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

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
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

    public Short getLayout() {
        return layout;
    }

    public void setLayout(Short layout) {
        this.layout = layout;
    }

    public Short getDispindex() {
        return dispindex;
    }

    public void setDispindex(Short dispindex) {
        this.dispindex = dispindex;
    }

    public Short getSelectionmax() {
        return selectionmax;
    }

    public void setSelectionmax(Short selectionmax) {
        this.selectionmax = selectionmax;
    }

    public Short getSelectionmin() {
        return selectionmin;
    }

    public void setSelectionmin(Short selectionmin) {
        this.selectionmin = selectionmin;
    }

    public Boolean getRowdisordered() {
        return rowdisordered;
    }

    public void setRowdisordered(Boolean rowdisordered) {
        this.rowdisordered = rowdisordered;
    }

    public Boolean getMatrixpivot() {
        return matrixpivot;
    }

    public void setMatrixpivot(Boolean matrixpivot) {
        this.matrixpivot = matrixpivot;
    }

    public Boolean getRowlastfixed() {
        return rowlastfixed;
    }

    public void setRowlastfixed(Boolean rowlastfixed) {
        this.rowlastfixed = rowlastfixed;
    }

    public Boolean getColdisordered() {
        return coldisordered;
    }

    public void setColdisordered(Boolean coldisordered) {
        this.coldisordered = coldisordered;
    }

    public Boolean getCollastfixed() {
        return collastfixed;
    }

    public void setCollastfixed(Boolean collastfixed) {
        this.collastfixed = collastfixed;
    }

    public Short getColumncount() {
        return columncount;
    }

    public void setColumncount(Short columncount) {
        this.columncount = columncount;
    }

    public Integer getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(Integer businesstype) {
        this.businesstype = businesstype;
    }

    public Byte getScoretype() {
        return scoretype;
    }

    public void setScoretype(Byte scoretype) {
        this.scoretype = scoretype;
    }

    public Boolean getRowreverse() {
        return rowreverse;
    }

    public void setRowreverse(Boolean rowreverse) {
        this.rowreverse = rowreverse;
    }

    public Boolean getColreverse() {
        return colreverse;
    }

    public void setColreverse(Boolean colreverse) {
        this.colreverse = colreverse;
    }

    public Short getCharttype() {
        return charttype;
    }

    public void setCharttype(Short charttype) {
        this.charttype = charttype;
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