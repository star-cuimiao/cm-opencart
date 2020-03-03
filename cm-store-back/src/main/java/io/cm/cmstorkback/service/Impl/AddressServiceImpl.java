package io.cm.cmstorkback.service.Impl;

import io.cm.cmstorkback.dao.AddressMapper;
import io.cm.cmstorkback.po.Address;
import io.cm.cmstorkback.service.AddresssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddresssService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public List<Address> getByCustomerId(Integer customerId) {
        List<Address> addresses = addressMapper.getByCustomerId(customerId);
        return addresses;
    }

    @Override
    public Integer create(Address address) {
        int integer = addressMapper.insertSelective(address);
        return integer;
    }

    @Override
    public void update(Address address) {
        addressMapper.update(address);
    }
}
