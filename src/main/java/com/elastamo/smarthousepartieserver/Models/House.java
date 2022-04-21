package com.elastamo.smarthousepartieserver.Models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    @DBRef
    private User user;

    @Override
    public String toString() {
        return "House{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public House(String name,User user) {
        this.name = name;
        this.user=user;
    }
}