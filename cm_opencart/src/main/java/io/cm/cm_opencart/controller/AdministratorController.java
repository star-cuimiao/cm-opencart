package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.in.*;
import io.cm.cm_opencart.dto.out.AdministratorGetProfileOutDTO;
import io.cm.cm_opencart.dto.out.AdministratorListOutDTO;
import io.cm.cm_opencart.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/long")
    public String login(@RequestParam String username,
                        @RequestParam String password){
        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer administratorId){
        return null;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }

    @GetMapping("/getList")
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam(required = false,defaultValue = "1") Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){

    }

    @GetMapping("/sendPasswordResetCodeToEmail")
    public void sendPasswordResetCodeToEmail(@RequestParam String email){

    }

    @PostMapping("/resetPassword")
    public void resetPasswordByEmail(@RequestBody AdministratorResetPwdEmailInDTO administratorResetPwdEmailInDTO){

    }

    @GetMapping("/sendPasswordResetCodeToMobile")
    public void sendPasswordResetCodeToMobile(@RequestParam String mobile){

    }

    @PostMapping("/resetPassword")
    public void resetPasswordByMobile(@RequestBody AdministratorResetPwdMobileInDTO administratorResetPwdMobileInDTO){

    }



}
