package io.cm.cmstorkback.service;

import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.in.OrderCheckoutInDTO;
import io.cm.cmstorkback.dto.out.OrderShowOutDTO;
import io.cm.cmstorkback.po.Order;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                  Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOutDTO getById(Long orderId);

}
