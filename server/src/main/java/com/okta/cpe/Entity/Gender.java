package com.okta.cpe.Entity;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Gender")

public class Gender {

	@Id
	@SequenceGenerator(name = "Genderseq", sequenceName = "Genderseq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Genderseq")
	@Column(name = "GendertID", nullable = true)

	private @NonNull Long gender_id;
	private @NonNull String gender;
}