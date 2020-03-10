package io.cm.cm_opencart.dao;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.out.OrderListOutDTO;
import io.cm.cm_opencart.po.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> search(@Param("orderId") Long orderId,
                                 @Param("status") Byte stastus,
                                 @Param("totalPrice") Double totalPrice,
                                 @Param("customerName") String customerName,
                                 @Param("startTime") Date startTime,
                                 @Param("endTime") Date endTime);
}