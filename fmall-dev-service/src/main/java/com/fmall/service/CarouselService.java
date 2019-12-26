package com.fmall.service;

import com.fmall.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * 查询所有轮播图
     * @param isShow 是否展示
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);
}
