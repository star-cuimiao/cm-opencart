package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.in.ReturnHistoryCreateInDTO;
import io.cm.cm_opencart.dto.out.ReturnHistoryListOutDTO;
import io.cm.cm_opencart.po.ReturnHistory;
import io.cm.cm_opencart.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/returnhistory")
@CrossOrigin
public class ReturnHistoryController {

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @GetMapping("/getListReturnId")
    public List<ReturnHistoryListOutDTO> getListReturnId(@RequestParam Integer returnId){

        List<ReturnHistory> returnHistories = returnHistoryService.getListByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setReturnHistoryId(returnHistory.getReturnHistoryId());
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            returnHistoryListOutDTO.setCustomerNotified(returnHistory.getCustomerNotified());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());

        return returnHistoryListOutDTOS;
    }


    @PostMapping("/create")
    public Long create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){

        ReturnHistory returnHistory = new ReturnHistory();
        returnHistory.setReturnId(returnHistoryCreateInDTO.getReturnId());
        returnHistory.setReturnStatus(returnHistoryCreateInDTO.getReturnStatus());
        returnHistory.setComment(returnHistoryCreateInDTO.getComment());
        returnHistory.setTime(new Date());
        Boolean customerNotifeid = returnHistoryCreateInDTO.getCustomerNotifeid();
        returnHistory.setCustomerNotified(customerNotifeid);
        Long returnHistoryId = returnHistoryService.create(returnHistory);

        if (customerNotifeid != null && customerNotifeid){
            //todo send notification to customer
        }

        return returnHistoryId;
    }
}
