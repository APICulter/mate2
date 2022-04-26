package com.afd.mate.e2e;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.model.Organizer;
import com.afd.mate.domain.model.mapper.EventMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.mockito.internal.matchers.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyStepdefs {

    @Autowired
    private EventRepository repository;


    @Given("une base de donnée ne contenant aucun Evenement existe")
    public void uneBaseDeDonnéeNeContenantAucunEvenementExiste() {
        repository.deleteAll();
    }


//    @And("un Evenement{int} avec les informations suivantes existe")
//    public void unEvenementAvecLesInformationsSuivantesExiste(int arg1, DataTable table) {
//        //Event event1 = table.convert(Event.class, true);
//        ModelMapper modelMapper = new ModelMapper();
//        Event event1 = modelMapper.map(table, Event.class);
//        System.out.println(event1.getDescription());
//
//    }

    @And("un Evenement{int} avec les informations suivantes existe")
    public void unEvenementAvecLesInformationsSuivantesExiste(int arg1, DataTable table) {
        EventMapper eventMapper = new EventMapper();
        Event evenement1 = eventMapper.map(table.asMaps(String.class, String.class));
        System.out.println(evenement1.getTitle());
    }

    @And("un Organisateur{int} avec les informations suivantes existe")
    public void unOrganisateurAvecLesInformationsSuivantesExiste(int arg0, DataTable table) {
        System.out.println(arg0);
        System.out.println(table);
    }


    @And("une liste{int} de Organisateurs contient le Organisateur{int}")
    public void uneListeDeOrganisateursContientLeOrganisateur(int arg0, int arg1) {
        List<Organizer> liste1 = new ArrayList<>();
//        liste1.add(Organizerarg1);
    }
}
