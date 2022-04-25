package com.afd.mate.domain.mongo;

import com.afd.mate.domain.service.EventRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveEventMongoRepository extends EventRepository, ReactiveMongoRepository<EventDocument, ObjectId> {

}
