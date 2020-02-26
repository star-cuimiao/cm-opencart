package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.out.CustomerListOutDTO;
import io.cm.cm_opencart.dto.out.CustomerShowOutDTO;

public interface CustomerService {

    Page<CustomerListOutDTO> search(Integer pageNum);

    CustomerShowOutDTO getById(Integer customerId);
}
