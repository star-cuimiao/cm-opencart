package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dao.ReturnHistoryMapper;
import io.cm.cm_opencart.dto.in.ReturnHistoryCreateInDTO;
import io.cm.cm_opencart.dto.out.ReturnHistoryListOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @GetMapping("/getListReturnId")
    public List<ReturnHistoryListOutDTO> getListReturnId(@RequestParam Integer returnId){
        return null;
    }


    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        return null;
    }
}
