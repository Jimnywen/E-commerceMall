package com.emall.product;

import com.emall.product.entity.BrandEntity;
import com.emall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmallProductApplicationTests {


	@Autowired
	BrandService brandService;

	@Test
	void contextLoads() {

		BrandEntity brandEntity = new BrandEntity();

		brandEntity.setBrandId(1L);
		brandEntity.setDescript("huawei");
		brandService.updateById(brandEntity);

	}

}
