package io.cm.cmstorkback.service;

import io.cm.cmstorkback.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);
}
