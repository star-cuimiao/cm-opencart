package io.cm.cm_opencart.service.impl;

import io.cm.cm_opencart.dao.ReturnHistoryMapper;
import io.cm.cm_opencart.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnHistoryServiceImpl implements ReturnService {
    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;
}
