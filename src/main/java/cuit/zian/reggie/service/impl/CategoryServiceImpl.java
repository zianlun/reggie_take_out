package cuit.zian.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuit.zian.reggie.common.CustomException;
import cuit.zian.reggie.mapper.CategoryMapper;
import cuit.zian.reggie.pojo.Category;
import cuit.zian.reggie.pojo.Dish;
import cuit.zian.reggie.pojo.Setmeal;
import cuit.zian.reggie.service.CategoryService;
import cuit.zian.reggie.service.DishService;
import cuit.zian.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public boolean removeById(Long id) {
        //查询当前分类是否关联菜品，如果关联，抛出业务异常
        Integer count1, count2;
        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        dishQueryWrapper.eq(Dish::getCategoryId, id);
        count1 = dishService.count(dishQueryWrapper);
        if(count1 > 0){
            throw new CustomException("当前分类还存在关联菜品, 请处理后再试");
        }
        //查询当前分类是否关联套餐， 如果关联，抛出业务异常
        LambdaQueryWrapper<Setmeal> setmealQueryWrapper = new LambdaQueryWrapper<>();
        setmealQueryWrapper.eq(Setmeal::getCategoryId, id);
        count2 = setmealService.count(setmealQueryWrapper);
        if(count2 > 0){
            throw new CustomException("当前分类还存在关联套餐, 请处理后再试");
        }
        //正常删除
        return super.removeById(id);
    }

}
