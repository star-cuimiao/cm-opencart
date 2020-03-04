package io.cm.cmstorkback.service;


import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.out.ProductListOutDTO;
import io.cm.cmstorkback.dto.out.ProductShowOutDTO;
import io.cm.cmstorkback.po.Product;


public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);

}
