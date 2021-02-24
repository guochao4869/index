package com.shangxin.demo.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 这是封装了批量下架和批量上架的数组
 */
public class TwoList implements Serializable {
    List<Integer> id;
    List<Integer> details_id;

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public List<Integer> getDetails_id() {
        return details_id;
    }

    public void setDetails_id(List<Integer> details_id) {
        this.details_id = details_id;
    }
}
