package com.elastamo.smarthousepartieserver.Services.interfaceService;

import com.elastamo.smarthousepartieserver.Models.Device;
import com.elastamo.smarthousepartieserver.Models.House;

import java.util.List;

public interface IDeviceService {
    Device addDevice(Device device);
    List<Device> getAll();
    String delete(Device id);
    Device findById(String is);
    Device update(House house,String id);
}
