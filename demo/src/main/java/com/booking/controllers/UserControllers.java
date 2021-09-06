package com.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dtos.AuthenticateDTO;

import com.booking.service.UserService;

@RestController
public class UserControllers {
@Autowired
public UserService userservice;
@PostMapping("/auth")
public String authenticate(@RequestBody AuthenticateDTO authdto){
if (userservice.authenticateUser(authdto.getUsername(), authdto.getPassword())) {
return "success";

}
return "false";
}}
