package com.okta.cpe.Entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "EntityRoom")

public class EntityRoom {

	@Id
	@SequenceGenerator(name = "Room_seq", sequenceName = "Room_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Room_seq")
	@Column(name = "RoomID", nullable = true)

	private @NonNull Long id;
    private @NonNull String NameRoom;

}