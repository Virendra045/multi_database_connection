package com.maersk.clm.clmcontractmanagementdomainservice.model.entity;

import com.maersk.clm.clmcontractmanagementdomainservice.model.dto.HrDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "hr")
public class HrEntity {
    private String firstName;
    private String lastName;
    private HrDTO hr;
}
