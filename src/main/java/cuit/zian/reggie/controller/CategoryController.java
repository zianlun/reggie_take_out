package cuit.zian.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cuit.zian.reggie.common.BaseContext;
import cuit.zian.reggie.common.Result;
import cuit.zian.reggie.pojo.Category;
import cuit.zian.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.ResolveResult;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result<Object> saveCategory(@RequestBody Category category){
        log.info("category的输入 : {}",category.toString());
        log.info("{}", BaseContext.getCurrentId());
        Boolean result = categoryService.save(category);
        if(!result)
            return Result.failed("创建失败" + (category.getType() == 1 ? "菜品分类" : "套裁分类") );
        return Result.success("创建成功");
    }

    @GetMapping("/page")
    public Result<Object> page(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        //分页构造器
        Page<Category> pageInfo = new Page<>(pageNum, pageSize);
        //条件过滤器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);
        //分页查询
        categoryService.page(pageInfo, queryWrapper);
        return Result.success(pageInfo);
    }


    @DeleteMapping
    public Result<Object> delete(@RequestParam(value = "id") String id){
        boolean result = categoryService.removeById(Long.parseLong(id));
        if(!result)
            return Result.failed("服务器繁忙,删除失败");
        return Result.success("删除成功");
    }

}
