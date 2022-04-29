package com.afd.mate.port.mongo;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.model.Event;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class EventRepositoryImpl  implements EventRepository {

    private final ReactiveEventMongoRepository reactiveEventMongoRepository;
    @Override
    public Mono<Void> deleteAll() {
        reactiveEventMongoRepository.deleteAll();
        return Mono.empty();
    }

    @Override
    public Mono<Event> insert(Event event) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        EventDocument eventDocument = mapper.map(event, EventDocument.class);
        Mono<EventDocument> eventDocumentMono = reactiveEventMongoRepository.save(eventDocument);
        return convert(eventDocumentMono);
    }

    @Override
    public Flux<Event> findAll() {
        return convert(reactiveEventMongoRepository.findAll());
    }

    private Mono<Event> convert(Mono<EventDocument> eventDocumentMono) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return eventDocumentMono.flatMap(eventDocument ->
            {
                Event event = mapper.map(eventDocument,Event.class);
                return Mono.just(event);
            });
    }

    private Flux<Event> convert(Flux<EventDocument> eventDocumentFlux) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return eventDocumentFlux.map(eventDocument ->
        {
            Event event = mapper.map(eventDocument,Event.class);
            return event;
        });
    }




}
