package com.jimmypj.reggie_takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jimmypj.reggie_takeout.common.CustomException;
import com.jimmypj.reggie_takeout.entity.Category;
import com.jimmypj.reggie_takeout.entity.Dish;
import com.jimmypj.reggie_takeout.entity.Setmeal;
import com.jimmypj.reggie_takeout.mapper.CategoryMapper;
import com.jimmypj.reggie_takeout.service.CategoryService;
import com.jimmypj.reggie_takeout.service.DishService;
import com.jimmypj.reggie_takeout.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * delete category by id
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);

        if (count1 > 0) {
            throw new CustomException("The category is connected with dish");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper= new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);

        if (count2 > 0) {
            throw new CustomException("The category is connected with Setmeal");

        }

        super.removeById(id);

    }
}
