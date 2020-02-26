package io.cm.cm_opencart.dao;

import io.cm.cm_opencart.dto.out.AddressListOutDTO;
import io.cm.cm_opencart.po.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {

    List<AddressListOutDTO> getListCustomerId(@Param("customerId") Integer customerId);

    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}