package com.afd.mate.e2e;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.model.Location;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class MyStepdefs {

    @Autowired
    private EventRepository repository;


    @Given("une base de donnée ne contenant aucun Evenement existe")
    public void uneBaseDeDonnéeNeContenantAucunEvenementExiste() {
        repository.deleteAll();
    }

//    @And("un Evenement{int} avec les informations suivantes existe")
//    @ParameterType(".*")
//    public void unEvenementAvecLesInformationsSuivantesExiste(Event evenement) {
//        System.out.println(evenement);
//    }

    @And("un Evenement{int} avec les informations suivantes existe")
    public void unEvenementAvecLesInformationsSuivantesExiste() {
        Event evenement = new Event();
        evenement.setTitle("titleEvenement1");
        evenement.setStartDate(new Date());
        evenement.setEndDate(new Date());
        evenement.setLocation(new Location("13 rue des satellites"));
        evenement.setCategory("LINKERS");
        evenement.setState("TODO");
        evenement.setPhoto("photo");
        evenement.setDescription("Ceci est la description");
    }
}
