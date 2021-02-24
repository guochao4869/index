package com.shangxin.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_slideshow")
public class Slideshow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;        //主键id

    @Column(name = "img")
    private String img;        //图片地址

    @Column(name = "name")
    private String name;       //名字

    @Column(name = "classify")
    private String classify;   //哪个轮播的分类，中文展示

    @Column(name = "state")
    private String state;       //状态码，是其他表的状态码

    @Column(name = "details_id")
    private Integer details_id;  //详情id

    @Column(name = "fatherid")
    private String fatherid;    //父表的id

    public String getFatherid() {
        return fatherid;
    }

    public void setFatherid(String fatherid) {
        this.fatherid = fatherid;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getDetails_id() {
        return details_id;
    }

    public void setDetails_id(Integer details_id) {
        this.details_id = details_id;
    }
}
