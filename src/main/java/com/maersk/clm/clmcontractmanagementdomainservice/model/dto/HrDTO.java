package com.maersk.clm.clmcontractmanagementdomainservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HrDTO {
    private String id;
    private String name;
}
