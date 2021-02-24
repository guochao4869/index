package com.shangxin.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.GoodsCarousel;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.GoodsCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/GoodsCarousel")
@RestController
@CrossOrigin(origins = "http://192.168.10.75:10086", maxAge = 3600)
public class GoodsCarouselController {

    @Autowired
    private GoodsCarouselService goodsCarouselService;

    /**
     * 查询所有状态码1且根据轮播图的id跳转到产品详情页面
     * @param goodsdetailsid
     * @return
     */
    @GetMapping("findGoodsCarouselBygoodsdetailsid/{goodsdetailsid}")
    public Result findGoodsCarouselBygoodsdetailsid(@PathVariable("goodsdetailsid") int goodsdetailsid){
        List<GoodsCarousel> list = goodsCarouselService.findGoodsCarouselBygoodsdetailsid(goodsdetailsid);
        return new Result(true,"查询成功",list);
    }

    /**
     * 查询上架的产品轮播图
     * @return
     */
    @GetMapping("/findGoodsCarouselAll")
    public Result findGoodsCarouselAll(){
        List<GoodsCarousel> goodsCarouselAll = goodsCarouselService.findGoodsCarouselAll();
        return new Result(true,"查询成功",goodsCarouselAll);
    }


    /**
     * 查询上架的产品轮播图
     * @return
     */
    @GetMapping("/findAll/{currentpage}")
    public Result findAll(@PathVariable("currentpage") Integer currentpage){
        if (currentpage<=0){
            return new Result(false,"页数输入有误，请重试");
        }
        PageInfo pageInfo = goodsCarouselService.findAll(currentpage);
        return new Result(true,"查询成功",pageInfo);
    }

    /**
     * 修改产品轮播图图片
     * @return
     */
    @PostMapping("/updateslideshow")
    public Result updateslideshow(@RequestBody Map<String,String> map){
        Integer id =  Integer.valueOf(map.get("id"));
        String img = map.get("img");
        String name = map.get("name");
        try {
            goodsCarouselService.updateslideshow(id,img,name);
            return new Result(true,"修改轮播图图片成功");
        }catch (Exception e){
            return new Result(false,"修改轮播图图片失败");
        }

    }

    /**
     * 删除产品轮播图
     * @return
     */
    @PostMapping("/deleteslideshow")
    public Result deleteslideshow(@RequestBody TwoList twoList){
        try {
            goodsCarouselService.deleteslideshow(twoList);
            return new Result(true,"删除轮播图成功");
        }catch (Exception e){
            return new Result(false,"删除轮播图失败");
        }

    }

    /**
     * 新增产品轮播图
     * @return
     */
    @PostMapping("/insertgoodscarousel")
    public Result insertgoodscarousel(@RequestBody GoodsCarousel goodsCarousel){
        try {
            goodsCarouselService.insertgoodscarousel(goodsCarousel);
            return new Result(true,"新增产品轮播图成功");
        }catch (Exception e){
            return new Result(false,"新增产品轮播图失败，可能已存在");
        }
    }

}
