package com.example.demo.service;

import com.example.demo.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class parkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    public List<Parking> findAll(){
        return parkingMap
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    static{
        var id = getUUID();
        Parking parking = new Parking(id, "DMS-111", "SC", "CELTA", "PRETO");
        parkingMap.put(id,parking);
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
