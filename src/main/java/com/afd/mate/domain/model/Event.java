package com.afd.mate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String title;
    private Date startDate;
    private Date endDate;
    private Location location;
    private String category;
    private String flag;
    private Boolean state;
    private int numberOfPlace;
    private String description;
    private String photo;
}
