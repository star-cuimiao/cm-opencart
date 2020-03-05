package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.out.OrderListOutDTO;
import io.cm.cm_opencart.dto.out.OrderShowOutDTO;

public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);
}
