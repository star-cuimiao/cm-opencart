package io.cm.cmstorkback.service.Impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.cm.cmstorkback.dao.ProductDetailMapper;
import io.cm.cmstorkback.dao.ProductMapper;
import io.cm.cmstorkback.dao.ProductOperationMapper;
import io.cm.cmstorkback.dto.in.ProductSearchInDTO;
import io.cm.cmstorkback.dto.out.ProductListOutDTO;
import io.cm.cmstorkback.dto.out.ProductShowOutDTO;
import io.cm.cmstorkback.enumeration.ProductStatus;
import io.cm.cmstorkback.po.Product;
import io.cm.cmstorkback.po.ProductDetail;
import io.cm.cmstorkback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Autowired
    private ProductOperationMapper productOperationMapper;

    @Override
    public Product getById(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @Override
    public ProductShowOutDTO getShowById(Integer productId) {

        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        productShowOutDTO.setProductId(product.getProductId());
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());

        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrlsJson = productDetail.getOtherPicUrls();
        List<String> otherPicUrls = JSON.parseArray(otherPicUrlsJson, String.class);
        productShowOutDTO.setOtherPicUrls(otherPicUrls);

        return productShowOutDTO;
    }

    @Override
    public Page<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                          Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<ProductListOutDTO> page = productMapper.search(productSearchInDTO.getKeyword(), (byte) ProductStatus.OnSales.ordinal());
        return page;
    }

}
