package com.cpe.backend.entity.employee_entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Admin")
public class AdminHR {
	@Id
	@SequenceGenerator(name = "AdminHR_seq", sequenceName = "AdminHR_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AdminHR_seq")
	@Column(name = "AdminHR_ID", unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String adminHRusername;
	private @NonNull String adminHRpassword;

}