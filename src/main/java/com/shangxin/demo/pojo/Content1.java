package com.shangxin.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_goodscontent1")
public class Content1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;   //主键Id

    @Column(name = "img")
    private String img;     //图片地址

    @Column(name = "name")
    private String name;     //名字

    @Column(name = "content")
    private String content;    //上下文

    @Column(name = "englishname")
    private String englishname;    //英文名字

    @Column(name = "classify")
    private String classify;         //分类

    @Column(name = "introduce")
    private String introduce;  //介绍

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEnglishname() {
        return englishname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
