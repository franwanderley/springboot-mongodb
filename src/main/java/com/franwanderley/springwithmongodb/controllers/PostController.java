package com.franwanderley.springwithmongodb.controllers;

import java.util.List;

import com.franwanderley.springwithmongodb.controllers.util.URL;
import com.franwanderley.springwithmongodb.model.Post;
import com.franwanderley.springwithmongodb.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
   
   @RequestMapping(value = "/search", method = RequestMethod.GET)
   public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="title", defaultValue = "") String title) {
      title = URL.decodeParam(title);
      List<Post> posts = service.findByTitle(title);
      return ResponseEntity.ok().body(posts);
   }
}
