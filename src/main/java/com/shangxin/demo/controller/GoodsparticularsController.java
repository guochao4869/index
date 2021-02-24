package com.shangxin.demo.controller;

import com.shangxin.demo.pojo.Goodsparticulars;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.service.GoodsparticularsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Goodsparticulars")
@CrossOrigin
public class GoodsparticularsController {

    @Autowired
    private GoodsparticularsService goodsWisdomreadDetailsService;

    /**
     * 查看状态为上架状态的商品详情
     * @param id
     * @return
     */
    @GetMapping("/GoodsDetails/findById/{id}")
    public Result findById(@PathVariable("id") int id){
        Goodsparticulars result = goodsWisdomreadDetailsService.findById(id);
        return new Result(true,"查询产品详情成功",result);
    }

    /**
     * 查看商品详情
     * @param id
     * @return
     */
    @GetMapping("/findgoods/{id}")
    public Result findgoods(@PathVariable("id") int id){
        Goodsparticulars findgoods = goodsWisdomreadDetailsService.findgoods(id);
        return new Result(true,"商品详情查询成功",findgoods);
    }

    /**
     * 新增产品
     * @param goodsparticulars
     * @return
     */
    @PostMapping("/insertgoodssparticulars")
    public Result insertgoodssparticulars(@RequestBody(required = true) Goodsparticulars goodsparticulars){
        try {
            goodsWisdomreadDetailsService.insertgoodssparticulars(goodsparticulars);
        }catch (Exception e){
            return new Result(false,"新增产品失败");
        }
        return new Result(true,"新增产品成功");
    }

    /**
     * 修改产品
     * @param goodsparticulars
     * @return
     */
    @PostMapping("/updategoodssparticulars")
    public Result updategoodssparticulars(@RequestBody(required = true) Goodsparticulars goodsparticulars){
        try {
            goodsWisdomreadDetailsService.updategoodssparticulars(goodsparticulars);
        }catch (Exception e){
            return new Result(false,"修改产品失败");
        }
        return new Result(true,"修改产品成功");
    }

    /**
     * 图片的上传，返回相对路径
     * @param file
     * @return
     */
    @PostMapping("/uploadimg")
    public Result uploadimg(@RequestParam("imgfile") MultipartFile file){
        try {
            String img = goodsWisdomreadDetailsService.uploadimg(file);
            return new Result(true,"图片上传成功,返回相对路径",img);
        }catch (Exception e){
            return new Result(false,"图片上传失败");
        }
    }

    /**
     * 视频的上传，返回相对路径
     * @param file
     * @return
     */
    @PostMapping("/uploadvideo")
    public Result uploadvideo(@RequestParam("video") MultipartFile file){
        try {
            String img = goodsWisdomreadDetailsService.uploadvideo(file);
            return new Result(true,"视频上传成功,返回相对路径",img);
        }catch (Exception e){
            return new Result(false,"视频上传失败");
        }
    }


}
