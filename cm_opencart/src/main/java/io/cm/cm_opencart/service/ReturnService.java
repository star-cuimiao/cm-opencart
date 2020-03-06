package io.cm.cm_opencart.service;

import com.github.pagehelper.Page;
import io.cm.cm_opencart.po.Return;

public interface ReturnService {

    Page<Return> search(Integer pageNum);
}
