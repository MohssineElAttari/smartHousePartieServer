package com.elastamo.smarthousepartieserver.Models;

import com.elastamo.smarthousepartieserver.Enum.DeviceStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
