package io.cm.cmstorkback.controller;

import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.in.OrderCheckoutInDTO;
import io.cm.cmstorkback.dto.out.OrderListOutDTO;
import io.cm.cmstorkback.dto.out.OrderShowOutDTO;
import io.cm.cmstorkback.dto.out.PageOutDTO;
import io.cm.cmstorkback.po.Order;
import io.cm.cmstorkback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        Long orderId = orderService.checkout(orderCheckoutInDTO, customerId);
        return orderId;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                               @RequestAttribute Integer customerId){
        Page<Order> page = orderService.getByCustomerId(pageNum, customerId);

        List<OrderListOutDTO> orderListOutDTOS = page.stream().map(order -> {
            OrderListOutDTO orderListOutDTO = new OrderListOutDTO();
            orderListOutDTO.setOrderId(order.getOrderId());
            orderListOutDTO.setTotalPrice(order.getTotalPrice());
            orderListOutDTO.setStatus(order.getStatus());
            orderListOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
            return orderListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(orderListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
    }

}
