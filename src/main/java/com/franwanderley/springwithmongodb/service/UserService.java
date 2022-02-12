package com.franwanderley.springwithmongodb.service;

import com.franwanderley.springwithmongodb.model.User;
import com.franwanderley.springwithmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
