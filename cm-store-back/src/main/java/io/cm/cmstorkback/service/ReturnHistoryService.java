package io.cm.cmstorkback.service;

import io.cm.cmstorkback.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);
}
