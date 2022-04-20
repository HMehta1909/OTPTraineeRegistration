package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.capg.model.Trainee;
import com.capg.model.Trainer;
import com.capg.model.Users;
import com.capg.repository.TraineeRepo;
import com.capg.repository.TrainerRepo;
//import com.capg.repository.TrainerRepo;
import com.capg.repository.UserRep;

@Service
public class TraineeService {
	@Autowired
	TraineeRepo TRepo;

	@Autowired
	TrainerRepo trainerRepo;

	@Autowired
	UserRep userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	List<Trainee> trainee;

	public List<Trainee> getAllTrainees() {
		return TRepo.findAll();
	}

	public Trainee addTrainee(Trainee trainee) {
		trainee = generateUserId(trainee);
		trainee = setTrainer(trainee);
		return TRepo.save(trainee);
	}

	private Trainee setTrainer(Trainee trainee) {
		Trainer trainer = restTemplate.getForObject("http://TRAINER-MICROSERVICE/Trainer/getTrainerObj/"+trainee.getTrainerName(), Trainer.class );
		trainee.setTrainer(trainer);
		return trainee;
	}

	private Trainee generateUserId(Trainee trainee) {
		Users user = trainee.getUser();
		user.setUserID("TNE-" + trainee.getTechnology().substring(0, 3) + "-" + (TRepo.count() + 1));
		trainee.setUser(user);
		return trainee;
	}

	public Boolean registerTrainee(Trainee trainee) {
		if (TRepo.save(trainee).equals(trainee))
			return true;
		else
			return false;
	}

	/*
	 * public Trainee getMaximumUserId(Trainee trainee) {
	 * if(trainee.getUser().getUserId().equals("TNE-"+trainee.getTechnology().
	 * substring(0,3)+"-2")) return TRepo.save(trainee); } else { return
	 * TRepo.save(trainee); }
	 * 
	 * }
	 */
	/*
	 * public String getById(String name){ trainee= TRepo.getById(name);
	 * if(trainee.getContact().charAt(3)!='-'||trainee.getContact().charAt(7)!='-')
	 * throw new TrainingBusinessException("556");
	 * if(trainee.getTechnology().isEmpty()) throw new
	 * TrainingBusinessException("713"); if(trainee.getDomain().isEmpty()) throw new
	 * TrainingBusinessException("717"); if(trainee.getEducation().isEmpty()) throw
	 * new TrainingBusinessException("719"); if(trainee.getLocation().isEmpty())
	 * throw new TrainingBusinessException("715"); if(trainee.getName().isEmpty())
	 * throw new TrainingBusinessException("712"); if(trainee.getPassOutYear()==0)
	 * throw new TrainingBusinessException("718");
	 * if(trainee.getTechnology().isEmpty()) throw new
	 * TrainingBusinessException("713");
	 * if(trainee.getTrainer().getUserId().isEmpty()) throw new
	 * TrainingBusinessException("556");
	 * 
	 * if(trainee.getUser().getUserId().isEmpty()) throw new
	 * 
	 * if(trainee.getUser().getUserName().matches("^[a-zA-Z0-9]*$")==false) throw
	 * new TrainingBusinessException("709"); }
	 */

}
