package io.cm.cmstorkback.service;

import io.cm.cmstorkback.dto.out.AddressShowOutDTO;
import io.cm.cmstorkback.po.Address;

import java.util.List;

public interface AddresssService {

    List<Address> getByCustomerId(Integer customerId);

    Address getById(Integer addressId);

    Integer create(Address address);

    void update(Address address);

}
