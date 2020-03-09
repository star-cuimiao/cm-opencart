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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SecureRandom secureRandom;

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private Map<String,String> emailPwdResetCodeMap = new HashMap<>();

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
    public void getPwdResetCode(@RequestParam String email) throws ClientException {
        Customer customer = customerService.getByEmail(email);
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        byte[] bytes = secureRandom.generateSeed(3);
        String hex = DatatypeConverter.printHexBinary(bytes);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("jcart商店端客户密码重置");
        message.setText(hex);
        emailSender.send(message);
        //todo send messasge to MQ
        emailPwdResetCodeMap.put(email,hex);
    }

    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPwdInDTO customerResetPwdInDTO) throws ClientException {
        String email = customerResetPwdInDTO.getEmail();
        if(email == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_EMAIL_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_EMAIL_NONE_ERRMSG);
        }
        String innerResetCode = emailPwdResetCodeMap.get(email);
        if(innerResetCode == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_INNER_RESETCODE_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_INNER_RESETCODE_NONE_ERRMSG);
        }
        String outerResetCode = customerResetPwdInDTO.getResetCode();
        if(outerResetCode == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_OUTER_RESETCODE_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_OUTER_RESETCODE_NONE_ERRMSG);
        }
        if(!outerResetCode.equals(innerResetCode)){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_RESETCODE_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_RESETCODE_INVALID_ERRMSG);
        }
        Customer customer = customerService.getByEmail(email);
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRMSG);
        }
        String newPwd = customerResetPwdInDTO.getNewPwd();
        if (newPwd == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_NEWPWD_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_NEWPWD_NOT_EXIST_ERRMSG);
        }
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
        customer.setEncryptedPassword(bcryptHashString);
        customerService.update(customer);

        emailPwdResetCodeMap.remove(email);
    }




}
