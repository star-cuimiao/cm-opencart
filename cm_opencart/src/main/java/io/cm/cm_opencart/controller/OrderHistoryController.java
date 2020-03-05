package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.in.OrderHistoryCreateInDTO;
import io.cm.cm_opencart.dto.out.OrderHistoryListOutDTO;
import io.cm.cm_opencart.po.OrderHistory;
import io.cm.cm_opencart.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderhistory")
@CrossOrigin
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderId){
        List<OrderHistory> orderHistories = orderHistoryService.getListByOrderId(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setOrderHistoryId(orderHistory.getOrderHistoryId());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOutDTO.setCustomerNotified(orderHistory.getCustomerNotified());
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());
        return  orderHistoryListOutDTOS;
    }

    @PostMapping("/create")
    public Long create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderId(orderHistoryCreateInDTO.getOrderId());
        orderHistory.setOrderStatus(orderHistoryCreateInDTO.getOrderStatus());
        orderHistory.setCustomerNotified(orderHistoryCreateInDTO.getCustomerNotified());
        orderHistory.setComment(orderHistoryCreateInDTO.getComment());
        orderHistory.setTime(new Date());
        Long orderHistoryId = orderHistoryService.create(orderHistory);
        return orderHistoryId;
    }
}
