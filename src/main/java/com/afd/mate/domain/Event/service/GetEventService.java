package com.afd.mate.domain.Event.service;

import com.afd.mate.domain.model.Event;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class GetEventService {
    private final EventRepository repository;

    public GetEventService(EventRepository repository) {
        this.repository = repository;
    }

    public Mono<Event> getById(ObjectId id
    ) {
        System.out.println("La connexion se fait bien");
        return repository.findOneById(id);
    }


    public Flux<Event> getAll() {
      return repository.findAll();
    }


    public Mono<Event> get(ObjectId objectId) {
    }
}
