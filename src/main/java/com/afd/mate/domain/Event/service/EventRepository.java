package com.afd.mate.domain.Event.service;

import com.afd.mate.domain.model.Event;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EventRepository {
    Mono<Void> deleteAll();

    Mono<Event> insert(Event event);

    Mono<Event> findOneById(ObjectId id);

    Flux<Event> findAll();
}
