package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.in.ProductCreateInDTO;
import io.cm.cm_opencart.dto.in.ProductSearchInDTO;
import io.cm.cm_opencart.dto.in.ProductUpdateInDTO;
import io.cm.cm_opencart.dto.out.ProductListOutDTO;
import io.cm.cm_opencart.dto.out.ProductShowOutDTO;

import java.util.List;

public interface ProductService {

    Page<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO, Integer pageNum);

    ProductShowOutDTO getById(Integer productId);

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    public void delete(Integer productId);

    public void batchDelete(List<Integer> productIds);
}
