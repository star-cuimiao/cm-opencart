package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.out.AddressListOutDTO;
import io.cm.cm_opencart.dto.out.CustomerListOutDTO;
import io.cm.cm_opencart.dto.out.CustomerShowOutDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerService {

    List<AddressListOutDTO> getListCustomerId(@RequestParam Integer customerId);

    Page<CustomerListOutDTO> search(Integer pageNum);

    CustomerShowOutDTO getById(Integer customerId);

    Integer disable(Integer customerId);
}
