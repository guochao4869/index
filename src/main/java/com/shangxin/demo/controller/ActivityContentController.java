package com.shangxin.demo.controller;

import com.shangxin.demo.pojo.ActivityContent;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.ActivityContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ActivityContent")
@CrossOrigin
public class ActivityContentController {

    @Autowired
    private ActivityContentService activityContentService;

    /**
     * 根据活动目录里面点详情id去查询活动详情上架的
     * @param detailsid
     * @return
     */
    @GetMapping("/findActivityContent/{detailsid}")
    public Result findActivityContent(@PathVariable("detailsid") int detailsid){
        ActivityContent activityContent = activityContentService.findActivityContent(detailsid);
        return new Result(true,"查询成功",activityContent);
    }

    /**
     * 根据活动目录里面点详情id去查询活动详情所有的
     * @param detailsid
     * @return
     */
    @GetMapping("/findActivityContentAll/{detailsid}")
    public Result findActivityContentAll(@PathVariable("detailsid") int detailsid){
        ActivityContent activityContent = activityContentService.findActivityContentAll(detailsid);
        return new Result(true,"查询成功",activityContent);
    }

    @PostMapping("/insertActivityContent")
    public Result insertActivityContent(@RequestBody ActivityContent activityContent){
        try {
            activityContentService.insertActivityContent(activityContent);
            return new Result(true,"新增活动成功");
        }catch (Exception e){
            return new Result(false,"新增活动失败");
        }
    }

    /**
     * 修改活动
     * @param activityContent
     * @return
     */
    @PostMapping("/updateActivityContent")
    public Result updateActivityContent(@RequestBody ActivityContent activityContent){
        try {
            activityContentService.updateActivityContent(activityContent);
            return new Result(true,"修改活动成功");
        }catch (Exception e){
            return new Result(false,"修改活动失败");
        }
    }

    /**
     * 批量下架活动
     * @return
     */
    @PostMapping("/soldout")
    public Result soldout(@RequestBody TwoList twoList){
        try {
            activityContentService.soldout(twoList);
            return new Result(true,"批量下架活动成功");
        }catch (Exception e){
            return new Result(false,"批量下架活动失败");
        }

    }

    /**
     * 批量上架活动
     * @return
     */
    @PostMapping("/putaway")
    public Result putaway(@RequestBody TwoList twoList){
        try {
            activityContentService.putaway(twoList);
            return new Result(true,"批量上架活动成功");
        }catch (Exception e){
            return new Result(false,"批量上架活动失败");
        }

    }
}
