package com.afd.mate.domain.model.mapper;


import com.afd.mate.domain.model.Event;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventMapper {

    public Event map(List<Map<String, String>> maps) {
        Event result = new Event();
        result.setTitle(maps.get(0).get("titleEvenement"));
        result.setStartDate(LocalDateTime.parse(maps.get(0).get("startDateEvenement")));
        result.setEndDate(LocalDateTime.parse(maps.get(0).get("endDateEvenement")));
        result.setLocation(maps.get(0).get("locationEvenement"));
        result.setCategory(maps.get(0).get("categoryEvenement"));
        result.setFlag(maps.get(0).get("flagEvenement"));
        result.setState(maps.get(0).get("stateEvenement"));
        result.setNumberOfPlace(Integer.parseInt(maps.get(0).get("nbOfPlacesEvenement")));
        result.setDescription(maps.get(0).get("descriptionEvenement"));
        result.setPhoto(maps.get(0).get("photoPreEventEvenement"));
//        ObjectMapper objectMapper = new ObjectMapper();
//        result. = objectMapper.convertValue(liste.get(0), Event.class);


        return result;
    }
}
