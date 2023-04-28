package cuit.zian.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuit.zian.reggie.mapper.DishMapper;
import cuit.zian.reggie.pojo.Dish;
import cuit.zian.reggie.service.DishService;
import org.springframework.stereotype.Service;


@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

}
