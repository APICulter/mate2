package com.afd.mate.e2e;

import com.afd.mate.domain.Event.service.EventRepository;
import com.afd.mate.domain.Event.service.GetEventService;
import com.afd.mate.domain.enumeration.REACTION;
import com.afd.mate.domain.enumeration.REGION;
import com.afd.mate.domain.model.Event;
import com.afd.mate.domain.model.Photo;
import com.afd.mate.domain.model.temp.Guest;
import com.afd.mate.domain.model.temp.Organizer;
import com.afd.mate.domain.mapper.EventMapper;
import com.afd.mate.domain.mapper.OrganizerMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    @Autowired
    private EventRepository repository;
    @Autowired
    private GetEventService getEventService;

    List<Guest> listeParticipants;

    Map<Integer, Event> events= new HashMap<>();
    Map<Integer, Organizer> organizers= new HashMap<>();
    Map<Integer, List<Organizer>> organizerList= new HashMap<>();
    Map<Integer, List<Photo>> photoList= new HashMap<>();
    Map<Integer, List<Guest>> guestList= new HashMap<>();
    Map<Integer, List<REACTION>> reactionsList= new HashMap<>();
    Map<Integer, List<REGION>> regionList= new HashMap<>();
    Flux<Event> eventList;
    @Given("une base de donnée ne contenant aucun Evenement existe")
    public void uneBaseDeDonnéeNeContenantAucunEvenementExiste() {

        repository.deleteAll().block();
    }



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
       Mono<Event> resultInsert = repository.insert(events.get(arg0));
        System.out.println(resultInsert.block().getTitle());
    }

    @When("la liste des Evenements est recuperee")
    public void laListeDesEvenementsEstRecuperee() {
        eventList = getEventService.getAll();
    }

    @Then("une liste de Evenements est renvoyee")
    public void uneListeDeEvenementsEstRenvoyee() {
    //vérifier que le type de l'objet renvoyé est bien "Liste de Event"
    }

    @And("la liste de Evenements renvoyee contient un unique Evenement")
    public void laListeDeEvenementsRenvoyeeContientUnUniqueEvenement() {
        long size = eventList.count().block().longValue();
        System.out.println(size);
        assertEquals(size,1);
    }

    @And("le premier Evenement de la liste de Evenements renvoyee possede les memes informations que Evenement{int}")
    public void lePremierEvenementDeLaListeDeEvenementsRenvoyeePossedeLesMemesInformationsQueEvenement(int arg0) {
        events.get(arg0).setId(eventList.take(1).single().block().getId());
        assertThat(eventList.take(1).single().block()).isEqualTo(events.get(arg0));
    }

    @And("le premier Evenement de la liste de Evenements renvoyee possede un identifiant")
    public void lePremierEvenementDeLaListeDeEvenementsRenvoyeePossedeUnIdentifiant() {
        assertThat(eventList.take(1).single().block().getId()!= null);
    }
}
