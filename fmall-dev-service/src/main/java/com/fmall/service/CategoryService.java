package com.fmall.service;

import com.fmall.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询一级分类
     * @return
     */
    public List<Category> queryRootCategories();
}
