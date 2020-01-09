package com.nondt.backend.Controller;

import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat; 

  



import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class BookRoomController {
    @Autowired
    private  BookRoomRepository bookRoomRepository;
    @Autowired
    private  ProfileRepository profileRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private PatientManagementRepository patientManagementRepository;

    BookRoomController(BookRoomRepository bookRoomRepository) {
        this.bookRoomRepository = bookRoomRepository;
    }

    @GetMapping("/Bookroom")
    public Collection<BookRoom> BookRoom() {
        return bookRoomRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Bookroom/{note}/{DateOfBook}/{TimeOfStart}/{TimeOfEnd}/{Roomid}/{ProfileId}/{PatientManagementId}")
    public BookRoom newBookroom(BookRoom newBookroom,
    @PathVariable String note,
    @PathVariable String DateOfBook,
    @PathVariable String TimeOfStart,
    @PathVariable String TimeOfEnd,
    @PathVariable long Roomid,
    @PathVariable long ProfileId,
    @PathVariable long PatientManagementId)
    throws ParseException {
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm");

    Profile profile = profileRepository.findById(ProfileId);
    PatientManagement patientManagement = patientManagementRepository.findById(PatientManagementId).get();
    Room room = roomRepository.findById(Roomid);
    
    newBookroom.setNote(note);
    newBookroom.setDateOfBook(dateFormat.parse(DateOfBook));
    newBookroom.setTimeOfStart(dateFormat2.parse(TimeOfStart));
    newBookroom.setTimeOfEnd(dateFormat2.parse(TimeOfEnd));
    newBookroom.setProfile(profile);
    newBookroom.setPatientManagement(patientManagement);
    newBookroom.setRoom(room);
    newBookroom.setBookDate(new Date());
    

    return bookRoomRepository.save(newBookroom); //บันทึก Objcet ชื่อ VideoRental
    
    }
}