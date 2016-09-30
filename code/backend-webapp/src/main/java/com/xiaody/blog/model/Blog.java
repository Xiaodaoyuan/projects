package com.xiaody.blog.model;

/**
 * Created by Xiaody on 2016/9/29.
 */
public class Blog extends BaseModel {
    private Integer userId;
    private String title;
    private String summary;
    private String content;
    private String categoryCode;
    private String tags;
    private String[] tagsArr;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String[] getTagsArr() {
        return tagsArr;
    }

    public void setTagsArr(String[] tagsArr) {
        this.tagsArr = tagsArr;
    }
}
