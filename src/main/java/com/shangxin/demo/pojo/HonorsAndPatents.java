package com.shangxin.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_honorsandpatentsandactivity")
public class HonorsAndPatents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;  //主键id

    @Column(name = "img")
    private String img;   //图片地址

    @Column(name = "name")
    private String name;   //名字

    @Column(name = "classify")
    private String classify;    //分类

    @Column(name = "content")
    private String content;  //描述上下文

    @Column(name = "details_id")
    private String details_id;    //活动详情id(以为荣誉和专利没有详情)

    @Column(name = "time")
    private String time;            //创建时间

    @Column(name = "state")
    private String state;              //状态码

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getDetails_id() {
        return details_id;
    }

    public void setDetails_id(String details_id) {
        this.details_id = details_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
