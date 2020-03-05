package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.AddressMapper;
import io.cm.cm_opencart.dto.out.AddressListOutDTO;
import io.cm.cm_opencart.po.Address;
import io.cm.cm_opencart.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressListOutDTO> getListCustomerId(Integer customerId) {
        List<AddressListOutDTO> listCustomerId = addressMapper.getListCustomerId(customerId);
        return listCustomerId;
    }

    @Override
    public Address getById(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }
}
