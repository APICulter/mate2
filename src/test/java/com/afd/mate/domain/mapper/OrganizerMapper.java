package com.afd.mate.domain.mapper;

import com.afd.mate.domain.model.temp.Organizer;

import java.util.List;
import java.util.Map;

public class OrganizerMapper {
    public Organizer map(List<Map<String, String>> asMaps) {
        Organizer result = new Organizer();
        result.setFirstName(asMaps.get(0).get("firstNameOrganisateur"));
        result.setLastName(asMaps.get(0).get("lastNameOrganisateur"));
        result.setEmail(asMaps.get(0).get("emailOrganisateur"));
        return result;
    }
}
