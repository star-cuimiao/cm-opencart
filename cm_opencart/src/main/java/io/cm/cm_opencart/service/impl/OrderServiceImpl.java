package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.OrderDetailMapper;
import io.cm.cm_opencart.dao.OrderMapper;
import io.cm.cm_opencart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
}
