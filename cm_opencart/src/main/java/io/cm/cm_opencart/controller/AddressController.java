package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.out.AddressListOutDTO;
import io.cm.cm_opencart.dto.out.AddressShowOutDTO;
import io.cm.cm_opencart.po.Address;
import io.cm.cm_opencart.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getListCustomerId")
    public List<AddressListOutDTO> getListCustomerId(@RequestParam Integer customerId){
        List<AddressListOutDTO> listCustomerId = addressService.getListCustomerId(customerId);
        return listCustomerId;
    }

    @GetMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId){
        Address address = addressService.getById(addressId);
        AddressShowOutDTO addressShowOutDTO = new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(address.getAddressId());
        addressShowOutDTO.setContent(address.getContent());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMobile());
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setTag(address.getTag());
        return addressShowOutDTO;
    }
}
