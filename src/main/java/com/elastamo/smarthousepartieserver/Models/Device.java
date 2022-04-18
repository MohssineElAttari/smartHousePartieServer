package com.elastamo.smarthousepartieserver.Models;

import com.elastamo.smarthousepartieserver.Enum.DeviceStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Device {
    @Id
    private String id;
    private String name;
    private String number;
    private DeviceStatus status;
    @DBRef
    private Room room;

    public Device(String name,String number,DeviceStatus status){
        this.name=name;
        this.number=number;
        this.status=status;
    }

}
