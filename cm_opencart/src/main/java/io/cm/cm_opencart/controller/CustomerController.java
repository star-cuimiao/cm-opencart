package io.cm.cm_opencart.controller;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.in.CustomerSearchInDTO;
import io.cm.cm_opencart.dto.in.CustomerSetStatusInDTO;
import io.cm.cm_opencart.dto.out.CustomerListOutDTO;
import io.cm.cm_opencart.dto.out.CustomerShowOutDTO;
import io.cm.cm_opencart.dto.out.PageOutDTO;
import io.cm.cm_opencart.po.Address;
import io.cm.cm_opencart.po.Customer;
import io.cm.cm_opencart.service.AddressService;
import io.cm.cm_opencart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                                 @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<Customer> page = customerService.search(pageNum);
        List<CustomerListOutDTO> customerListOutDTOS = page.stream().map(customer -> {
            CustomerListOutDTO customerListOutDTO = new CustomerListOutDTO();
            customerListOutDTO.setCustomerId(customer.getCustomerId());
            customerListOutDTO.setUsername(customer.getUsername());
            customerListOutDTO.setRealName(customer.getRealName());
            customerListOutDTO.setMobile(customer.getMobile());
            customerListOutDTO.setEmail(customer.getEmail());
            customerListOutDTO.setStatus(customer.getStatus());
            customerListOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
            return customerListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<CustomerListOutDTO> pageOutDTO = new PageOutDTO<>();

        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(customerListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        Customer customer = customerService.getById(customerId);

        CustomerShowOutDTO customerShowOutDTO = new CustomerShowOutDTO();
        customerShowOutDTO.setCustomerId(customer.getCustomerId());
        customerShowOutDTO.setUsername(customer.getUsername());
        customerShowOutDTO.setRealName(customer.getRealName());
        customerShowOutDTO.setAvatarUrl(customer.getAvatarUrl());
        customerShowOutDTO.setMobile(customer.getMobile());
        customerShowOutDTO.setEmail(customer.getEmail());
        customerShowOutDTO.setStatus(customer.getStatus());
        customerShowOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
        customerShowOutDTO.setNewsSubscribed(customer.getNewsSubscribed());
        customerShowOutDTO.setRewordPoints(customer.getRewordPoints());
        customerShowOutDTO.setDefaultAddressId(customer.getDefaultAddressId());

        Address defaultAddress = addressService.getById(customer.getDefaultAddressId());
        if(defaultAddress != null){
            customerShowOutDTO.setDefaultAddress(defaultAddress.getContent());
        }
        return customerShowOutDTO;
    }

    @PostMapping("/setStatus")
    public void setStatus(@RequestBody CustomerSetStatusInDTO customerSetStatusInDTO){
        customerService.setStatus(customerSetStatusInDTO);
    }

}
