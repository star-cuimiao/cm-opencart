package io.cm.cm_opencart.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.cm.cm_opencart.dao.ReturnMapper;
import io.cm.cm_opencart.dto.in.ReturnSearchInDTO;
import io.cm.cm_opencart.po.Return;
import io.cm.cm_opencart.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page = returnMapper.search(returnSearchInDTO.getReturnId(),
                                                returnSearchInDTO.getOrderId(),
                                                returnSearchInDTO.getCustomerName(),
                                                returnSearchInDTO.getProductCode(),
                                                returnSearchInDTO.getProductName(),
                                                returnSearchInDTO.getStatus());
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }

    @Override
    public void update(Return aReturn) {
        returnMapper.updateByPrimaryKeySelective(aReturn);
    }
}
