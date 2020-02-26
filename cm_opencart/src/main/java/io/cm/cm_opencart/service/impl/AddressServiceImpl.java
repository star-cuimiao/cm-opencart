package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.AddressMapper;
import io.cm.cm_opencart.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

}
