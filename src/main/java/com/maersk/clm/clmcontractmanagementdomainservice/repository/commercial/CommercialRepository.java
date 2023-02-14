package com.maersk.clm.clmcontractmanagementdomainservice.repository.commercial;

import com.maersk.clm.clmcontractmanagementdomainservice.model.entity.CommercialEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialRepository extends ReactiveMongoRepository<CommercialEntity, String> {
}
