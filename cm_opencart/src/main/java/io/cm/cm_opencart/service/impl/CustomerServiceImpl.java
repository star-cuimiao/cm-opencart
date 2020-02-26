package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.CustomerMapper;
import io.cm.cm_opencart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;
}
