package com.shangxin.demo.controller;

import com.shangxin.demo.pojo.Content1;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.service.Content1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Content1")
@RestController
@CrossOrigin
public class Content1Controller {

    @Autowired
    private Content1Service indexWisdomRead1Service;

    /**
     * 根据分类查询信息
     * @param classify
     * @return
     */
    @GetMapping("/IndexWisdomRead1/findByclassifyId/{id}")
    public Result findAllIndexWisdomRead1(@PathVariable("id") int classify){
        List<Content1> list = indexWisdomRead1Service.findAllIndexWisdomRead1(classify);
        return new Result(true,"查询数据成功",list);
    }
}
