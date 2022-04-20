package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Trainer;



@Repository
public interface TrainerRepo extends JpaRepository<Trainer,String> {

}
