package com.elastamo.smarthousepartieserver.Models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Document(collection = "house_collection")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    private String id;

    @Field
    private String name;

    private User user;

    @Override
    public String toString() {
        return "House{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
