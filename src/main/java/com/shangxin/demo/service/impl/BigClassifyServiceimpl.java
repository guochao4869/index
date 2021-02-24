package com.shangxin.demo.service.impl;

import com.shangxin.demo.dao.BigClassifyMapper;
import com.shangxin.demo.pojo.BigClassify;
import com.shangxin.demo.service.BigClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigClassifyServiceimpl implements BigClassifyService {

    @Autowired
    private BigClassifyMapper groupBusinessMapper;

    /**
     * 根据点击的Id去查询数据
     * @return
     */
    @Override
    public List<BigClassify> findgroupBusiness() {
        List<BigClassify> GroupBusinesslist = groupBusinessMapper.selectAll();

        return GroupBusinesslist;
    }
}
