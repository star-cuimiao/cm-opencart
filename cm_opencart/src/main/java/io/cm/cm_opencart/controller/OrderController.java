package io.cm.cm_opencart.controller;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.in.OrderSearchInDTO;
import io.cm.cm_opencart.dto.out.*;
import io.cm.cm_opencart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                              @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<OrderListOutDTO> page = orderService.search(pageNum);
        PageOutDTO pageOutDTO = new PageOutDTO();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
            return null;

    }

    @GetMapping("/getInvoice")
    public OrderInvoiceShowOutDTO getInvoice(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestBody Long orderId){
        return null;
    }

}
