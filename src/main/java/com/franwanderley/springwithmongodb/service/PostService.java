package com.franwanderley.springwithmongodb.service;

import java.util.List;
import java.util.Optional;

import com.franwanderley.springwithmongodb.model.Post;
import com.franwanderley.springwithmongodb.repository.PostRepository;
import com.franwanderley.springwithmongodb.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
   @Autowired
   private PostRepository repo;

   public Post findById(String id) {
      Optional<Post> obj = repo.findById(id);
      return obj.orElseThrow(() -> 
          new ObjectNotFoundException("id "+ id + " não encontrado"
      ));
    }
    
    public List<Post> findByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}
