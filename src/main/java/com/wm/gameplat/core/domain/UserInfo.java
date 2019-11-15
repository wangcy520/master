package com.wm.gameplat.core.domain;

import java.util.Date;

/**
* @author zi
* @description 用户基础信息表（user_info）
* @date 2019-11-14
*/
public class UserInfo {

    
    /**
    * 用户Id
    */
    private Long userId;
    
    /**
    * 用户账号
    */
    private String userName;
    
    /**
    * 昵称
    */
    private String nickName;
    
    /**
    * 上级Id
    */
    private Long parentId;
    
    /**
    * 上级名称
    */
    private String parentName;
    
    /**
    * 真实姓名
    */
    private String relName;
    
    /**
    * 根代理
    */
    private Long rootId;
    
    /**
    * 登录密码
    */
    private String password;
    
    /**
    * 提现密码
    */
    private String cashPassword;
    
    /**
    * 电话号码
    */
    private String phoneNumber;
    
    /**
    * 是否已改密码
    */
    private String isChange;
    
    /**
    * 用户类型（0子账号 2代理账号 1会员账号 3推广账号 4试玩账号 5告警会员账号 6管理员）
    */
    private String userType;
    
    /**
    * 是否限制彩票投注
    */
    private String isLimitTicket;
    
    /**
    * 是否发放俸禄
    */
    private String isProvideSalary;
    
    /**
    * 盐加密
    */
    private String salt;
    
    /**
    * 用户性别（0男 1女 2未知）
    */
    private String sex;
    
    /**
    * 生日
    */
    private Date birthday;
    
    /**
    * 用户邮箱
    */
    private String email;
    
    /**
    * 微信号
    */
    private String wechat;
    
    /**
    * qq号
    */
    private String qq;
    
    /**
    * 用户状态1、启用 2、冻结 3、停用
    */
    private String status;
    
    /**
    * 备注
    */
    private String remark;
    
    /**
    * 注册方式:1-后台添加；2-推广注册
    */
    private String registerOrigin;
    
    /**
    * 注册IP
    */
    private String registerIp;
    
    /**
    * 注册时间
    */
    private Date registerTime;
    
    /**
    * 更新者
    */
    private String updateBy;
    
    /**
    * 更新时间
    */
    private Date updateTime;
    
    /**
    * 注册日期
    */
    private Date registerDate;
    
    /**
    * 浏览器
    */
    private String browser;
    
    /**
    * 操作系统
    */
    private String operatingSystem;
    
    /**
    * 返点等级
    */
    private Integer rebateId;
    
    /**
    * 会员等级
    */
    private Integer userLevel;
    
    /**
    * 会员模式-1现金、2信用
    */
    private String userModel;
    
    /**
    * 创建时间
    */
    private Date createTime;
    
    /**
    * 族谱
    */
    private String ancestralInfo;
    
    /**
    * 代理游戏大类占比，逗号分隔
    */
    private String extendProportionList;
    
    /**
    * 代理游戏大类，逗号分隔
    */
    private String extendGameList;
    
    /**
    * 密码强度
    */
    private String passStrength;
    
    /**
    * 密码ID
    */
    private Integer safetyId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    
    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }
    
    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCashPassword() {
        return cashPassword;
    }

    public void setCashPassword(String cashPassword) {
        this.cashPassword = cashPassword;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getIsChange() {
        return isChange;
    }

    public void setIsChange(String isChange) {
        this.isChange = isChange;
    }
    
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getIsLimitTicket() {
        return isLimitTicket;
    }

    public void setIsLimitTicket(String isLimitTicket) {
        this.isLimitTicket = isLimitTicket;
    }
    
    public String getIsProvideSalary() {
        return isProvideSalary;
    }

    public void setIsProvideSalary(String isProvideSalary) {
        this.isProvideSalary = isProvideSalary;
    }
    
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRegisterOrigin() {
        return registerOrigin;
    }

    public void setRegisterOrigin(String registerOrigin) {
        this.registerOrigin = registerOrigin;
    }
    
    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }
    
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
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
    
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
    
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    
    public Integer getRebateId() {
        return rebateId;
    }

    public void setRebateId(Integer rebateId) {
        this.rebateId = rebateId;
    }
    
    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
    
    public String getUserModel() {
        return userModel;
    }

    public void setUserModel(String userModel) {
        this.userModel = userModel;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getAncestralInfo() {
        return ancestralInfo;
    }

    public void setAncestralInfo(String ancestralInfo) {
        this.ancestralInfo = ancestralInfo;
    }
    
    public String getExtendProportionList() {
        return extendProportionList;
    }

    public void setExtendProportionList(String extendProportionList) {
        this.extendProportionList = extendProportionList;
    }
    
    public String getExtendGameList() {
        return extendGameList;
    }

    public void setExtendGameList(String extendGameList) {
        this.extendGameList = extendGameList;
    }
    
    public String getPassStrength() {
        return passStrength;
    }

    public void setPassStrength(String passStrength) {
        this.passStrength = passStrength;
    }
    
    public Integer getSafetyId() {
        return safetyId;
    }

    public void setSafetyId(Integer safetyId) {
        this.safetyId = safetyId;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                ", relName='" + relName + '\'' +
                ", rootId=" + rootId +
                ", password='" + password + '\'' +
                ", cashPassword='" + cashPassword + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isChange='" + isChange + '\'' +
                ", userType='" + userType + '\'' +
                ", isLimitTicket='" + isLimitTicket + '\'' +
                ", isProvideSalary='" + isProvideSalary + '\'' +
                ", salt='" + salt + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", wechat='" + wechat + '\'' +
                ", qq='" + qq + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", registerOrigin='" + registerOrigin + '\'' +
                ", registerIp='" + registerIp + '\'' +
                ", registerTime=" + registerTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", registerDate=" + registerDate +
                ", browser='" + browser + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", rebateId=" + rebateId +
                ", userLevel=" + userLevel +
                ", userModel='" + userModel + '\'' +
                ", createTime=" + createTime +
                ", ancestralInfo='" + ancestralInfo + '\'' +
                ", extendProportionList='" + extendProportionList + '\'' +
                ", extendGameList='" + extendGameList + '\'' +
                ", passStrength='" + passStrength + '\'' +
                ", safetyId=" + safetyId +
                '}';
    }
}