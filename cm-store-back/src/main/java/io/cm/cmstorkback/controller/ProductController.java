package io.cm.cmstorkback.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.in.ProductSearchInDTO;
import io.cm.cmstorkback.dto.out.PageOutDTO;
import io.cm.cmstorkback.dto.out.ProductListOutDTO;
import io.cm.cmstorkback.dto.out.ProductShowOutDTO;
import io.cm.cmstorkback.mq.HotProductDTO;
import io.cm.cmstorkback.po.ProductOperation;
import io.cm.cmstorkback.service.ProductOperationService;
import io.cm.cmstorkback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private ProductOperationService productOperationService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getShowById(productId);
        //todo send msg to kafka
        HotProductDTO hotProductDTO = new HotProductDTO();
        hotProductDTO.setProductId(productId);
        hotProductDTO.setProductCode(productShowOutDTO.getProductCode());
        kafkaTemplate.send("hotproduct", JSON.toJSONString(hotProductDTO));
//        productOperationService.count(productId);
        return productShowOutDTO;
    }

    @GetMapping("/hot")
    //    @Cacheable(cacheNames = "HotProducts", key = "HotProductskey")
    public List<ProductOperation> hot(){
        String hotProductsJson = redisTemplate.opsForValue().get("HotProducts");
        if(hotProductsJson !=null ){
            List<ProductOperation> productOperations = JSON.parseArray(hotProductsJson, ProductOperation.class);
            return  productOperations;
        }else{
            List<ProductOperation> hotProducts = productOperationService.selectHotProduct();
            redisTemplate.opsForValue().set("HotProducts",JSON.toJSONString(hotProducts));
            return hotProducts;
        }
    }

}
