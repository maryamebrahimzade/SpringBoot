package com.trans.telepardaz.repositories;


import com.trans.telepardaz.config.logger.LogModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogModel, String> {
}
