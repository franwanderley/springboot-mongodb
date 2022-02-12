package com.franwanderley.springwithmongodb.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.franwanderley.springwithmongodb.dto.UserDTO;
import com.franwanderley.springwithmongodb.model.User;
import com.franwanderley.springwithmongodb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserControllers {
   @Autowired
   private UserService service;

   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<List<UserDTO>> findAll() {
      List<User> users = service.findAll();
      List<UserDTO> usersDto = users.stream().map(u -> new UserDTO(u))
         .collect(Collectors.toList());
      return ResponseEntity.ok(usersDto);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public ResponseEntity<UserDTO> findById(@PathVariable String id) {
      UserDTO userDto = new UserDTO(service.findById(id));
      return ResponseEntity.ok(userDto);
   }
}
