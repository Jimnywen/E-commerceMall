package com.emall.product.dao;

import com.emall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author jayden
 * @email jimnywen@gmail.com
 * @date 2021-01-05 12:32:18
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
