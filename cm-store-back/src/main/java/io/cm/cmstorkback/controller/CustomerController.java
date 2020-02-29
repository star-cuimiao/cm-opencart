package io.cm.cmstorkback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.cm.cmstorkback.constant.ClientExceptionConstant;
import io.cm.cmstorkback.dto.in.*;
import io.cm.cmstorkback.dto.out.CustomerLoginOutDTO;
import io.cm.cmstorkback.dto.out.CustomerProfileOutDTO;
import io.cm.cmstorkback.exception.ClientException;
import io.cm.cmstorkback.po.Customer;
import io.cm.cmstorkback.service.CustomerService;
import io.cm.cmstorkback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){
        Integer customerId = customerService.register(customerRegisterInDTO);
        return customerId;
    }

    @GetMapping("/login")
    public CustomerLoginOutDTO login(CustomerLoginInDTO customerLoginInDTO) throws ClientException {
        Customer customer = customerService.getByUsername(customerLoginInDTO.getUsername());
        if(customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerLoginInDTO.getPassword().toCharArray(), encPwdDB);

        if(result.verified){
            CustomerLoginOutDTO customerLoginOutDTO = jwtUtil.issueToken(customer);
            return customerLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
    }

    @GetMapping("/getProfile")
    public CustomerProfileOutDTO getProfile(@RequestAttribute Integer customerId){

        Customer customer = customerService.getById(customerId);

        CustomerProfileOutDTO customerProfileOutDTO = new CustomerProfileOutDTO();
        customerProfileOutDTO.setCustomerId(customer.getCustomerId());
        customerProfileOutDTO.setUsername(customer.getUsername());
        customerProfileOutDTO.setRealName(customer.getRealName());
        customerProfileOutDTO.setMobile(customer.getMobile());
        customerProfileOutDTO.setMobileVerified(customer.getMobileVerified());
        customer.setEmail(customer.getEmail());
        customerProfileOutDTO.setEmailVerified(customer.getEmailVerified());

        return customerProfileOutDTO;
    }

    @PostMapping("/updateProfile")
    public void getProfile(@RequestBody CustomerUpdateProfileInDTO customerUpdateProfileInDTO,
                           @RequestAttribute Integer customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setRealName(customerUpdateProfileInDTO.getRealName());
        customer.setMobile(customerUpdateProfileInDTO.getMobile());
        customer.setEmail(customerUpdateProfileInDTO.getEmail());
        customerService.update(customer);
    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId) throws ClientException {
        Customer customer = customerService.getById(customerId);
        String encPwdDB = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerChangePwdInDTO.getOriginPwd().toCharArray(), encPwdDB);

        if(result.verified){
            String newPwd = customerChangePwdInDTO.getNewPwd();
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
            customer.setEncryptedPassword(bcryptHashString);
            customerService.update(customer);
        }else{
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }

    }

    @GetMapping("/getPwdResetCode")
    public String getPwdResetCode(@RequestParam String email){
        return null;
    }

    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPwdInDTO customerResetPwdInDTO){

    }




}
