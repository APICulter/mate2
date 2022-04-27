package com.afd.mate.domain.service;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.Event.service.GetEventService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class GetEventServiceTest {
    private final EventRepository repository = mock(EventRepository.class);
    private final GetEventService subject = new GetEventService(repository);



    @Test
    void get(){

    }
}
