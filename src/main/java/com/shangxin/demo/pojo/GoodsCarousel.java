package com.shangxin.demo.pojo;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 产品轮播图实体
 */
@Table(name = "index_goods_carousel")
public class GoodsCarousel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;     //主键id

    @Column(name = "img")
    private String img;     //图片地址

    @Column(name = "state")
    private String state;   //状态码

    @Column(name = "name")
    private String name;    //名字

    @Column(name = "goodsId")
    private Integer goodsId;   //产品id

    @Column(name = "classify")
    private Integer  classify;   //分类id

    @Column(name = "details_id")
    private Integer details_id;   //详情id

    public Integer getDetails_id() {
        return details_id;
    }

    public void setDetails_id(Integer details_id) {
        this.details_id = details_id;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
