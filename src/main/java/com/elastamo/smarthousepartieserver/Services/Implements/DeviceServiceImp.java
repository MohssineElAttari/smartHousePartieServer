package com.elastamo.smarthousepartieserver.Services.Implements;

import com.elastamo.smarthousepartieserver.Models.Device;
import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Repository.DeviceRepository;
import com.elastamo.smarthousepartieserver.Services.Interfaces.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImp implements IDeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public String delete(Device device) {
        deviceRepository.delete(device);
        return "deleted!";
    }

    @Override
    public Device findById(String id) {
        Device device=deviceRepository.findById(id).orElse(null);
        if (device!=null){
            return deviceRepository.findById(id).get();
        }else
        return null;
    }

    @Override
    public Device update(Device device) {
        Device device1= deviceRepository.findById(device.getId()).orElse(null);
        if (device!=null){
            return deviceRepository.save(device1);
        }else
            return null;
    }
}
