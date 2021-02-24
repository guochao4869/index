package com.shangxin.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_journalism")
public class Journalism implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;    //主键id

    @Column(name = "name")
    private String name;    //标题名字

    @Column(name = "time")
    private String time;    //时间

    @Column(name = "result")
    private String result;   //新闻描述内容

    @Column(name = "img")
    private String img;      //图片

    @Column(name = "details_id")
    private Integer details_id;    //新闻详情id


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
