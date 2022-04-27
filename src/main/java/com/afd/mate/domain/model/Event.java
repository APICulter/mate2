package com.afd.mate.domain.model;

import com.afd.mate.domain.enumeration.REACTION;
import com.afd.mate.domain.enumeration.REGION;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String title;
    private String startDate;
    private String endDate;
    private String location;
    private String category;
    private String flag;
    private String state;
    private int numberOfPlace;
    private String description;
    private String photo;
    private List<Photo> photoList;
    private List<Organizer> organizerList;
    private List<Guest> guestList;
    private List<REACTION> reactions;
    private List<REGION> regions;
}
