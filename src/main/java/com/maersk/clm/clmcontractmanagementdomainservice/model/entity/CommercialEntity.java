package com.maersk.clm.clmcontractmanagementdomainservice.model.entity;


import com.maersk.clm.clmcontractmanagementdomainservice.model.dto.CommercialDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "commercial")
public class CommercialEntity {
    private String firstName;
    private String lastName;
    private CommercialDTO commercial;
}
