package com.fmall.service.impl;

import com.fmall.mapper.CategoryMapper;
import com.fmall.pojo.Category;
import com.fmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryRootCategories() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", 1);

        List<Category> categoryList = categoryMapper.selectByExample(example);
        return categoryList;
    }
}
