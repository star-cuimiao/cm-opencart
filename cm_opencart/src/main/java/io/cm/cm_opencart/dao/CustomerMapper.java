package io.cm.cm_opencart.dao;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.out.CustomerListOutDTO;
import io.cm.cm_opencart.po.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

    Page<CustomerListOutDTO> search();

    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}