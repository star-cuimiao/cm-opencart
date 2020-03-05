package io.cm.cm_opencart.service;

import io.cm.cm_opencart.dto.out.AddressListOutDTO;
import io.cm.cm_opencart.dto.out.AddressShowOutDTO;

import java.util.List;

public interface AddressService {

    List<AddressListOutDTO> getListCustomerId(Integer customerId);

    AddressShowOutDTO getById(Integer addressId);
}
