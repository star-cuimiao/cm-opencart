package io.cm.cm_opencart.controller;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.in.ProductCreateInDTO;
import io.cm.cm_opencart.dto.in.ProductSearchInDTO;
import io.cm.cm_opencart.dto.in.ProductUpdateInDTO;
import io.cm.cm_opencart.dto.out.PageOutDTO;
import io.cm.cm_opencart.dto.out.ProductListOutDTO;
import io.cm.cm_opencart.dto.out.ProductShowOutDTO;
import io.cm.cm_opencart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer PageNum){
        Page<ProductListOutDTO> page = productService.search(PageNum);

        PageOutDTO<ProductListOutDTO> pageOutDto = new PageOutDTO<ProductListOutDTO>();
        pageOutDto.setTotal(page.getTotal());
        pageOutDto.setPageSize(page.getPageSize());
        pageOutDto.setPageNum(page.getPageNum());
        pageOutDto.setList(page);
        return pageOutDto;
    }


    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
            productService.update(productUpdateInDTO);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){
        productService.delete(productId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productService.batchDelete(productIds);
    }


}
