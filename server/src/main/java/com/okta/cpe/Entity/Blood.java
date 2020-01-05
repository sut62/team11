package com.okta.cpe.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Blood")

public class Blood {

	@Id
	@SequenceGenerator(name = "Bloodseq", sequenceName = "Bloodseq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Bloodtseq")
	@Column(name = "Blood_ID", nullable = true)

	private @NonNull Long blood_id;
	private @NonNull String blood;
}