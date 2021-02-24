package com.shangxin.demo.controller;

import com.shangxin.demo.pojo.BigClassify;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.service.BigClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BigClassify")
@CrossOrigin
public class BigClassifyController {

    @Autowired
    private BigClassifyService groupBusinessService;

    /**
     * 查询集团业务分类
     * @return
     */
    @GetMapping("/GroupBusiness/findgroupBusiness")
    public Result findById(){
        List<BigClassify> list = groupBusinessService.findgroupBusiness();
        return new Result(true,"查询集团业务分类成功",list);
    }
}
