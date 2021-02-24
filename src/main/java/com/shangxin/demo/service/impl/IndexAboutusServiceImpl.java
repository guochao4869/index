package com.shangxin.demo.service.impl;


import com.shangxin.demo.dao.IndexAboutusMapper;
import com.shangxin.demo.dao.JournalismResultMapper;
import com.shangxin.demo.dao.SlideshowMapper;
import com.shangxin.demo.pojo.IndexAboutus;
import com.shangxin.demo.pojo.JournalismResult;
import com.shangxin.demo.pojo.Slideshow;
import com.shangxin.demo.service.IndexAboutusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Description:IndexAboutus业务层接口实现类
 *****/
@Service
public class IndexAboutusServiceImpl implements IndexAboutusService {

    @Autowired
    private IndexAboutusMapper indexAboutusMapper;

    @Autowired
    private SlideshowMapper slideshowMapper;





    /**
     * IndexAboutus构建查询对象
     * @param indexAboutus
     * @return
     */
    public Example createExample(IndexAboutus indexAboutus){
        Example example=new Example(IndexAboutus.class);
        Example.Criteria criteria = example.createCriteria();
        if(indexAboutus!=null){
            // 主键
            if(!StringUtils.isEmpty(indexAboutus.getId())){
                    criteria.andEqualTo("id",indexAboutus.getId());
            }
            // 图片
            if(!StringUtils.isEmpty(indexAboutus.getImg())){
                    criteria.andEqualTo("img",indexAboutus.getImg());
            }
            // 状态
            if(!StringUtils.isEmpty(indexAboutus.getState())){
                    criteria.andEqualTo("state",indexAboutus.getState());
            }
            // 详情
            if(!StringUtils.isEmpty(indexAboutus.getContent())){
                    criteria.andEqualTo("content",indexAboutus.getContent());
            }
        }
        return example;
    }



    /**
     * 查询关羽我们上架状态的轮播图
     * @return
     */
    @Override
    public List<Slideshow> findAll() {
        return slideshowMapper.findslideshow();
    }

    /**
     * 查询所有的关于我们轮播图
     * @return
     */
    public List<IndexAboutus> selectAll(){
        return indexAboutusMapper.selectAll();
    }
}
