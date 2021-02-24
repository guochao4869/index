package com.shangxin.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.HonorsAndPatents;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.HonorsAndPatentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HonorsAndPatents")
@CrossOrigin
public class HonorsAndPatentsController {

    @Autowired
    private HonorsAndPatentsService honorsAndPatentsService;

    /**
     * 查询上线的荣誉
     * @return
     */
    @GetMapping("/findHonorsAll")
    public Result findHonorsAll(){
        List<HonorsAndPatents> honorsAndPatentsMapperAll = honorsAndPatentsService.findHonorsAll();
        return new Result(true,"查询成功",honorsAndPatentsMapperAll);
    }

    /**
     * 查询上线的专利
     * @return
     */
    @GetMapping("/findPatentsAll")
    public Result findPatentsAll(){
        List<HonorsAndPatents> patentsAll = honorsAndPatentsService.findPatentsAll();
        return new Result(true,"查询成功",patentsAll);
    }

    /**
     * 查询上线的活动
     * @return
     */
    @GetMapping("/findactivityAll")
    public Result findactivityAll(){
        List<HonorsAndPatents> honorsAndPatents = honorsAndPatentsService.findactivityAll();
        return new Result(true,"查询成功",honorsAndPatents);
    }

    /**
     * 查询荣誉
     * @return
     */
    @GetMapping("/findHonors/{id}")
    public Result findHonors(@PathVariable("id") int currentpage ){
        if (currentpage<=0){
            return new Result(false,"输入的页数错误，请重试");
        }
        PageInfo pageInfo = honorsAndPatentsService.findHonors(currentpage);
        return new Result(true,"查询成功",pageInfo);
    }

    /**
     * 查询专利
     * @return
     */
    @GetMapping("/findPatents/{id}")
    public Result findPatents(@PathVariable("id") int currentpage){
        if (currentpage<=0){
            return new Result(false,"输入的页数错误，请重试");
        }
        PageInfo pageInfo = honorsAndPatentsService.findPatents(currentpage);
        return new Result(true,"查询成功",pageInfo);
    }

    /**
     * 查询活动
     * @return
     */
    @GetMapping("/findactivity/{id}")
    public Result findactivity(@PathVariable("id") int currentpage){
        if (currentpage<=0){
            return new Result(false,"输入的页数错误，请重试");
        }
        PageInfo pageInfo = honorsAndPatentsService.findactivity(currentpage);
        return new Result(true,"查询成功",pageInfo);
    }

    /**
     * 批量删除活动
     */
    @PostMapping("/deleteactivity")
    public Result deleteactivity(@RequestBody(required = false) TwoList twoList){
        try {
            honorsAndPatentsService.deleteactivity(twoList);
            return new Result(true,"活动删除成功");
        }catch (Exception e){
            return new Result(false,"活动删除失败");
        }
    }

    /**
     * 新增集团荣誉
     */
    @PostMapping("/insertHonors")
    public Result insertHonors(@RequestBody HonorsAndPatents honorsAndPatents){
        try {
            honorsAndPatentsService.insertHonors(honorsAndPatents);
            return new Result(true,"荣誉新增成功");
        }catch (Exception e){
            return new Result(false,"荣誉新增失败");
        }
    }

    /**
     * 修改集团荣誉或专利
     */
    @PostMapping("/updateHonorsAndPatents")
    public Result updateHonorsAndPatents(@RequestBody(required = false) HonorsAndPatents honorsAndPatents){
        try {
            honorsAndPatentsService.updateHonorsAndPatents(honorsAndPatents);
            return new Result(true,"修改集团荣誉或专利成功");
        }catch (Exception e){
            return new Result(false,"修改集团荣誉或专利失败");
        }
    }

    /**
     * 新增专利
     */
    @PostMapping("/insertPatents")
    public Result insertPatents(@RequestBody HonorsAndPatents honorsAndPatents){

        try {
            honorsAndPatentsService.insertPatents(honorsAndPatents);
            return new Result(true,"专利新增成功");
        }catch (Exception e){
            return new Result(false,"专利新增失败");
        }
    }


    /**
     * 批量上架荣誉或者专利
     * @param twoList
     * @return
     */
    @PostMapping("/putaway")
    public Result putaway(@RequestBody TwoList twoList){
        try {
            honorsAndPatentsService.putaway(twoList);
            return new Result(true,"批量上架成功");
        }catch (Exception e){
            return new Result(false,"批量上架失败");
        }
    }

    /**
     * 批量下架荣誉或者专利
     * @param twoList
     * @return
     */
    @PostMapping("/soldout")
    public Result soldout(@RequestBody TwoList twoList){
        try {
            honorsAndPatentsService.soldout(twoList);
            return new Result(true,"批量下架成功");
        }catch (Exception e){
            return new Result(false,"批量下架失败");
        }
    }


    /**
     * 批量删除荣誉或者专利
     * @param twoList
     * @return
     */
    @PostMapping("/batchdelete")
    public Result batchdelete(@RequestBody TwoList twoList){
        try {
            honorsAndPatentsService.batchdelete(twoList);
            return new Result(true,"批量删除成功");
        }catch (Exception e){
            return new Result(false,"批量删除失败");
        }
    }
}
