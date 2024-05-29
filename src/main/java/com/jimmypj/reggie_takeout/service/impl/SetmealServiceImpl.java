package com.jimmypj.reggie_takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jimmypj.reggie_takeout.common.CustomException;
import com.jimmypj.reggie_takeout.dto.SetmealDto;
import com.jimmypj.reggie_takeout.entity.Setmeal;
import com.jimmypj.reggie_takeout.entity.SetmealDish;
import com.jimmypj.reggie_takeout.mapper.SetmealMapper;
import com.jimmypj.reggie_takeout.service.SetmealDishService;
import com.jimmypj.reggie_takeout.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;
    @Override
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        this.save(setmealDto);

        List<SetmealDish> setmealDishList = setmealDto.getSetmealDishes();

        setmealDishList.stream().map( (item) -> {
            item.setSetmealId(setmealDto.getId());
            return item;
        } ).collect(Collectors.toList());

        setmealDishService.saveBatch(setmealDishList);

    }

    @Override
    public void removeWithDish(List<Long> ids) {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId, ids);
        queryWrapper.eq(Setmeal::getStatus, 1);

        int count = this.count(queryWrapper);

        if (count > 0) {
            throw new CustomException("Setmeal is selling");
        }

        this.removeByIds(ids);

        LambdaQueryWrapper<SetmealDish> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.in(SetmealDish::getSetmealId, ids);

        setmealDishService.remove(queryWrapper1);


    }
}
