package com.afd.mate.domain.Event.service;

import com.afd.mate.domain.model.Event;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetEventService {
    private final EventRepository repository;

    public GetEventService(EventRepository repository) {
        this.repository = repository;
    }

    public Mono<Event> get(ObjectId id
    ) {
        System.out.println("La connexion se fait bien");
        return repository.findOneById(id);
    }
}
