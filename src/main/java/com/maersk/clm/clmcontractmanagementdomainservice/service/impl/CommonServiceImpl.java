package com.maersk.clm.clmcontractmanagementdomainservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maersk.clm.clmcontractmanagementdomainservice.model.commonDTO.CommonContractDTO;
import com.maersk.clm.clmcontractmanagementdomainservice.model.dto.CommercialDTO;
import com.maersk.clm.clmcontractmanagementdomainservice.model.dto.HrDTO;
import com.maersk.clm.clmcontractmanagementdomainservice.model.entity.CommercialEntity;
import com.maersk.clm.clmcontractmanagementdomainservice.model.entity.HrEntity;
import com.maersk.clm.clmcontractmanagementdomainservice.repository.commercial.CommercialRepository;
import com.maersk.clm.clmcontractmanagementdomainservice.repository.hr.HrRepository;
import com.maersk.clm.clmcontractmanagementdomainservice.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private HrRepository hrRepository;

   private ObjectMapper mapper;

    @Autowired
    private CommercialRepository commercialRepository;

    @Override
    public Mono<CommonContractDTO> saveModel1(CommonContractDTO model, String tenantType) {
           if(tenantType.equals("hr")) {

               return hrRepository.save(mapCommonModelToHr(model)).map(hrEntity ->  model);
           }else if(tenantType.equals("commercial")){
               return commercialRepository.save(mapCommonModelToCommercial(model)).map(commercialEntity ->  model);
           }
           return Mono.empty();
    }

    @Override
    public Flux<CommonContractDTO> getAll(String tenantType) {
        if(tenantType.equals("hr")) {
            return hrRepository.findAll().map(hrEntity -> mapHrEntityToCommonModel(hrEntity));
        }else if(tenantType.equals("commercial")){
            return commercialRepository.findAll().map(commercialEntity -> mapCommercialEntityToCommonModel(commercialEntity));
        }
        return Flux.empty();
    }

    private HrEntity mapCommonModelToHr(CommonContractDTO model){
        mapper = new ObjectMapper();
        HrDTO hrDTO = mapper.convertValue(model.getScope(), HrDTO.class);

        var hr = HrEntity.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .hr(hrDTO)
                .build();
        return hr;
    }
    private CommercialEntity mapCommonModelToCommercial(CommonContractDTO model){

        mapper = new ObjectMapper();
        CommercialDTO commercialDTO = mapper.convertValue(model.getScope(), CommercialDTO.class);

        return CommercialEntity.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .commercial(commercialDTO)
                .build();
    }

    private CommonContractDTO mapHrEntityToCommonModel(HrEntity hr){
        mapper = new ObjectMapper();
        HrDTO hrDTO = mapper.convertValue(hr.getHr(), HrDTO.class);

        return CommonContractDTO.builder()
                .firstName(hr.getFirstName())
                .lastName(hr.getLastName())
                .scope(hrDTO)
                .build();
    }

    private CommonContractDTO mapCommercialEntityToCommonModel(CommercialEntity commercialEntity){
        mapper = new ObjectMapper();
        CommercialDTO commercialDTO = mapper.convertValue(commercialEntity.getCommercial(), CommercialDTO.class);
        return CommonContractDTO.builder()
                .firstName(commercialEntity.getFirstName())
                .lastName(commercialEntity.getLastName())
                .scope(commercialDTO)
                .build();
    }


}
