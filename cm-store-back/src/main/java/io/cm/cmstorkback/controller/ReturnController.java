package io.cm.cmstorkback.controller;

import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.in.ReturnApplyInDTO;
import io.cm.cmstorkback.dto.out.PageOutDTO;
import io.cm.cmstorkback.dto.out.ReturnHistoryListOutDTO;
import io.cm.cmstorkback.dto.out.ReturnListOutDTO;
import io.cm.cmstorkback.dto.out.ReturnShowOutDTO;
import io.cm.cmstorkback.enumeration.ReturnStatus;
import io.cm.cmstorkback.po.Return;
import io.cm.cmstorkback.po.ReturnHistory;
import io.cm.cmstorkback.service.ReturnHistoryService;
import io.cm.cmstorkback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                         @RequestAttribute Integer customerId) {
        Return aReturn = new Return();
        aReturn.setOrderId(returnApplyInDTO.getOrderId());
        aReturn.setOrderTime(new Date(returnApplyInDTO.getOrderTimestamp()));
        aReturn.setCustomerId(customerId);
        aReturn.setCustomerName(returnApplyInDTO.getCustomerName());
        aReturn.setMobile(returnApplyInDTO.getMobile());
        aReturn.setEmail(returnApplyInDTO.getEmail());
        aReturn.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        aReturn.setProductCode(returnApplyInDTO.getProductCode());
        aReturn.setProductName(returnApplyInDTO.getProductName());
        aReturn.setQuantity(returnApplyInDTO.getQuantity());
        aReturn.setReason(returnApplyInDTO.getReason());
        aReturn.setOpened(returnApplyInDTO.getOpened());
        aReturn.setComment(returnApplyInDTO.getComment());
        Date now = new Date();
        aReturn.setCreateTime(now);
        aReturn.setUpdateTime(now);
        returnService.create(aReturn);
        Integer returnId = aReturn.getReturnId();
        return returnId;
    }

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum) {
        Page<Return> page = returnService.getPageByCustomerId(customerId, pageNum);
        List<ReturnListOutDTO> returnListOutDTOS = page.stream().map(Return -> {

            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(Return.getReturnId());
            returnListOutDTO.setStatus(Return.getStatus());
            returnListOutDTO.setCreateTimestamp(Return.getCreateTime().getTime());
            returnListOutDTO.setCustomerId(Return.getCustomerId());
            returnListOutDTO.setOrderId(Return.getOrderId());
            returnListOutDTO.setCustomerName(Return.getCustomerName());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO pageOutDTO = new PageOutDTO();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(returnListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId) {
        Return aReturn = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setAction(aReturn.getAction());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setOpened(aReturn.getOpened());
        returnShowOutDTO.setComment(aReturn.getComment());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());

        List<ReturnHistory> returnHistories = returnHistoryService.getByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        returnShowOutDTO.setReturnHistories(returnHistoryListOutDTOS);

        return returnShowOutDTO;
    }


    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId) {

    }




}