package com.afd.mate.e2e;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.model.Guest;
import com.afd.mate.domain.model.Organizer;
import com.afd.mate.domain.model.mapper.EventMapper;
import com.afd.mate.domain.model.mapper.OrganizerMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyStepdefs {

    @Autowired
    private EventRepository repository;

    Event evenement1;
    Organizer organizer1;
    List<Organizer> listeOrganisateurs1;
    List<Guest> listeParticipants;

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

    @And("un Evenement1 avec les informations suivantes existe")
    public void unEvenementAvecLesInformationsSuivantesExiste(DataTable table) {
        EventMapper eventMapper = new EventMapper();
        evenement1 = eventMapper.map(table.asMaps(String.class, String.class));
        System.out.println(evenement1);
    }

    @And("un Organisateur{int} avec les informations suivantes existe")
    public void unOrganisateurAvecLesInformationsSuivantesExiste(int arg0, DataTable table) {
        OrganizerMapper organizerMapper = new OrganizerMapper();
        organizer1 = organizerMapper.map(table.asMaps(String.class, String.class));

    }


    @And("une liste{int} de Organisateurs contient le Organisateur{int}")
    public void uneListeDeOrganisateursContientLeOrganisateur(int arg0, int arg1) {
        listeOrganisateurs1 = new ArrayList<>();
        listeOrganisateurs1.add(organizer1);
        System.out.println(listeOrganisateurs1);
    }

    @And("la liste{int} de Organisateurs existe dans Evenement{int}")
    public void laListeDeOrganisateursExisteDansEvenement(int arg0, int arg1) {
        evenement1.setOrganizerList(listeOrganisateurs1);
    }

    @And("une liste{int} vide de Participants existe")
    public void uneListeVideDeParticipantsExiste(int arg0) {
        listeParticipants = new ArrayList<>();
    }

    @And("la liste{int} de Participants existe dans Evenement{int}")
    public void laListeDeParticipantsExisteDansEvenement(int arg0, int arg1) {
        evenement1.setGuestList(listeParticipants);
    }
}
