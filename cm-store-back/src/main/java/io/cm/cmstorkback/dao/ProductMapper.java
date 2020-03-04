package io.cm.cmstorkback.dao;

import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.out.ProductListOutDTO;
import io.cm.cmstorkback.po.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    Page<ProductListOutDTO> search();

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}