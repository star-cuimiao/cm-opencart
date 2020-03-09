package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.dto.in.ReturnSearchInDTO;
import io.cm.cm_opencart.po.Return;

public interface ReturnService {

    Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum);

    Return getById(Integer returnId);

    void update(Return aReturn);
}
