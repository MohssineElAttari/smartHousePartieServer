package com.elastamo.smarthousepartieserver.Services.Interfaces;

import com.elastamo.smarthousepartieserver.Models.Device;
import com.elastamo.smarthousepartieserver.Models.House;

import java.util.List;

public interface IDeviceService {
    Device addDevice(Device device);
    List<Device> getAll();
    String delete(Device id);
    Device findById(String id);
    Device update(Device device);
}
