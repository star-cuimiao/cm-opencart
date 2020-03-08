package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.po.Administrator;

import java.util.List;

public interface AdministratorService {

    Page<Administrator> getList(Integer pageNum);

    Administrator getByUsername(String username);

    Administrator getById(Integer adminstratorId);

    void update(Administrator administrator);

    Integer create(Administrator administrator);

    void delete( Integer adminstratorId);

    void batchDelete(List<Integer> administratorIds);

    Administrator getByEmail(String email);
}
