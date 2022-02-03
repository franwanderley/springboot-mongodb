package com.franwanderley.springwithmongodb.controllers;

import java.util.Arrays;
import java.util.List;

import com.franwanderley.springwithmongodb.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserControllers {
   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<List<User>> findAll() {
      User maria = new User("1", "maria@gmail.com", "maria");
      User wanderley = new User("2", "wanderley@gmail.com", "wanderley");
      User eduarda = new User("3", "eduarda@gmail.com", "eduarda");
      return ResponseEntity.ok(Arrays.asList(maria, wanderley, eduarda));
   }
}
