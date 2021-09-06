package com.booking.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.models.User;
import com.booking.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	 private UserRepo userrepo ;
	public User getUserByUername(String username) {
	Optional<User> userOptional=  userrepo.findByUsername(username);
	if (userOptional.isPresent()) {
		return userOptional.get() ;}
	throw new ResponseStatusException( HttpStatus.NOT_FOUND, "user not found");// return 404 auto if not obj have url id 
	}

	public boolean authenticateUser(String username,String password) {
		User user= getUserByUername( username);//total user with password and all field  from db
		if(user.getPassword().equals(password)) // compare between password from req and password from db 
		{return true;
		}
		return false;
		}

}
