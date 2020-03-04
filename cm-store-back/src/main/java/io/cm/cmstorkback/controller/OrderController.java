package io.cm.cmstorkback.controller;

import io.cm.cmstorkback.dto.in.OrderCheckoutInDTO;
import io.cm.cmstorkback.dto.out.OrderListOutDTO;
import io.cm.cmstorkback.dto.out.OrderShowOutDTO;
import io.cm.cmstorkback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }

}
