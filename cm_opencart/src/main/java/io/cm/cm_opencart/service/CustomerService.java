package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.out.CustomerShowOutDTO;
import io.cm.cm_opencart.po.Customer;

public interface CustomerService {

    Page<Customer> search(Integer pageNum);

    CustomerShowOutDTO getById(Integer customerId);

}
