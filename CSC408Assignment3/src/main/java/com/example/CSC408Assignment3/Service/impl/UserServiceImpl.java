package com.example.CSC408Assignment3.Service.impl;

import com.example.CSC408Assignment3.Exception.ResourceNotFoundException;
import com.example.CSC408Assignment3.Model.User;
import com.example.CSC408Assignment3.Repository.UserRepository;
import com.example.CSC408Assignment3.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserByid(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));
    }

    //Think about whether or not this is needed.
    @Override
    public User updateUser(User user, long id) {

        // we need to check whether Patient with given id is exist in DB or not
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id));

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setTrees(user.getTrees());
        existingUser.setRewards(user.getRewards());

        // save existing Patient to DB
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {

        // check whether a Patient exist in a DB or not
        userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id));

        userRepository.deleteById(id);
    }
}
