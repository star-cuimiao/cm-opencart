package io.cm.cmstorkback.service;

import io.cm.cmstorkback.dto.in.CustomerRegisterInDTO;
import io.cm.cmstorkback.po.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);
}
