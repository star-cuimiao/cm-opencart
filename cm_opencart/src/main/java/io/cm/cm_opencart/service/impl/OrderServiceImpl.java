package io.cm.cm_opencart.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.cm.cm_opencart.dao.OrderDetailMapper;
import io.cm.cm_opencart.dao.OrderMapper;
import io.cm.cm_opencart.dto.out.OrderListOutDTO;
import io.cm.cm_opencart.dto.out.OrderShowOutDTO;
import io.cm.cm_opencart.po.Order;
import io.cm.cm_opencart.po.OrderDetail;
import io.cm.cm_opencart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<OrderListOutDTO> page = orderMapper.search();
        return page;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);
        return null;
    }
}
