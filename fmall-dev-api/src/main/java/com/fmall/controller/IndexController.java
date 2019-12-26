package com.fmall.controller;

import com.fmall.enums.OKNO;
import com.fmall.pojo.Carousel;
import com.fmall.pojo.Category;
import com.fmall.service.CarouselService;
import com.fmall.service.CategoryService;
import com.fmall.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "用户注册登录", tags = "用户注册登录")
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "首页轮播图", notes = "获取首页轮播图接口", httpMethod = "GET")
    @GetMapping("/carousels")
    public JSONResult fetchCarouselList() {
        List<Carousel> carouselList = carouselService.queryAll(OKNO.OK.type);
        return JSONResult.ok(carouselList);
    }

    @ApiOperation(value = "一级分类列表", notes = "获取一级分类列表", httpMethod = "GET")
    @GetMapping("/categories")
    public JSONResult fetchAllRootCategories() {
        List<Category> categoryList = categoryService.queryRootCategories();
        return JSONResult.ok(categoryList);
    }



}
