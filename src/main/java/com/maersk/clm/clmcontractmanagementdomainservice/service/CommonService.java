package com.maersk.clm.clmcontractmanagementdomainservice.service;

import com.maersk.clm.clmcontractmanagementdomainservice.model.commonDTO.CommonContractDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommonService {
    Mono<CommonContractDTO> saveModel1(CommonContractDTO model, String tenantType);

    Flux<CommonContractDTO> getAll(String tenantType);
}
