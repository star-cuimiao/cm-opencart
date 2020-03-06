package io.cm.cmstorkback.service;

import com.github.pagehelper.Page;
import io.cm.cmstorkback.po.Return;

public interface ReturnService {

    Integer create(Return areturn);

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);

}
