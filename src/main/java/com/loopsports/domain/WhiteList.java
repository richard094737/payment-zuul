package com.loopsports.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class WhiteList implements Serializable {

    private Long whiteListId;
    private Integer merId;
    private Integer merNo;
    //1-代付;2-其他
    private Integer listType;
    //listType为代付时，为IP地址；
    //listType为其他，为域名地址；
    private String listValue;
    //1-启用，listType跟listValue有值，2-不启用，listType跟listValue没值
    private Integer status;
    private String dataState;
    private Timestamp createTime;
    private Timestamp modifiedTime;

    public Long getWhiteListId() {
        return whiteListId;
    }

    public void setWhiteListId(Long whiteListId) {
        this.whiteListId = whiteListId;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public Integer getMerNo() {
        return merNo;
    }

    public void setMerNo(Integer merNo) {
        this.merNo = merNo;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
