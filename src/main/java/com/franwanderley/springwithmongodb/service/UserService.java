package com.franwanderley.springwithmongodb.service;

import com.franwanderley.springwithmongodb.model.User;
import com.franwanderley.springwithmongodb.repository.UserRepository;
import com.franwanderley.springwithmongodb.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> 
            new ObjectNotFoundException("id "+ id + " não encontrado"
        ));
    }
    
    public User insert(User user) {
        return repo.insert(user);
    }

    public void delete(String id) {
        this.findById(id);
        repo.deleteById(id);
    }

   public void update(User user) {
       findById(user.getId());
       repo.save(user);
   }
}
