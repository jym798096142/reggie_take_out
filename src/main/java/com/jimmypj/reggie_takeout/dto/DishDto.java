package com.jimmypj.reggie_takeout.dto;

import com.jimmypj.reggie_takeout.entity.Dish;
import com.jimmypj.reggie_takeout.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
