package io.cm.cmstorkback.service.Impl;

import com.alibaba.fastjson.JSON;
import io.cm.cmstorkback.dao.OrderDetailMapper;
import io.cm.cmstorkback.dao.OrderMapper;
import io.cm.cmstorkback.dto.in.OrderCheckoutInDTO;
import io.cm.cmstorkback.dto.in.OrderProductInDTO;
import io.cm.cmstorkback.enumeration.OrderStatus;
import io.cm.cmstorkback.po.Address;
import io.cm.cmstorkback.po.Order;
import io.cm.cmstorkback.po.OrderDetail;
import io.cm.cmstorkback.po.Product;
import io.cm.cmstorkback.service.AddresssService;
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
}
