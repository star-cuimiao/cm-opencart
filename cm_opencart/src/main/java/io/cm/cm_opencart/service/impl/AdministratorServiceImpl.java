package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.AdministratorMapper;
import io.cm.cm_opencart.po.Administrator;
import io.cm.cm_opencart.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }

    @Override
    public Administrator getById(Integer adminstratorId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(adminstratorId);
        return administrator;
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Integer create(Administrator administrator) {
        int  administratorId = administratorMapper.insertSelective(administrator);
        return administratorId;
    }

    @Override
    public void delete(Integer adminstratorId) {
        administratorMapper.deleteByPrimaryKey(adminstratorId);
    }

    @Override
    public void batchDelete(List<Integer> administratorIds) {

    }
}
