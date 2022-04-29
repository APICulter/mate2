package com.afd.mate.domain.Event.service;

import com.afd.mate.domain.model.Event;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Example;

import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EventRepository {
    Mono<Void> deleteAll();

    Mono<Event> insert(Event event);

    Flux<Event> findAll();

    //   Mono<Event> findOneById(ObjectId id);

    //Flux<Event> findAll(Sort sort);
}
