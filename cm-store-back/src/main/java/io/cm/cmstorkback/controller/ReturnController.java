package io.cm.cmstorkback.controller;

import com.github.pagehelper.Page;
import io.cm.cmstorkback.dto.in.ReturnApplyInDTO;
import io.cm.cmstorkback.dto.out.PageOutDTO;
import io.cm.cmstorkback.dto.out.ReturnListOutDTO;
import io.cm.cmstorkback.dto.out.ReturnShowOutDTO;
import io.cm.cmstorkback.po.Return;
import io.cm.cmstorkback.service.ReturnHistoryService;
import io.cm.cmstorkback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        return null;
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
//        returnService.
        return null;
    }


    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId) {

    }




}
