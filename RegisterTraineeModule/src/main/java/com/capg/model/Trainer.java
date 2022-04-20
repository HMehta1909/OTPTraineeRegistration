package com.capg.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Trainer {
	@Id
	private String TrainerId;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "userID")
	private Users user;
	
	@NotEmpty
	@Size(min = 2, message = "MIN 2 char required.")
	private String name;
	
	@NotEmpty
	@Size(min = 2, message = "MIN 2 char required.")
	private String technology;
	@NotEmpty
	@Size(min = 2, message = "MIN 2 char required.")
	private String location;
	@NotEmpty
	@Size(min = 2, message = "MIN 2 char required.")
	private String contact;
	@Column(unique=true)
	@Email(message="Enter Correct Email")
	private String email;
}
