package com.shangxin.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_activitycontent")
public class ActivityContent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;       //主键id

    @Column(name = "starttime")
    private String starttime;    //活动开始时间

    @Column(name = "endtime")
    private String endtime;     //活动结束世界

    @Column(name = "site")
    private String site;         //活动地址

    @Column(name = "content")
    private String content;      //活动内容

    @Column(name = "title")
    private String title;        //活动标题

    @Column(name = "img")
    private String img;        //图片

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
