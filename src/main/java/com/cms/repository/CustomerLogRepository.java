package com.cms.repository;

import com.cms.log.CustomerLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLogRepository extends CrudRepository<CustomerLog, Integer> {

}
