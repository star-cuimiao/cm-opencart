package io.cm.cm_opencart.dao;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.po.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

    Page<Customer> search(@Param("username")String username,
                          @Param("realName")String realName,
                          @Param("mobile")String mobile,
                          @Param("email")String email,
                          @Param("status")Byte status);

    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

}