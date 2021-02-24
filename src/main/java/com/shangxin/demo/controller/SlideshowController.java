package com.shangxin.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.pojo.Slideshow;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Slideshow")
@CrossOrigin
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    /**
     * 新增轮播图
     * @param slideshow
     * @return
     */
    @PostMapping("/insertslideshow")
    public Result insertslideshow(@RequestBody Slideshow slideshow){
        try {
            slideshowService.insertslideshow(slideshow);
            return new Result(true,"新增轮播图成功");
        }catch (Exception e){
            return new Result(false,"新增轮播图失败，或已存在");
        }

    }

    /**
     * 后台查询轮播图
     * @param currentpage
     * @return
     */
    @GetMapping("/selectslideshow/{currentpage}")
    public Result selectslideshow(@PathVariable("currentpage") int currentpage){
        if (currentpage<=0){
            return new Result(false,"传入的页数有误，请重试");
        }
        PageInfo selectslideshow = slideshowService.selectslideshow(currentpage);
        return new Result(true,"分页查询轮播图成功",selectslideshow);
    }

    /**
     * 删除轮播图
     * @param twoList
     * @return
     */
    @PostMapping("/deleteslideshow")
    public Result deleteslideshow(@RequestBody TwoList twoList){
        try {
            slideshowService.deleteslideshow(twoList);
            return new Result(true,"删除轮播图成功");
        }catch (Exception e){
            return new Result(false,"删除轮播图失败");
        }
    }


    /**
     * 修改轮播图
     * @param map
     * @return
     */
    @PostMapping("/updateslideshow")
    public Result updateslideshow(@RequestBody Map<String ,String> map){
        Integer id = Integer.valueOf(map.get("id"));
        String img = map.get("img");
        String name = map.get("name");
        try {
            slideshowService.updateslideshow(id,img,name);
            return new Result(true,"修改轮播图成功");
        }catch (Exception e){
            return new Result(false,"修改轮播图失败");
        }
    }
}
