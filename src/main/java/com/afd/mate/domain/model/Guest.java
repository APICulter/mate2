package com.afd.mate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private String firstName;
    private String lastName;
    private String email;
}
