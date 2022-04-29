package com.afd.mate.port.mongo;

import com.afd.mate.domain.enumeration.REACTION;
import com.afd.mate.domain.enumeration.REGION;
import com.afd.mate.domain.model.Photo;
import com.afd.mate.domain.model.temp.Guest;
import com.afd.mate.domain.model.temp.Organizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "event")
public class EventDocument {
    @Id
    private ObjectId id;
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
