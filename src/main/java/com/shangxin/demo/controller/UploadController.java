package com.shangxin.demo.controller;


import com.shangxin.demo.pojo.Result;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/setmeal")
@CrossOrigin
public class UploadController {

    /**
     * 七牛云上传图片
     * @param imgFile
     * @return
     */
    /*@PostMapping("/upload")
    public Result upload(MultipartFile imgFile){
        //- 获取原有图片名称，截取到后缀名
        String originalFilename = imgFile.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        //- 生成唯一文件名，拼接后缀名
        String filename = UUID.randomUUID() + extension;
        //- 调用七牛上传文件
        try {
            QiNiuUtils.uploadViaByte(imgFile.getBytes(), filename);
            //- 返回数据给页面
            //{
            //    flag:
            //    message:
            //    data:{
            //        imgName: 图片名,
            //        domain: QiNiuUtils.DOMAIN
            //    }
            //}
            Map<String,String> map = new HashMap<String,String>();
            map.put("imgName",filename);
            map.put("domain", QiNiuUtils.DOMAIN);
            return new Result(true, "成功",map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(false, "失败");
    }

    @GetMapping("/findlist")
    public Result list(){
        List<String> strings = QiNiuUtils.listFile();
        
        return new Result(true,"图片查询成功",strings);
    }*/

    //配置文件配控制图片大小     servlet:
    //    multipart:
    //      max-file-size: 3MB
    /**
     * 文件上传测试用接口
     * @param file
     * @return
     */
    //处理文件上传的方法
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile file)  {

        if (file.isEmpty()){
            return new Result(false,"文件为空，请重试");
        }
        //获取文件的名字信息
        String name = file.getOriginalFilename();

        //图片大小
        long size = file.getSize();
        System.out.println("图片大小为："+size);

        if (size>31457280 || size<=0){
            return new Result(false,"文件大于30m或小于等于0b,请传正确数据");
        }

        //获取文件后缀
        String substring = name.substring(name.length() - 3);

        //文件名我这里使用UUID和时间组成的
        String newFileNamePrefix= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date());
        String newFileName=newFileNamePrefix+"."+substring;
        //处理文件上传
        try {
            //file.transferTo(new File("D:\\project\\index\\src\\main\\resources\\static",newFileName));
            file.transferTo(new File("D:\\project\\upload",newFileName));
        }catch (Exception e){
            return new Result(false,"上传失败");
        }

        //上传成功后跳转到的路径
        //return "redirect:/aa";
        return new Result(false,"上传成功");
    }

    /**
     * 删除文件接口
     * @param map
     * @return
     */
    @PostMapping("/deletefile")
    public Result deletefile(@RequestBody Map<String,List<String>> map){
        List<String> fileurllist = map.get("fileurl");
        for (String fileurl : fileurllist) {
            File file=new File("D:\\project\\upload"+fileurl);

            if (!file.exists()){
                //判断是否存在，到这就说明不存在，不删除
                return new Result(false,"文件不存在，删除失败");
            }
            file.delete();
        }
        return new Result(true,"删除文件成功");

    }



    //打开本地播放器并播放视频 音频
    public static  void openExe(String file) {

        try
        {
            Runtime.getRuntime().exec("\"C:/Program Files/Windows Media Player/wmplayer.exe\""+file);

        } catch (Exception e)
        {
            System.out.println("Error!");
        }
    }

    /**
     * 使用Spring MVC的multipartFile 类作为参数
     *
     * @param multipartFile
     * @return
     */
    @PostMapping("/upload/MultipartFile")
    @ResponseBody
    public Result uploadMultipartFile(@RequestParam("file") MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        try {
            //获取文件字节数组
            byte[] bytes = multipartFile.getBytes();
            //文件存储路径(/static/ 这样会在根目录下创建问价夹)
            File pfile = new File("/static/");
            URL url = ResourceUtils.getURL("/static/");
            System.out.println(url);

            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(),"static/upload/");
            if(!upload.exists()) {
                upload.mkdirs();
            }

            //判断文件夹是否存在
            if (!pfile.exists()) {
                //不存在时,创建文件夹
                pfile.mkdirs();
            }
            //创建文件
            File file = new File(pfile, fileName);
            //写入指定文件夹
            OutputStream out = new FileOutputStream(file);
            out.write(bytes);
            out.close();
            return new Result(true,"上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,"上传失败");
        }

    }

}
