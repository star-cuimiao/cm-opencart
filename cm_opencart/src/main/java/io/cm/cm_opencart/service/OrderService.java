package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.in.OrderSearchInDTO;
import io.cm.cm_opencart.dto.out.OrderListOutDTO;
import io.cm.cm_opencart.dto.out.OrderShowOutDTO;

public interface OrderService {

    Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                 Integer pageNum);

    OrderShowOutDTO getById(Long orderId);
}
