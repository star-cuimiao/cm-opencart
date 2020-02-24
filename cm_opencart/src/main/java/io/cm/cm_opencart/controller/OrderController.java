package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.out.OrderListOutDTO;
import io.cm.cm_opencart.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(@RequestParam(required = false) String customer_name,
                                              @RequestParam(required = false) Byte status,
                                              @RequestParam(required = false) Double total_price,
                                              @RequestParam(required = false) Integer reword_points ,
                                              @RequestParam(required = false) Long create_time,
                                              @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public OrderListOutDTO getById(@RequestParam Integer order_id){
        return null;

    }

    @GetMapping("/getByCustomersId")
    public OrderListOutDTO getByCustomersId(@RequestParam Integer customers_id){
        return null;
    }

    @PostMapping("/create")
    public OrderListOutDTO create(@RequestBody OrderListOutDTO orderListOutDTO){
        return null;
    }

    @PostMapping("/update")
    public OrderListOutDTO update(@RequestBody OrderListOutDTO orderListOutDTO){
        return null;
    }
}
