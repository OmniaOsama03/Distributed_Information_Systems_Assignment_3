package com.example.CSC408Assignment3.Controller;

import com.example.CSC408Assignment3.Model.User;
import com.example.CSC408Assignment3.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/Users")
public class UserContoller {
    private UserService userService;

    public UserContoller(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    // http://localhost:8080/API/Users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserByid(@PathVariable("id") long userId){
        return new ResponseEntity<User>(userService.getUserByid(userId), HttpStatus.OK);
    }


    // http://localhost:8080/API/Users/1
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
    }


    // http://localhost:8080/API/Users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){

        // delete Patient from DB
        userService.deleteUser(id);

        return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
    }
}
