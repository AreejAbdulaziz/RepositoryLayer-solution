package com.example.users.Service;

import com.example.users.Api.ApiException;
import com.example.users.Model.User;
import com.example.users.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user){
        User oldUser=userRepository.findUserById(id);
        if(oldUser==null){
            throw new ApiException("user not found");
        }
        oldUser.setName(user.getName());
        oldUser.setUserName(user.getUserName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());

        userRepository.save(oldUser);
    }
    public void deleteUser(Integer id){
        User user=userRepository.findUserById(id);
        if(user==null){
            throw new ApiException("user not found");
        }
        userRepository.delete(user);
    }
    public User findUser(String userName,String password){
        User user=userRepository.findUser(userName,password);
        if(user==null){
            throw new  ApiException("not found");
        }
        return user;
    }
    public User findUserByEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if(user==null){
            throw new ApiException("not found");
        }
        return user;
    }
    public List<User>usersAge(Integer age){
        List<User>users=userRepository.findUserByAgeGreaterThanEqual(age);
        if (users==null){
            throw new ApiException("not found");
        }
        return users;
    }

    public List<User>usersRole(String role){
        List<User>users=userRepository.findUserByRole(role);
        if (users==null){
            throw new ApiException("not found");
        }
        return users;
    }
}
