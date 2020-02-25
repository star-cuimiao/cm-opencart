package io.cm.cm_opencart.controller;

import io.cm.cm_opencart.dto.in.ReturnUpdateActionInDTO;
import io.cm.cm_opencart.dto.out.PageOutDTO;
import io.cm.cm_opencart.dto.out.ReturnListOutDTO;
import io.cm.cm_opencart.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(@RequestParam(required = false) Integer order_id,
                                               @RequestParam(required = false) String customer_name,
                                               @RequestParam(required = false) Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){

    }
}
