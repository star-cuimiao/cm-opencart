package io.cm.cm_opencart.service;

import io.cm.cm_opencart.po.Administrator;

public interface AdministratorService {

    Administrator getByUsername(String username);

    Administrator getById(Integer adminstratorId);

    void update(Administrator administrator);
}
