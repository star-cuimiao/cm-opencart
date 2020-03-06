package io.cm.cmstorkback.service;

import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.out.ReturnShowOutDTO;
import io.cm.cmstorkback.po.Return;

public interface ReturnService {

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    ReturnShowOutDTO getById(Integer returnId);

}
