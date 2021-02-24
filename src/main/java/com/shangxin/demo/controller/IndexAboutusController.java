package com.shangxin.demo.controller;



import com.shangxin.demo.pojo.IndexAboutus;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.pojo.Slideshow;
import com.shangxin.demo.service.IndexAboutusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Description:
 *****/
@RestController
@RequestMapping("/index")
@CrossOrigin
public class IndexAboutusController {

    @Autowired
    private IndexAboutusService indexAboutusService;

    /***
     * 查询关于我们上架状态的轮播图
     * @return
     */
    @GetMapping("/indexAboutus")
    public Result findAll(){
        //调用IndexAboutusService实现查询所有IndexAboutus
        List<Slideshow> list = indexAboutusService.findAll();
        return new Result(true, "查询成功",list) ;
    }

    @GetMapping("/selectAll")
    public Result selectAll(){
        List<IndexAboutus> list = indexAboutusService.selectAll();
        return new Result(true,"查询成功",list);
    }
}
