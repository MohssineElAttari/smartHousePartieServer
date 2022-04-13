package com.elastamo.smarthousepartieserver.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Getter
@Setter
@Builder
public class House {
    @Field
    private String id;

    @Field
    private String name;
}
