package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.in.ReturnHistoryCreateInDTO;
import io.cm.cm_opencart.dto.out.ReturnHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    @GetMapping("/getListReturnId")
    public List<ReturnHistoryListOutDTO> getListReturnId(@RequestParam Integer returnId){
        return null;
    }


    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        return null;
    }
}
