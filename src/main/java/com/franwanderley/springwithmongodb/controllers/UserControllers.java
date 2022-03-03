package com.franwanderley.springwithmongodb.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.franwanderley.springwithmongodb.dto.UserDTO;
import com.franwanderley.springwithmongodb.model.User;
import com.franwanderley.springwithmongodb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
   @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<Void> insert(@RequestBody UserDTO userDto) {
      User user = userDto.converter();
      user = service.insert(user);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
      return ResponseEntity.created(uri).build();
   }
   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Void> delete(@PathVariable String id) {
      service.delete(id);
      return ResponseEntity.noContent().build();
   }
   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDto){
      User user = userDto.converter();
      user.setId(id);
      service.update(user);
      return ResponseEntity.noContent().build();
   }
}
