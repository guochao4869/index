package com.shangxin.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "index_journalism_content")
public class JournalismContent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;   //主键id

    @Column(name = "name")
    private String name;   //标题名字

    @Column(name = "source")
    private String source;   //来源

    @Column(name = "time")
    private String time;      //发布时间

    @Column(name = "writer")
    private String writer;    //作者

    @Column(name = "content")
    private String content;   //文章内容

    @Column(name = "img")
    private String img;   //文章内容


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
