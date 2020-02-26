package io.cm.cmstorkback.dao;

import io.cm.cmstorkback.po.ReturnHistory;

public interface ReturnHistoryMapper {
    int deleteByPrimaryKey(Long returnHistoryId);

    int insert(ReturnHistory record);

    int insertSelective(ReturnHistory record);

    ReturnHistory selectByPrimaryKey(Long returnHistoryId);

    int updateByPrimaryKeySelective(ReturnHistory record);

    int updateByPrimaryKey(ReturnHistory record);
}