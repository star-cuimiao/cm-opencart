package io.cm.cmstorkback.service.Impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.cm.cmstorkback.dao.OrderDetailMapper;
import io.cm.cmstorkback.dao.OrderMapper;
import io.cm.cmstorkback.dto.in.OrderCheckoutInDTO;
import io.cm.cmstorkback.dto.in.OrderProductInDTO;
import io.cm.cmstorkback.dto.out.OrderHistoryListOutDTO;
import io.cm.cmstorkback.dto.out.OrderShowOutDTO;
import io.cm.cmstorkback.enumeration.OrderStatus;
import io.cm.cmstorkback.po.*;
import io.cm.cmstorkback.service.AddresssService;
import io.cm.cmstorkback.service.OrderHistoryService;
import io.cm.cmstorkback.service.OrderService;
import io.cm.cmstorkback.service.ProductService;
import io.cm.cmstorkback.vo.OrderProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddresssService addresssService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                            Integer customerId) {

        List<OrderProductInDTO> orderProductInDTOS = orderCheckoutInDTO.getOrderProducts();

        List<OrderProductVo> orderProductVoS = orderProductInDTOS.stream().map(orderProductInDTO -> {

            Product orderProduct = productService.getById(orderProductInDTO.getProductId());

            OrderProductVo orderProductVo = new OrderProductVo();
            orderProductVo.setProductId(orderProduct.getProductId());
            orderProductVo.setProductCode(orderProduct.getProductCode());
            orderProductVo.setProductName(orderProduct.getProductName());
            Integer quantity = orderProductInDTO.getQuantity();
            orderProductVo.setQuantity(quantity);
            Double unitPrice = orderProduct.getPrice() * orderProduct.getDiscount();
            orderProductVo.setUnitPrice(unitPrice);
            Double totalPrice = unitPrice * quantity;
            orderProductVo.setTotalPrice(totalPrice);
            Integer unitRewordPoints = orderProduct.getRewordPoints();
            orderProductVo.setUnitRewordPoints(unitRewordPoints);
            Integer totalRewordPoints = unitRewordPoints * quantity;
            orderProductVo.setTotalRewordPoints(totalRewordPoints);

            return orderProductVo;
        }).collect(Collectors.toList());

        double allTotalPrice = orderProductVoS.stream().mapToDouble(p -> p.getTotalPrice()).sum();
        int allTotalRewordPoints = orderProductVoS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte) OrderStatus.ToProcess.ordinal());
        order.setTotalPrice(allTotalPrice);
        order.setRewordPoints(allTotalRewordPoints);
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);

        orderMapper.insertSelective(order);
        Long orderId = order.getOrderId();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setShipMethod(orderCheckoutInDTO.getShipMethod());
        // tocalcuate ship price with ship method
        orderDetail.setShipPrice(5.0);
        Address shipAddress = addresssService.getById(orderCheckoutInDTO.getShipAddressId());
        orderDetail.setShipAddress(shipAddress.getContent());

        orderDetail.setPayMethod(orderCheckoutInDTO.getPayMethod());
        orderDetail.setInvoicePrice(allTotalPrice);
        Address invoiceAddress = addresssService.getById(orderCheckoutInDTO.getInvoiceAddressId());
        orderDetail.setInvoiceAddress(invoiceAddress.getContent());

        orderDetail.setComment(orderCheckoutInDTO.getComment());
        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVoS));

        orderDetailMapper.insertSelective(orderDetail);

        return orderId;
    }

    @Override
    public Page<Order> getByCustomerId(Integer pageNum, Integer customerId) {
        PageHelper.startPage(pageNum,10);
        Page<Order> order = orderMapper.selectByCustomerId(customerId);
        return order;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVo> orderProductVos = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVo.class);
        orderShowOutDTO.setOrderProducts(orderProductVos);

        List<OrderHistory> orderHistories = orderHistoryService.getByOrderId(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());
        orderShowOutDTO.setOrderHistories(orderHistoryListOutDTOS);

        return orderShowOutDTO;
    }
}
