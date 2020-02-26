package io.cm.cm_opencart.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.cm.cm_opencart.dao.CustomerMapper;
import io.cm.cm_opencart.dto.out.CustomerListOutDTO;
import io.cm.cm_opencart.dto.out.CustomerShowOutDTO;
import io.cm.cm_opencart.po.Customer;
import io.cm.cm_opencart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<CustomerListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        Page<CustomerListOutDTO> page = customerMapper.search();
        return page;
    }

    @Override
    public CustomerShowOutDTO getById(Integer customerId) {

        Customer customer = customerMapper.selectByPrimaryKey(customerId);

        CustomerShowOutDTO customerShowOutDTO = new CustomerShowOutDTO();
        customerShowOutDTO.setCustomerId(customer.getCustomerId());
        customerShowOutDTO.setUsername(customer.getUsername());
        customerShowOutDTO.setRealName(customer.getRealName());
        customerShowOutDTO.setAvatarUrl(customer.getAvatarUrl());
        customerShowOutDTO.setMobile(customer.getMobile());
        customerShowOutDTO.setEmail(customer.getEmail());
        customerShowOutDTO.setStatus(customer.getStatus());
        customerShowOutDTO.setCreateTimestamp(customer.getCreateTime());
        customerShowOutDTO.setNewsSubscribed(customer.getNewsSubscribed());
        customerShowOutDTO.setRewordPoints(customer.getRewordPoints());
        customerShowOutDTO.setDefaultAddressId(customer.getDefaultAddressId());

        return customerShowOutDTO;
    }

    @Override
    public Integer disable(Integer customerId) {
        Integer disable = customerMapper.disable(customerId);
        return disable;
    }
}
