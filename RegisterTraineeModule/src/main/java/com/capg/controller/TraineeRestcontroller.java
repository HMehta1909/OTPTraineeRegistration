package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Trainee;
import com.capg.service.TraineeService;

@RestController
@RequestMapping("/Trainee")
public class TraineeRestcontroller {
	@Autowired
	TraineeService service;
	
	@GetMapping("/fetchtraineedetails")
	public ResponseEntity<List<Trainee>> fetchAllTrainee(){
		  List<Trainee> traineeObj=service.getAllTrainees();
		  return new ResponseEntity<List<Trainee>>(traineeObj,HttpStatus.OK);
	  }
	
	
	@PostMapping("/inserttraineedetails")
	public ResponseEntity<Trainee> addTraineeDetails(@Validated @RequestBody Trainee trainee) {
		  //System.out.println(book);
			Trainee traineeResponse =service.addTrainee(trainee);
			  return new ResponseEntity<Trainee>(traineeResponse,HttpStatus.OK);
		  }
	
	
	@PostMapping("/registertraineedetails")
	public ResponseEntity<Boolean> registerTraineeDetails( @RequestBody Trainee trainee) {
		  //System.out.println(book);
			Boolean bool=service.registerTrainee(trainee);
			  return new ResponseEntity<Boolean>(bool,HttpStatus.OK);
		  }

}
