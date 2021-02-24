package com.shangxin.demo.pojo;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_goodscontent2")
public class Content2 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;    //主键id

    @Column(name = "img")
    private String img;   //图片地址

    @Column(name = "centent")
    private String centent;  //描述

    @Column(name = "state")
    private String state;     //状态码  0下架.1上架，2删除

    @Column(name = "product_id")
    private Integer product_id;    //外键，分类的id

    @Column(name = "name")
    private String name;    //名字

    @Column(name = "details_id")
    private Integer details_id;    //详情id

    @Column(name = "createtime")
    private String createtime;     //创建时间

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getDetails_id() {
        return details_id;
    }

    public void setDetails_id(Integer details_id) {
        this.details_id = details_id;
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

    public String getCentent() {
        return centent;
    }

    public void setCentent(String centent) {
        this.centent = centent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
