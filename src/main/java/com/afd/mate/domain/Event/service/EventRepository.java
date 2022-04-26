package com.afd.mate.domain.service;

import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.mongo.EventDocument;
import reactor.core.publisher.Mono;

public interface EventRepository {
    Mono<Void> deleteAll();

    Mono<Event> insert(Event event);
}
