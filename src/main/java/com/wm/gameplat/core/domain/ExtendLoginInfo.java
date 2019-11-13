package com.wm.gameplat.core.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
* @author zi
* @description 推广注册表（tab_extend_login）
* @date 2019-11-13
*/
public class ExtendLoginInfo {

    
    /**
    * 用户Id
    */
    private Integer userId;
    
    /**
    * 用户账号
    */
    private String userName;
    
    /**
    * 推广ID
    */
    private Integer extendId;
    
    /**
    * 推广渠道链接
    */
    private String extendHtml;
    
    /**
    * 推广码
    */
    private String extendCode;
    
    /**
    * 推广页面（0、首页，1、注册）
    */
    private String extendIndex;
    
    /**
    * 推广目标（0、用户，1、代理）
    */
    private String extendAimType;
    
    /**
    * 奖金（反水比例）
    */
    private BigDecimal extendProportion;
    
    /**
    * 访问量
    */
    private Integer visitCount;
    
    /**
    * 注册人数
    */
    private Integer registerCount;
    
    /**
    * 创建者
    */
    private String createBy;
    
    /**
    * 创建时间
    */
    private Date createTime;
    
    /**
    * 更新者
    */
    private String updateBy;
    
    /**
    * 更新时间
    */
    private Date updateTime;
    
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Integer getExtendId() {
        return extendId;
    }

    public void setExtendId(Integer extendId) {
        this.extendId = extendId;
    }
    
    public String getExtendHtml() {
        return extendHtml;
    }

    public void setExtendHtml(String extendHtml) {
        this.extendHtml = extendHtml;
    }
    
    public String getExtendCode() {
        return extendCode;
    }

    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
    }
    
    public String getExtendIndex() {
        return extendIndex;
    }

    public void setExtendIndex(String extendIndex) {
        this.extendIndex = extendIndex;
    }
    
    public String getExtendAimType() {
        return extendAimType;
    }

    public void setExtendAimType(String extendAimType) {
        this.extendAimType = extendAimType;
    }
    
    public BigDecimal getExtendProportion() {
        return extendProportion;
    }

    public void setExtendProportion(BigDecimal extendProportion) {
        this.extendProportion = extendProportion;
    }
    
    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }
    
    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }
    
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "ExtendLoginInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", extendId=" + extendId +
                ", extendHtml='" + extendHtml + '\'' +
                ", extendCode='" + extendCode + '\'' +
                ", extendIndex='" + extendIndex + '\'' +
                ", extendAimType='" + extendAimType + '\'' +
                ", extendProportion=" + extendProportion +
                ", visitCount=" + visitCount +
                ", registerCount=" + registerCount +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}