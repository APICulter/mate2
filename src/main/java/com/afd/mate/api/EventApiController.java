package com.afd.mate.api;

import com.afd.mate.domain.Event.service.GetEventService;
import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.model.EventDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EventApiController implements EventsApiDelegate{

    @Override
    public Mono<ResponseEntity<Flux<EventDTO>>> eventsGet(ServerWebExchange exchange) {



    }


}
