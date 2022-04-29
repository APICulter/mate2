package com.afd.mate.api;

import com.afd.mate.domain.Event.service.GetEventService;
import com.afd.mate.domain.model.Event;
import io.swagger.models.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@WebFluxTest
public class GetEventApiTest {
    @Autowired
    private WebTestClient client;

    @MockBean
    private GetEventService getEventService;


    @Test
    void get() {
        // ma stack est init
        Event event = new Event();
        //si jamais on t'appele sur GetAll, retourne ce truc
        Mockito.when(getEventService.getAll()).thenReturn(Flux.just(event));
        //when j'appelle le controlleur
        WebTestClient.ResponseSpec result = makeGetRequest();
        // then le controlleur appelle le service
        // tester le code de retour
        // tester que le retour est bon => le body contient liste de event (le mock est bon)
        // tester que le controlleur a bien appelé le service (Spy)
        System.out.println(result.expectBody());


    }

    private WebTestClient.ResponseSpec makeGetRequest() {
        return client.get().uri("/events/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk();
    }
}
