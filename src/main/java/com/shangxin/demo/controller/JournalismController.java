package com.shangxin.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.JournalismResult;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.JournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Journalism")
@CrossOrigin
public class JournalismController {

    @Autowired
    private JournalismService journalismService;

    /**
     * 查询所有已上架的新闻分页
     * @param page
     * @return
     */
    @GetMapping("/findAllPage/{page}")
    public Result findAllPage(@PathVariable("page") int page){
        if (page<=0){
            return new Result(false,"输入的分页条件有误，请重试");
        }

        PageInfo pageInfo = journalismService.findAllPage(page);
        return new Result(true,"查询成功",pageInfo);
    }

    /**
     * 新闻下架
     * @param twoList
     * @return
     */
    @PostMapping("/soldout")
    public Result soldout(@RequestBody TwoList twoList){
        try {
            journalismService.soldout(twoList);
            return new Result(true,"新闻下架成功");
        }catch (Exception e){
            return new Result(false,"新闻下架失败");
        }
    }

    /**
     * 新闻上架
     * @param twoList
     * @return
     */
    @PostMapping("/onthenews")
    public Result onthenews(@RequestBody TwoList twoList){
        try {
            journalismService.onthenews(twoList);
            return new Result(true,"新闻上架成功");
        }catch (Exception e){
            return new Result(false,"新闻上架失败");
        }
    }

    /**
     * 批量删除新闻
     * @param twoList
     * @return
     */
    @PostMapping("/deletejournalism")
    public Result deletejournalism(@RequestBody TwoList twoList){
        try {
            journalismService.deletejournalism(twoList);
            return new Result(true,"新闻删除成功");
        }catch (Exception e){
            return new Result(false,"新闻删除失败");
        }
    }

    @PostMapping("/conditionquery/{currentpage}")
    public Result conditionquery(@RequestBody JournalismResult journalismResult,@PathVariable("currentpage") int currentpage){
        if (currentpage<=0){
            return new Result(false,"输入的分页页数有误，请重试");
        }
        PageInfo conditionquery = journalismService.conditionquery(journalismResult, currentpage);
        return new Result(true,"查询成功",conditionquery);
    }


}
