package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.ReturnMapper;
import io.cm.cm_opencart.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnMapper returnMapper;
}
