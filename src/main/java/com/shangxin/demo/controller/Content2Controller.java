package com.shangxin.demo.controller;


import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.Content2;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.Content2Service;
import com.shangxin.demo.service.GoodsparticularsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/Content2")
@RestController
@CrossOrigin
public class Content2Controller {

    @Autowired
    private Content2Service content2Service;


    /**
     * 分页查询分类的数据
     * @param curPage   当前页数
     * @param product_id   分类的id
     * @return
     */
    @GetMapping("/IndexWisdomRead2/findAllPage/{curPage}/{product_id}")
    public Result findAllPage(@PathVariable("curPage")int curPage,@PathVariable("product_id")int  product_id){
        if (curPage<=0){
            return new Result(false,"该页数不合法，请重试");
        }
        PageInfo list = content2Service.findPage(curPage, product_id);

        return new Result(true,"查询产品成功",list);
    }

    /**
     * 后台查所有产品数据
     * @param currentpage
     * @return
     */
    @GetMapping("/findgoods/{currentpage}")
    public Result findgoods(@PathVariable("currentpage") int currentpage){
        if (currentpage<=0){
            return new Result(false,"该页数不合法，请重试");
        }
        PageInfo findgoods = content2Service.findgoods(currentpage);
        return new Result(true,"查询成功",findgoods);
    }

    /**
     * 商品的下架
     * @param twoList
     * @return
     */
    @PostMapping("/soldout")
    public Result soldout(@RequestBody TwoList twoList){
        try {
            content2Service.soldout(twoList);
            return new Result(true,"商品下架成功");
        }catch (Exception e){
            return new Result(false,"商品下架失败");
        }
    }

    /**
     * 商品的上架
     * @param twoList
     * @return
     */
    @PostMapping("/goodsshelves")
    public Result goodsshelves(@RequestBody TwoList twoList){
        try {
            content2Service.goodsshelves(twoList);
            return new Result(true,"商品上架成功");
        }catch (Exception e){
            return new Result(false,"商品上架失败");
        }
    }

    /**
     * 条件查询产品
     * @param content2 查询点条件
     */
    @PostMapping("/likeselect/{currentpage}")
    public Result likeselect(@RequestBody Content2 content2,@PathVariable("currentpage") int currentpage){
        try {
            PageInfo likeselect = content2Service.likeselect(content2,currentpage);
            return new Result(true,"查询成功",likeselect);

        }catch (Exception e){
            return new Result(false,"查询失败");
        }
    }

    /**
     * 商品的批量删除
     * @param twoList
     * @return
     */
    @PostMapping("/deletegoods")
    public Result deletegoods(@RequestBody TwoList twoList){
        try {
            content2Service.deletegoods(twoList);
            return new Result(true,"商品删除成功");
        }catch (Exception e){
            return new Result(false,"商品删除失败");
        }
    }

}
