package com.nondt.backend.Entity;

import lombok.*;

import javax.persistence.Id;


import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Room")
public class Room {
    @Id
    @SequenceGenerator(name="Room_SEQ",sequenceName="Room_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Room_SEQ")
    @Column(name="Room_id",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String NameRoom;

}