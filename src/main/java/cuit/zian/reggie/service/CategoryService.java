package cuit.zian.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.zian.reggie.pojo.Category;

public interface CategoryService extends IService<Category> {
    boolean removeById(Long id);
}
