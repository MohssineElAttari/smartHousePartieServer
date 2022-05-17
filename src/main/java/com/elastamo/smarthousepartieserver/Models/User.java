package com.elastamo.smarthousepartieserver.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.List;


@Document(collection = "user_collection")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String id;
    @Field(value = "username")
    private String username;
    @Field(value = "password")
    private String password;
    @DBRef(lazy = true)
    private Collection<House> houses;

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public User(String id,String username, String password) {
        this.username=username;
        this.password=password;
        this.id=id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", houses=" + houses +
                '}';
    }
}
