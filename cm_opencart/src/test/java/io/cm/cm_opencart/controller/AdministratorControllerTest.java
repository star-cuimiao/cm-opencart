package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.constant.ClientExceptionConstant;
import io.cm.cm_opencart.dto.in.AdministratorLoginInDTO;
import io.cm.cm_opencart.dto.out.AdministratorLoginOutDTO;
import io.cm.cm_opencart.exception.ClientException;
import io.cm.cm_opencart.po.Administrator;
import io.cm.cm_opencart.service.AdministratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class AdministratorControllerTest {

    @Autowired
    private AdministratorController administratorController;
    @MockBean
    private AdministratorService administratorService;

    @Test
    void login() throws ClientException {
        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("admin");
        administratorLoginInDTO.setPassword("admin");
        Administrator mockAdministrator = new Administrator();
        mockAdministrator.setUsername("admin");
        mockAdministrator.setEncryptedPassword("$12$53dZrUegvW6TbYtqs5dSy.IP9o8xApAjLEAmQ.A7Q1ykIM9NPADku");
        when(administratorService.getByUsername("admin")).thenReturn(mockAdministrator);
        AdministratorLoginOutDTO loginOutDTO = administratorController.login(administratorLoginInDTO);
        assertNotNull(loginOutDTO);
    }

    @Test
    void loginWrongUsername() {
        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("admin01");
        administratorLoginInDTO.setPassword("admin");
            try {
                AdministratorLoginOutDTO loginOutDTO = administratorController.login(administratorLoginInDTO);
            } catch (ClientException e) {
                String errCode = e.getErrCode();
                assertEquals(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE,errCode);
            }
    }
    @Test
    void loginWrongPassword() {
        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("admin");
        administratorLoginInDTO.setPassword("123456");
            try {
                AdministratorLoginOutDTO loginOutDTO = administratorController.login(administratorLoginInDTO);
            } catch (ClientException e) {
                String errCode = e.getErrCode();
                assertEquals(ClientExceptionConstant.ADMINISTRATOR_PASSWORD_INVALID_ERRCODE,errCode);
            }
    }
}