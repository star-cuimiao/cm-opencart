package io.cm.cm_opencart.dao;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.po.Return;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    Page<Return> search(@Param("returnId") Integer returnId,
                        @Param("orderId")Long orderId,
                        @Param("customerName") String customerName,
                        @Param("productCode") String productCode,
                        @Param("productName") String productName,
                        @Param("status") Byte status);
}