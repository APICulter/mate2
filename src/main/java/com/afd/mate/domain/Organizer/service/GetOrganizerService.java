package com.afd.mate.domain.Organizer.service;

import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.model.Organizer;
import org.bson.types.ObjectId;
import reactor.core.publisher.Mono;

public class GetOrganizerService {
    private final OrganizerRepository repository;

    public GetOrganizerService(OrganizerRepository repository) {
        this.repository = repository;
    }

    public Mono<Organizer> get(ObjectId id
    ) {
        System.out.println("La connexion se fait bien");
        return repository.findOneById(id);
    }
}
