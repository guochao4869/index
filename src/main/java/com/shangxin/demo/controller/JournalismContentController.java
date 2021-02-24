package com.shangxin.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.JournalismContent;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.service.JournalismContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/JournalismContent")
@CrossOrigin
public class JournalismContentController {

    @Autowired
    private JournalismContentService journalismContentService;

    /**
     * 根据传过来的详情id去查询新闻的详情
     * @param JournalismId
     * @return
     */
    @GetMapping("/findById/{JournalismId}")
    public Result journalismContent(@PathVariable("JournalismId") int JournalismId){
        JournalismContent journalismContent = journalismContentService.findJournalismContent(JournalismId);
        return new Result(true,"根据新闻id查询成功",journalismContent);
    }

    /**
     * 新闻新增
     * @param journalismContent
     * @return
     */
    @PostMapping("/insertjournalismcontent")
    public Result insertjournalismcontent(@RequestBody JournalismContent journalismContent){
        try {
            journalismContentService.insertjournalismcontent(journalismContent);
            return new Result(true,"新增新闻成功");
        }catch (Exception e){
            return new Result(false,"新增新闻失败");
        }

    }

    /**
     * 新闻的修改
     * @param journalismContent
     * @return
     */
    @PostMapping("/updatejournalismcontent")
    public Result updatejournalismcontent(@RequestBody JournalismContent journalismContent){

        try {
            journalismContentService.updatejournalismcontent(journalismContent);
            return new Result(true,"修改新闻成功");
        }catch (Exception e){
            return new Result(false,"修改新闻失败");
        }
    }

    /**
     * 分页查询后台新闻目录
     * @param currentpage
     * @return
     */
    @GetMapping("/findJournalismlist/{currentpage}")
    public Result findJournalismlist(@PathVariable("currentpage") int currentpage){
        if (currentpage<=0){
            return new Result(false,"输入的页数错误，请重试");
        }
        PageInfo journalismlist = journalismContentService.findJournalismlist(currentpage);
        return new Result(true,"新闻查询成功",journalismlist);
    }
}
