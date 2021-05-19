package com.emall.search.service;

import com.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

public interface ProductSavaService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
