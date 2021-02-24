package com.shangxin.demo.service.impl;


import com.shangxin.demo.dao.Content2Mapper;
import com.shangxin.demo.dao.GoodsparticularsMapper;
import com.shangxin.demo.pojo.Content2;
import com.shangxin.demo.pojo.Goodsparticulars;
import com.shangxin.demo.service.GoodsparticularsService;
import com.shangxin.demo.utils.ProdProcessOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Service
public class GoodsparticularsServiceimpl implements GoodsparticularsService {

    @Autowired
    private GoodsparticularsMapper goodsparticularsMapper;

    @Autowired
    private Content2Mapper content2Mapper;

    /**
     * 根据id查询详情数据
     * @param id
     * @return
     */
    @Override
    public Goodsparticulars findById(int id) {
        Goodsparticulars goodsparticulars = goodsparticularsMapper.findById(id);
        return goodsparticulars;
    }

    /**
     * 根据id区查询产品id，进行数据回显，
     * @param id
     * @return
     */
    @Override
    public Goodsparticulars findgoods(int id) {
        Goodsparticulars goodsparticulars = goodsparticularsMapper.selectByPrimaryKey(id);

        return goodsparticulars;
    }

    /**
     * 这里新增商品详情和商品目录
     * @param goodsparticulars
     */
    @Transactional(rollbackFor=RuntimeException.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void insertgoodssparticulars(Goodsparticulars goodsparticulars) {

        try {
            //去新增详情数据
            goodsparticularsMapper.insertgoodssparticulars(goodsparticulars);
        }catch (Exception e){
            //开启了事务，如果报错就回滚
            e.printStackTrace();
            throw new RuntimeException("新增产品详情失败");
        }

        //获取到传过来点值
        Content2 content2=new Content2();

        String centent = goodsparticulars.getResult();    //详情
        Integer product_id = goodsparticulars.getClassify();    //分类id
        Integer details_id = goodsparticulars.getId();     //详情id
        String name = goodsparticulars.getName();       //获取名字
        String img = goodsparticulars.getImg();       //获取图片
        //创建一个当前时间
        Date date=new Date();

        //日期格式化
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String createtime = simpleDateFormat.format(date);

        content2.setState("0");
        content2.setCentent(centent);
        content2.setName(name);
        content2.setProduct_id(product_id);
        content2.setDetails_id(details_id);
        content2.setImg(img);
        content2.setCreatetime(createtime);

        try {
            //去目录表新增数据
            content2Mapper.insertgoods(content2);
        }catch (Exception e){
            //开启了事务，如果报错就回滚
            e.printStackTrace();
            throw new RuntimeException("新增产品目录失败");
        }
    }

    /**
     * 这里修改商品详情和商品目录
     * @param goodsparticulars
     */
    @Transactional(rollbackFor=RuntimeException.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void updategoodssparticulars(Goodsparticulars goodsparticulars) {

        try {
            //去修改详情数据
            goodsparticularsMapper.updategoodssparticulars(goodsparticulars);
        }catch (Exception e){
            //开启了事务，如果报错就回滚
            e.printStackTrace();
            throw new RuntimeException("修改产品详情失败");
        }

        //获取到传过来点值
        Content2 content2=new Content2();
        String img = goodsparticulars.getImg();
        String centent = goodsparticulars.getResult();    //详情
        Integer product_id = goodsparticulars.getClassify();    //分类id
        Integer details_id = goodsparticulars.getId();     //详情id
        String name = goodsparticulars.getName();
        String state = goodsparticulars.getState();    //获取状态码

        content2.setImg(img);
        content2.setCentent(centent);
        content2.setName(name);
        content2.setProduct_id(product_id);
        content2.setDetails_id(details_id);
        content2.setState(state);

        try {
            //去目录表修改数据
            content2Mapper.updategoods(content2);
        }catch (Exception e){
            //开启了事务，如果报错就回滚
            e.printStackTrace();
            throw new RuntimeException("修改产品目录失败");
        }
    }


    /**
     * 上传图片，返回图片点相对路径
     * @param file
     */
    @Transactional(rollbackFor=Exception.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public String uploadimg(MultipartFile file) {
        if (file.isEmpty()){
            throw new RuntimeException("文件为空，请重试");
        }
        //获取文件大小
        if (file.getSize()>20971520 || file.getSize()<=0){
            throw new RuntimeException("文件大于20m或小于等于0b,请传正确数据");

        }

        //获取文件的名字信息
        String name = file.getOriginalFilename();

        //获取文件后缀
        String substring  =name.substring(name.lastIndexOf("."));

        //文件名我这里使用UUID和时间组成的
        String newFileNamePrefix= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date());
        String newFileName=newFileNamePrefix+"."+substring;
        //处理文件上传
        try {
            file.transferTo(new File("D:\\project\\upload",newFileName));

        }catch (Exception e){
            throw new RuntimeException("上传失败");
        }

        //如果没有问题就返回相对路径名
        return "img/"+newFileName;
    }

    /**
     * 上传视频，并返回视频的路径
     * @param file  视频文件
     */
    @Override
    public String uploadvideo(MultipartFile file) {
        if (file.isEmpty()){
            throw new RuntimeException("文件为空，请重试");
        }
        //获取文件大小
        if (file.getSize()>1073741824 || file.getSize()<=0){
            throw new RuntimeException("文件大于1G或小于等于0b,请传正确数据");
        }

        //获取文件的名字信息
        String name = file.getOriginalFilename();

        //获取文件后缀
        String substring = name.substring(name.length() - 3);

        //文件名我这里使用UUID和时间组成的
        String newFileNamePrefix= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String newFileName=newFileNamePrefix+"."+substring;
        //处理文件上传
        try {
            file.transferTo(new File("D:\\project\\upload",newFileName));
        }catch (Exception e){
            throw new RuntimeException("上传失败");
        }

        //如果没有问题就返回相对路径名
        return "video/"+newFileName;
    }

}
