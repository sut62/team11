package com.nondt.backend;

import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
public class CustomerTest{
    private Validator validator;
        
    @Autowired
    private BookRoomRepository bookRoomRepository;
    
    @BeforeEach
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testBookRoomOKFullData(){
        BookRoom bookRoom = new BookRoom();
        BookRoom.setnote("Test")
        customer.setDateOfBook("15-01-2020");
        customer.setTimeOfStart("11:19");
        customer.setTimeOfEnd("11:20");

        bookRoom = bookRoomRepository.saveAndFlush(bookRoom);
        Optional<BookRoom> found = bookRoomRepository.findById(bookRoom.getId());
        assertEquals("Test", found.get().getnote());
        assertEquals("15-01-2020", found.get().getDateOfBook());
        assertEquals("11:19", found.get().getTimeOfStart());
        assertEquals("11:20", found.get().getTimeOfEnd());
        
    } 
}