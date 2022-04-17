package com.elastamo.smarthousepartieserver.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Floor {
    @Id
    private String id;
    private String name;
    private String number;
    @DBRef
    private House house;

    public Floor(String name,String number,House house){
        this.name=name;
        this.number=number;
        this.house=house;
    }
}
