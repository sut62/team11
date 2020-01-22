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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
public class BookRoomTests{

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate dateOfBook = LocalDate.parse("2020-12-01", formatter);
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime timeOfStart = LocalTime.parse("00:00", formatter2);
    LocalTime timeOfEnd = LocalTime.parse("00:00", formatter2);
    Date bookDate = new Date();


    private Validator validator;
        
    @Autowired
    private BookRoomRepository bookRoomRepository;
    
    @BeforeEach
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void B6012755_testBookRoomOKFullData(){
        BookRoom bookRoom = new BookRoom();
        bookRoom.setNote("Test");
        bookRoom.setDateOfBook(dateOfBook);
        bookRoom.setTimeOfStart(timeOfStart);
        bookRoom.setTimeOfEnd(timeOfEnd);
        bookRoom.setBookDate(bookDate);
        

        bookRoom = bookRoomRepository.saveAndFlush(bookRoom);
        Optional<BookRoom> found = bookRoomRepository.findById(bookRoom.getId());
        assertEquals("Test", found.get().getNote());
        assertEquals(dateOfBook, found.get().getDateOfBook());
        assertEquals(timeOfStart, found.get().getTimeOfStart());
        assertEquals(timeOfEnd, found.get().getTimeOfEnd());
        assertEquals(bookDate, found.get().getBookDate());
    }

    @Test
    void testCustomerNameMustNotBeNull() {
        BookRoom bookRoom = new BookRoom();
        bookRoom.setNote(null);
        bookRoom.setDateOfBook(dateOfBook);
        bookRoom.setTimeOfStart(timeOfStart);
        bookRoom.setTimeOfEnd(timeOfEnd);
        bookRoom.setBookDate(bookDate);
        

        Set<ConstraintViolation<BookRoom>> result = validator.validate(bookRoom);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<BookRoom> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("note", v.getPropertyPath().toString());
    }

    @Test
    void B6008901_testScheduleWrongPast() {
        BookRoom bookRoom = new BookRoom();
    
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate DateofBook = LocalDate.parse("2019-01-20",formatter);
        bookRoom.setNote("Test");
        bookRoom.setDateOfBook(DateofBook);
        bookRoom.setTimeOfStart(timeOfStart);
        bookRoom.setTimeOfEnd(timeOfEnd);
        bookRoom.setBookDate(bookDate);
        
        Set<ConstraintViolation<BookRoom>> result = validator.validate(bookRoom);
        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<BookRoom> v = result.iterator().next();
        assertEquals("must be a date in the present or in the future", v.getMessage());
        assertEquals("DateOfBook", v.getPropertyPath().toString());
    }
}
