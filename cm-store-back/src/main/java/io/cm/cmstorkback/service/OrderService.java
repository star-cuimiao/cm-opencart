package io.cm.cmstorkback.service;

import io.cm.cmstorkback.dto.in.OrderCheckoutInDTO;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                  Integer customerId);

}
