package com.shangxin.demo.service;

import com.shangxin.demo.pojo.Goodsparticulars;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsparticularsService {

    /**
     * 根据id来查询产品的详情
     * @param id
     * @return
     */
    Goodsparticulars findById(int id);

    /**
     * 根据id区查询产品id，进行数据回显，
     * @param id
     * @return
     */
    Goodsparticulars findgoods(int id);

    /**
     * 新增产品详情
     */
    void insertgoodssparticulars(Goodsparticulars goodsparticulars);

    /**
     * 上传图片，并返回图片相对地址
     * @param file   图片文件
     */
    String uploadimg(MultipartFile file);

    /**
     * 上传视频，并返回视频的路径
     * @param file  视频文件
     */
    String uploadvideo(MultipartFile file);

    /**
     * 修改产品详情
     */
    void updategoodssparticulars(Goodsparticulars goodsparticulars);


}
