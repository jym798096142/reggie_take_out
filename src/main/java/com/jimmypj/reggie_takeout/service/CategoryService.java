package com.jimmypj.reggie_takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jimmypj.reggie_takeout.entity.Category;

public interface CategoryService extends IService<Category> {
    void remove(Long id);

}
