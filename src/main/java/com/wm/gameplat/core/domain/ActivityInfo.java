package com.wm.gameplat.core.domain;



/**
 * 标签活动信息表 tab_activity_info
 */
public class ActivityInfo   {


    /**
     * id
     */
    private Long id;

    /**
     * 代理编码
     */
    private String superCode;

    /**
     * 描述
     */
    private String  description;

    /**
     * 0为公告，1为活动
     */
    private String  types;
    /**
     * 标题类型：0为图片，1为文本
     */
    private String  titleType;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容类型：0为图片，1为文本
     */
    private String contentType;

    /**
     * 内容
     */
    private String content;

    /**
     * 排序
     */
    private String orderNum;

    /**
     * 公告对应的图片id
     */
    private String picIds;

    /**
     * 玩家类型0普通/1试玩
     */
    private String playerType;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private String updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuperCode() {
        return superCode;
    }

    public void setSuperCode(String superCode) {
        this.superCode = superCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPicIds() {
        return picIds;
    }

    public void setPicIds(String picIds) {
        this.picIds = picIds;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ActivityInfo{" +
                "id=" + id +
                ", superCode='" + superCode + '\'' +
                ", description='" + description + '\'' +
                ", types='" + types + '\'' +
                ", titleType='" + titleType + '\'' +
                ", title='" + title + '\'' +
                ", contentType='" + contentType + '\'' +
                ", content='" + content + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", picIds='" + picIds + '\'' +
                ", playerType='" + playerType + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
