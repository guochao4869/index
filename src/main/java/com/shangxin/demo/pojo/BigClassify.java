package com.shangxin.demo.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "index_groupbusiness")
public class BigClassify implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;   //主键id

    @Column(name = "name")
    private String name;  //名字

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
}
