package com.emall.product.service.impl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageUtils;
import com.common.utils.Query;

import com.emall.product.dao.SkuInfoDao;
import com.emall.product.entity.SkuInfoEntity;
import com.emall.product.service.SkuInfoService;
import org.springframework.util.StringUtils;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuInfo(SkuInfoEntity skuInfoEntity) {
        this.baseMapper.insert(skuInfoEntity);
    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {
        QueryWrapper<SkuInfoEntity> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((w) -> {
                w.eq("sku_id", key).or().like("sku_name", key);
            });
        }

        String min = (String) params.get("min");
        if (!StringUtils.isEmpty(min)) {
            wrapper.ge("price", min);

        }
        String max = (String) params.get("max");
        if (!StringUtils.isEmpty(max)) {
            try {
                BigDecimal bigDecimal = new BigDecimal(max);
                if (bigDecimal.compareTo(new BigDecimal("0")) == 1){
                    wrapper.le("price", max);
                }

            } catch (Exception e) {

            }


        }

        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId)&&!"0".equalsIgnoreCase(brandId)) {
            wrapper.eq("brand_id", brandId);
        }

        String catelogId = (String) params.get("catelogId");
        if (!StringUtils.isEmpty(catelogId)&&!"0".equalsIgnoreCase(catelogId)) {
            wrapper.eq("catalog_id", catelogId);
        }
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuInfoEntity> getSkusBySpuId(Long spuId) {
        List<SkuInfoEntity> list = this.list(new QueryWrapper<SkuInfoEntity>().eq("spu_id",spuId));
        return list;
    }

}