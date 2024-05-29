package com.jimmypj.reggie_takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jimmypj.reggie_takeout.dto.SetmealDto;
import com.jimmypj.reggie_takeout.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    void saveWithDish(SetmealDto setmealDto);

    void removeWithDish(List<Long> ids);
}
