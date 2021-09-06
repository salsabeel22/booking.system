package com.booking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.models.User;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
		 Optional <User>findByUsername(String username)	;

		public List<User> findAll();

		
		



	}

