package com.okta.cpe.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Maritalstatus")

public class Maritalstatus {

	@Id
	@SequenceGenerator(name = "Maritalstatusseq", sequenceName = "Maritalstatusseq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Maritalstatustseq")
	@Column(name = "MaritalstatusID", nullable = true)

	private @NonNull Long id;
	private @NonNull String status;
}