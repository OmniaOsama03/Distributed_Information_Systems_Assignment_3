package com.example.CSC408Assignment3.Service;
import com.example.CSC408Assignment3.Model.User;
import java.util.List;


public interface UserService {

    User saveUser(User Patient);
    List<User> getAllUsers();
    User getUserByid(long id);
    User updateUser(User patient, long id);
    void deleteUser(long id);

    //Any other method that has to do with a user:

}
