package com.afd.mate.e2e;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.enumeration.REACTION;
import com.afd.mate.domain.enumeration.REGION;
import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.model.Guest;
import com.afd.mate.domain.model.Organizer;
import com.afd.mate.domain.model.Photo;
import com.afd.mate.domain.model.mapper.EventMapper;
import com.afd.mate.domain.model.mapper.OrganizerMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStepdefs {

    @Autowired
    private EventRepository repository;

    List<Guest> listeParticipants;

    Map<Integer, Event> events= new HashMap<>();
    Map<Integer, Organizer> organizers= new HashMap<>();
    Map<Integer, List<Organizer>> organizerList= new HashMap<>();
    Map<Integer, List<Photo>> photoList= new HashMap<>();
    Map<Integer, List<Guest>> guestList= new HashMap<>();
    Map<Integer, List<REACTION>> reactionsList= new HashMap<>();
    Map<Integer, List<REGION>> regionList= new HashMap<>();
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
    public void unEvenementAvecLesInformationsSuivantesExiste(int argo, DataTable table) {
        EventMapper eventMapper = new EventMapper();
        Event event=eventMapper.map(table.asMaps(String.class, String.class));
        events.put(argo, event);
        System.out.println(events.get(argo));
    }

    @And("un Organisateur{int} avec les informations suivantes existe")
    public void unOrganisateurAvecLesInformationsSuivantesExiste(int arg0, DataTable table) {
        OrganizerMapper organizerMapper = new OrganizerMapper();
        Organizer organizer = organizerMapper.map(table.asMaps(String.class, String.class));
        organizers.put(arg0, organizer);
    }


    @And("une liste{int} de Organisateurs contient le Organisateur{int}")
    public void uneListeDeOrganisateursContientLeOrganisateur(int arg0, int arg1) {
        List<Organizer>  listeOrganisateurs = new ArrayList<>();
        listeOrganisateurs.add(organizers.get(arg1));
        organizerList.put(arg0, listeOrganisateurs);
    }

    @And("la liste{int} de Organisateurs existe dans Evenement{int}")
    public void laListeDeOrganisateursExisteDansEvenement(int arg0, int arg1) {
        events.get(arg1).setOrganizerList(organizerList.get(arg0));
    }
    /*@And("une liste{int} vide de \\{participant} existe")
    public void uneListeVideDeParticipantExiste(int arg0, Guest guest) {
        List guest
        guestList.put(arg0, new ArrayList<>());
    }*/

    @And("une liste{int} vide de Participants existe")
    public void uneListeVideDeParticipantsExiste(int arg0) {
        guestList.put(arg0, new ArrayList<>());
    }

    @And("la liste{int} de Participants existe dans Evenement{int}")
    public void laListeDeParticipantsExisteDansEvenement(int arg0, int arg1) {
        events.get(arg1).setGuestList(guestList.get(arg0));
    }

    @And("une liste{int} vide de Photos post event existe")
    public void uneListeVideDePhotosPostEventExiste(int arg0) {
        photoList.put(arg0, new ArrayList<>());
    }

    @And("la liste{int} de Photos post event existe dans Evenement{int}")
    public void laListeDePhotosPostEventExisteDansEvenement(int arg0, int arg1) {
        events.get(arg1).setPhotoList(photoList.get(arg0));
    }

    @And("une liste{int} vide de Reactions existe")
    public void uneListeVideDeReactionsExiste(int arg0) {
        reactionsList.put(arg0, new ArrayList<>());
    }

    @And("la liste{int} de Reactions existe dans Evenement{int}")
    public void laListeDeReactionsExisteDansEvenement(int arg0, int arg1) {
        events.get(arg1).setReactions(reactionsList.get(arg0));
    }

    @And("une liste{int} vide de Regions existe")
    public void uneListeVideDeRegionsExiste(int arg0) {
        regionList.put(arg0, new ArrayList<>());
    }

    @And("la liste{int} de Regions existe dans Evenement{int}")
    public void laListeDeRegionsExisteDansEvenement(int arg0, int arg1) {
        events.get(arg1).setRegions(regionList.get(arg0));
    }

    @And("le Evenement{int} existe en base de donnee")
    public void leEvenementExisteEnBaseDeDonnee(int arg0) {
       repository.findOneById(events.get(arg0).get);
    }
}
