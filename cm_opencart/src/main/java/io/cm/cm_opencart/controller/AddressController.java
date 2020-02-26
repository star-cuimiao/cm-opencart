package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.out.AddressListOutDTO;
import io.cm.cm_opencart.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getListCustomerId")
    public List<AddressListOutDTO> getListCustomerId(@RequestParam Integer customerId){
        List<AddressListOutDTO> listCustomerId = addressService.getListCustomerId(customerId);
        return listCustomerId;
    }

}
