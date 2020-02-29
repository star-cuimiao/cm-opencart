package io.cm.cmstorkback.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/getAddressByCustomerId")
    public AddressListOutDTO getAddressByCustomerId(@RequestAttribute Integer customerId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDTO addressCreateInDTO,
                          @RequestAttribute Integer customerId){
        return null;
    };

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                       @RequestAttribute Integer customerId){

    }

}
