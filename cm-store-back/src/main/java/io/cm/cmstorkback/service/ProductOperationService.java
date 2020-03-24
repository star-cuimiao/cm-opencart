package io.cm.cmstorkback.service;

import io.cm.cmstorkback.po.ProductOperation;

import java.util.List;

public interface ProductOperationService {

    void count(Integer productId);

    List<ProductOperation> selectHotProduct();
}
