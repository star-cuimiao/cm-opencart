package io.cm.cmstorkback.service.Impl;

import io.cm.cmstorkback.dao.ProductOperationMapper;
import io.cm.cmstorkback.po.ProductOperation;
import io.cm.cmstorkback.service.ProductOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductOperationServiceImpl implements ProductOperationService {

    @Autowired
    private ProductOperationMapper productOperationMapper;

    @Override
    public void count(Integer productId) {
        ProductOperation productOperation = productOperationMapper.selectByPrimaryKey(productId);

        if(productOperation == null){
            productOperation = new ProductOperation();
            productOperation.setProductId(productId);
            productOperation.setAllCount(1);
            productOperation.setDayCount(1);
            productOperation.setRecentTime(new Date());
            productOperationMapper.insertSelective(productOperation);
        }else{
            productOperation.setAllCount(productOperation.getAllCount()+1);
            productOperation.setDayCount(productOperation.getDayCount()+1);
            productOperation.setRecentTime(new Date());
            productOperationMapper.updateByPrimaryKeySelective(productOperation);
        }
    }

    @Override
    public List<ProductOperation> selectHotProduct() {
        List<ProductOperation> productOperations = productOperationMapper.selectHotProduct();
        return productOperations;
    }
}
