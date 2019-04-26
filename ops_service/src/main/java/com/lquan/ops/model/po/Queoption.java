package com.lquan.ops.model.po;

import java.util.Date;

public class Queoption {
    private Integer id;

    private Integer questionid;

    private String code;

    private String title;

    private String imageurl;

    private String videourl;

    private Boolean open;

    private String help;

    private Short dispindex;

    private Short blanktype;

    private Short blankmax;

    private Short blankmin;

    private Boolean blankoptional;

    private Short value;

    private Boolean exclusive;

    private String thumburl;

    private Short blankrows;

    private Short blankcols;

    private Short orientation;

    private Short showvalue;

    private Short showtip;

    private Short showcancel;

    private Short selectionmax;

    private Short selectionmin;

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

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
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

    public Short getDispindex() {
        return dispindex;
    }

    public void setDispindex(Short dispindex) {
        this.dispindex = dispindex;
    }

    public Short getBlanktype() {
        return blanktype;
    }

    public void setBlanktype(Short blanktype) {
        this.blanktype = blanktype;
    }

    public Short getBlankmax() {
        return blankmax;
    }

    public void setBlankmax(Short blankmax) {
        this.blankmax = blankmax;
    }

    public Short getBlankmin() {
        return blankmin;
    }

    public void setBlankmin(Short blankmin) {
        this.blankmin = blankmin;
    }

    public Boolean getBlankoptional() {
        return blankoptional;
    }

    public void setBlankoptional(Boolean blankoptional) {
        this.blankoptional = blankoptional;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl == null ? null : thumburl.trim();
    }

    public Short getBlankrows() {
        return blankrows;
    }

    public void setBlankrows(Short blankrows) {
        this.blankrows = blankrows;
    }

    public Short getBlankcols() {
        return blankcols;
    }

    public void setBlankcols(Short blankcols) {
        this.blankcols = blankcols;
    }

    public Short getOrientation() {
        return orientation;
    }

    public void setOrientation(Short orientation) {
        this.orientation = orientation;
    }

    public Short getShowvalue() {
        return showvalue;
    }

    public void setShowvalue(Short showvalue) {
        this.showvalue = showvalue;
    }

    public Short getShowtip() {
        return showtip;
    }

    public void setShowtip(Short showtip) {
        this.showtip = showtip;
    }

    public Short getShowcancel() {
        return showcancel;
    }

    public void setShowcancel(Short showcancel) {
        this.showcancel = showcancel;
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