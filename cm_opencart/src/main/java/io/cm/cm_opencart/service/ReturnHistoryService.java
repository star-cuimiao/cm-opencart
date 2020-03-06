package io.cm.cm_opencart.service;

import io.cm.cm_opencart.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getListByReturnId(Integer returnId);

    Long create(ReturnHistory returnHistory);


}
