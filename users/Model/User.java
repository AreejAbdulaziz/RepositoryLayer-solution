package com.example.users.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "name cannot be null")
    @Size(min = 5,message = "enter name more than 4 letters")
    @Column(columnDefinition = "varchar(20) not null CHECK (LENGTH(name) > 4)")
    private String name;
    @NotNull(message = "user name cannot be null")
    @Size(min = 5,message = "enter user name more than 4 letters")
    @Column(columnDefinition = "varchar(20) unique not null CHECK (LENGTH(name) > 4)")
    private String userName;
    @NotNull(message = "password cannot be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotNull(message = "email cannot be null")
    @Email(message = "write correct email")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String email;
    @NotNull(message = "role cannot be null")
    @Pattern(regexp = "^(user|admin)$")
    @Column(columnDefinition = "varchar(10) not null check(role ='user' or role ='admin')")
    private String role;
    @NotNull(message = "age cannot be null")
    @Positive(message = "enter correct age")
    @Column(columnDefinition = "int not null ")
    private Integer age;


}
