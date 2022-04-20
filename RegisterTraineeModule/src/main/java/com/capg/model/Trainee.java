package com.capg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trainee {
	@Id
	private String traineeId;
	//@Id
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "userID")
	private Users user;
	@NotBlank
	private String Name;
	@NotBlank
	@Transient
	private String trainerName;
	private String technology;
	@NotBlank
	private String location;
	//@ManyToOne
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="trainerId")
	private Trainer trainer;
	@NotBlank
	private String contact;
	@NotBlank
	private String domain;
	@NotNull
	private int passOutYear;
	@NotBlank
	private String education;
}
