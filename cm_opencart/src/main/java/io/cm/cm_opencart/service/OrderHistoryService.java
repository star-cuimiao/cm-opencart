package io.cm.cm_opencart.service;

import io.cm.cm_opencart.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getListByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);
}
