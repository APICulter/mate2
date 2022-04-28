package com.afd.mate.port.mongo;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.model.Event;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;
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
    private Mono<Event> convert(Mono<EventDocument> eventDocumentMono) {

        return eventDocumentMono.flatMap(EventDocument ->
            {final Event Event = new Event();
            Event.setEvent(EventDocument.getEventDocuments().stream().filter(eventDocumentMono -> EventDocument.isEvent()).collect(toList()));
            Event.setRepresent(EventDocument.getRepresent().isStudent());
            return Mono.just(Event);
            });
    }

    private Mono<StudentDto> convert(Mono<PersonDto> personDto) {

        return personDto.flatMap(personDto ->
        {final StudentDto studentDto = new StudentDto();
            studentDto.setStudents(persons.getPersons().stream().filter(person -> person.isStudent()).collect(toList()));
            studentDto.setRepresent(persons.getRepresent().isStudent());
            return Mono.just(studentDto);})}


}
