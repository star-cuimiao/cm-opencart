package io.cm.cm_opencart.controller;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.in.CustomerSearchInDTO;
import io.cm.cm_opencart.dto.out.CustomerListOutDTO;
import io.cm.cm_opencart.dto.out.CustomerShowOutDTO;
import io.cm.cm_opencart.dto.out.PageOutDTO;
import io.cm.cm_opencart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                                 @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<CustomerListOutDTO> page = customerService.search(pageNum);
        PageOutDTO<CustomerListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        CustomerShowOutDTO customerById = customerService.getById(customerId);
        return customerById;
    }

    @PostMapping("/disable")
    public Integer disable(@RequestParam Integer customerId){
        return null;
    }

}
