package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.OrderHistoryMapper;
import io.cm.cm_opencart.po.OrderHistory;
import io.cm.cm_opencart.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getListByOrderId(Long orderId) {
        List<OrderHistory> orderHistories = orderHistoryMapper.selectListByOrderId(orderId);
        return orderHistories;
    }

    @Override
    public Long create(OrderHistory orderHistory) {
        orderHistoryMapper.insertSelective(orderHistory);
        Long orderHistoryId = orderHistory.getOrderHistoryId();
        return orderHistoryId;
    }
}
