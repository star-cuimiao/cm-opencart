package io.cm.cm_opencart.service;

import io.cm.cm_opencart.po.Administrator;

import java.util.List;

public interface AdministratorService {

    Administrator getByUsername(String username);

    Administrator getById(Integer adminstratorId);

    void update(Administrator administrator);

    Integer create(Administrator administrator);

    void delete( Integer adminstratorId);

    void batchDelete(List<Integer> administratorIds);
}
