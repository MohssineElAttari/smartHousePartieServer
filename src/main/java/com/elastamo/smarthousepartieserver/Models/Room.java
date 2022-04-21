package com.elastamo.smarthousepartieserver.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @Id
    private String id;
    private Long number;
    @DBRef
    private Floor floor;
    @DBRef
    private Collection<Device> devices;

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", floor=" + floor +
                ", devices=" + devices +
                '}';
    }
}
