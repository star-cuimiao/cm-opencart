package io.cm.cmstorkback.dao;

import io.cm.cmstorkback.po.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {

    List<Address> getByCustomerId(Integer customerId);

    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int update(Address record);

    int updateByPrimaryKey(Address record);
}