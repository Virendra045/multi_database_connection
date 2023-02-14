package com.maersk.clm.clmcontractmanagementdomainservice.repository.hr;

import com.maersk.clm.clmcontractmanagementdomainservice.model.entity.HrEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrRepository extends ReactiveMongoRepository<HrEntity, String> {
}
