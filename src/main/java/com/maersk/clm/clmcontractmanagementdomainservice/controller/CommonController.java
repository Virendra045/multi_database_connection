package com.maersk.clm.clmcontractmanagementdomainservice.controller;

import com.maersk.clm.clmcontractmanagementdomainservice.model.commonDTO.CommonContractDTO;
import com.maersk.clm.clmcontractmanagementdomainservice.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class CommonController {
    @Autowired
    private CommonService commonService;

    @PostMapping("/commonModel")
    public Mono<CommonContractDTO> saveModel1(@RequestBody CommonContractDTO commonModel, @RequestHeader Map<String, String> headers){
        return commonService.saveModel1(commonModel, headers.get("tenant"));
    }

    @GetMapping("/commonModel")
    public Flux<CommonContractDTO> getAll(@RequestHeader Map<String, String> headers){
        return commonService.getAll(headers.get("tenant"));
    }
}
