package com.nondt.backend;

import java.util.stream.Stream;

import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RoomData implements ApplicationRunner {

	@Autowired
	private RoomRepository roomRepository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
        Stream.of( "ห้องผ่าตัด1","ห้องผ่าตัด2","ห้องผ่าตัด 3","ห้องตรวจ 1","ห้องตรวจ 2","ห้องตรวจภายใน","ห้องฉายรังสี",
        "ห้อง CT Scan1","ห้อง CT Scan 2","ห้อง X-ray","ห้องกายภาพ").forEach(rooms -> {
            Room room = new Room();
            room.setName(rooms);
            roomRepository.save(room);
        });
        roomRepository.findAll().forEach(System.out::println); 
    };
}
