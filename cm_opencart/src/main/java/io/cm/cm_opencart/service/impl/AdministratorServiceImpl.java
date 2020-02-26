package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.AdministratorMapper;
import io.cm.cm_opencart.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;
}
