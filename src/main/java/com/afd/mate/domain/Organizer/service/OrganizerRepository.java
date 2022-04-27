package com.afd.mate.domain.Organizer.service;

import com.afd.mate.domain.model.Organizer;
import org.bson.types.ObjectId;
import reactor.core.publisher.Mono;

public interface OrganizerRepository {


    Mono<Organizer> findOneById(ObjectId id);
}
