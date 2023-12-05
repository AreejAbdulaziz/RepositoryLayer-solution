package com.example.users.Repository;

import com.example.users.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    @Query("select u from User u where u.userName=?1 and u.password=?2") //u obj not table
    User findUser(String username,String password);
    User findUserByEmail(String email);
    List<User> findUserByAgeGreaterThanEqual(Integer age);
    List<User> findUserByRole(String role);

}
