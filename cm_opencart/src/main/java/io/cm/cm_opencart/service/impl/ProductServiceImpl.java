package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.ProductMapper;
import io.cm.cm_opencart.po.ProductDetail;
import io.cm.cm_opencart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDetail productDetail;
}
