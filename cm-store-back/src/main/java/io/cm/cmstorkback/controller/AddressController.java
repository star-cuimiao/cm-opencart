package io.cm.cmstorkback.controller;

import io.cm.cmstorkback.dto.in.AddressCreateInDTO;
import io.cm.cmstorkback.dto.in.AddressUpdateInDTO;
import io.cm.cmstorkback.dto.out.AddressListOutDTO;
import io.cm.cmstorkback.dto.out.AddressShowOutDTO;
import io.cm.cmstorkback.po.Address;
import io.cm.cmstorkback.service.AddresssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddresssService addresssService;

    @GetMapping("/getAddressByCustomerId")
    public List<AddressListOutDTO> getAddressByCustomerId(@RequestAttribute Integer customerId){
        List<Address> addresses = addresssService.getByCustomerId(customerId);
        List<AddressListOutDTO> addressListOutDTOS = addresses.stream().map(address -> {
            AddressListOutDTO addressListOutDTO = new AddressListOutDTO();
            addressListOutDTO.setAddressId(address.getAddressId());
            addressListOutDTO.setTag(address.getTag());
            addressListOutDTO.setReceiverName(address.getReceiverName());
            addressListOutDTO.setReceiverMobile(address.getReceiverMobile());
            addressListOutDTO.setContent(address.getContent());
            return addressListOutDTO;
        }).collect(Collectors.toList());
        return addressListOutDTOS;
    }
    @GetMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId){
        Address address = addresssService.getById(addressId);
        AddressShowOutDTO addressShowOutDTO = new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(address.getAddressId());
        addressShowOutDTO. setReceiverName(address.getReceiverName());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMobile());
        addressShowOutDTO.setTag(address.getTag());
        addressShowOutDTO.setContent(address.getContent());
        return addressShowOutDTO;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDTO addressCreateInDTO,
                          @RequestAttribute Integer customerId){
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setReceiverName(addressCreateInDTO.getReceiverName());
        address.setReceiverMobile(addressCreateInDTO.getReceiverMobile());
        address.setContent(addressCreateInDTO.getContent());
        address.setTag(addressCreateInDTO.getTag());
        Integer integer = addresssService.create(address);
        return integer;
    };

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                       @RequestAttribute Integer customerId){
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setReceiverName(addressUpdateInDTO.getReceiverName());
        address.setReceiverMobile(addressUpdateInDTO.getReceiverMobile());
        address.setContent(addressUpdateInDTO.getContent());
        address.setTag(addressUpdateInDTO.getTag());
        addresssService.update(address);
    }

}
