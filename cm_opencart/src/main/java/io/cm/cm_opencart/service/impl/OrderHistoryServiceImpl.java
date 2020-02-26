package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.OrderHistoryMapper;
import io.cm.cm_opencart.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private OrderHistoryMapper orderHistoryMapper;
}
