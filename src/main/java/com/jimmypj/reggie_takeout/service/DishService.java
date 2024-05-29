package com.jimmypj.reggie_takeout.service;
import com.jimmypj.reggie_takeout.dto.DishDto;
import com.jimmypj.reggie_takeout.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
}
