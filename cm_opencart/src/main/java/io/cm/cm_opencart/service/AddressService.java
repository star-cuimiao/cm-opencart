package io.cm.cm_opencart.service;

import io.cm.cm_opencart.dto.out.AddressListOutDTO;
import io.cm.cm_opencart.po.Address;

import java.util.List;

public interface AddressService {

    List<AddressListOutDTO> getListCustomerId(Integer customerId);

    Address getById(Integer addressId);
}
