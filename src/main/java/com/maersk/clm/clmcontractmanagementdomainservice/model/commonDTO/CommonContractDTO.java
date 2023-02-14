package com.maersk.clm.clmcontractmanagementdomainservice.model.commonDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.maersk.clm.clmcontractmanagementdomainservice.model.dto.TenantCommercial;
import com.maersk.clm.clmcontractmanagementdomainservice.model.dto.TenantHr;
import com.maersk.clm.clmcontractmanagementdomainservice.model.enumDTO.TenantSourceEnum;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include =JsonTypeInfo.As.EXISTING_PROPERTY, property = "tenant",
        defaultImpl = CommonContractDTO.class, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TenantHr.class, name = "TENANT_HR"),
        @JsonSubTypes.Type(value = TenantCommercial.class, name = "TENANT_COMMERCIAL")
})

public class CommonContractDTO <T> {
    private String firstName;
    private String lastName;
    private T scope;
    private TenantSourceEnum tenant;
}
