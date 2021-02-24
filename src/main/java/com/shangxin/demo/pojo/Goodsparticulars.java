package com.shangxin.demo.pojo;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_goods_details")
public class Goodsparticulars implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;  //主键Id

    @Column(name = "name")
    private String name;  //名字

    @Column(name = "img")
    private String img;    //图片地址

    @Column(name = "smallname")
    private String smallname;   //小名字

    @Column(name = "length")
    private String length;      //长度

    @Column(name = "result")
    private String result;      //描述

    @Column(name = "video")
    private String video;       //视频链接

    @Column(name = "videodescribe")
    private String videodescribe;   //视频描述

    @Column(name = "goodsshowname")
    private String goodsshowname;

    @Column(name = "goodsshowimg")
    private String goodsshowimg;

    @Column(name = "classify")
    private Integer classify;

    @Column(name = "state")
    private String state;    //状态码

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }
    public String getVideodescribe() {
        return videodescribe;
    }

    public void setVideodescribe(String videodescribe) {
        this.videodescribe = videodescribe;
    }

    public String getGoodsshowname() {
        return goodsshowname;
    }

    public void setGoodsshowname(String goodsshowname) {
        this.goodsshowname = goodsshowname;
    }

    public String getGoodsshowimg() {
        return goodsshowimg;
    }

    public void setGoodsshowimg(String goodsshowimg) {
        this.goodsshowimg = goodsshowimg;
    }

    public String getShowimgdescribe() {
        return showimgdescribe;
    }

    public void setShowimgdescribe(String showimgdescribe) {
        this.showimgdescribe = showimgdescribe;
    }

    @Column(name = "showimgdescribe")
    private String showimgdescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSmallname() {
        return smallname;
    }

    public void setSmallname(String smallname) {
        this.smallname = smallname;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}
