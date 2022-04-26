package com.afd.mate.domain.Event.service;

import com.afd.mate.domain.model.Event;
import reactor.core.publisher.Mono;

public interface EventRepository {
    Mono<Void> deleteAll();

    Mono<Event> insert(Event event);
}
