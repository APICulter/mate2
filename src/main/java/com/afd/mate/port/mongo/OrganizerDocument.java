package com.afd.mate.port.mongo;

import com.afd.mate.domain.model.Organizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDocument extends Organizer {
    @Id
    private ObjectId id;
}
