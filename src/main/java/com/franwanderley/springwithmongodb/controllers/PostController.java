package com.franwanderley.springwithmongodb.controllers;

import com.franwanderley.springwithmongodb.model.Post;
import com.franwanderley.springwithmongodb.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/posts")
public class PostController {
   @Autowired
   private PostService service;
   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public ResponseEntity<Post> findById(@PathVariable String id) {
      Post post = service.findById(id);
      return ResponseEntity.ok().body(post);
   }
}
