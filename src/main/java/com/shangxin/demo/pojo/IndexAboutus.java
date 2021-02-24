package com.shangxin.demo.pojo;



import javax.persistence.*;
import java.io.Serializable;


@Table(name="index_aboutus")
public class IndexAboutus implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//主键


    @Column(name = "img")
	private String img;//图片


    @Column(name = "state")
	private String state;//状态

    @Column(name = "content")
	private String content;//详情



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getImg() {
		return img;
	}

	//set方法
	public void setImg(String img) {
		this.img = img;
	}
	//get方法
	public String getState() {
		return state;
	}

	//set方法
	public void setState(String state) {
		this.state = state;
	}
	//get方法
	public String getContent() {
		return content;
	}

	//set方法
	public void setContent(String content) {
		this.content = content;
	}


}
