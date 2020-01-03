package com.okta.cpe.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Department")

public class Department {

	@Id
	@SequenceGenerator(name = "Departmentseq", sequenceName = "Departmentseq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Departmentseq")
	@Column(name = "DepartmentID", nullable = true)

	private @NonNull Long department_id;
	private @NonNull String department;
}