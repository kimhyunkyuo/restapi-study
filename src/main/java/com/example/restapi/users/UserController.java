package com.example.restapi.users;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserBuId(@PathVariable Long id){
        System.out.println(id);
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserDto userDto){
        userDto.setWdate(LocalDateTime.now());

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);

        User dbuser = userService.regist( user );

        return ResponseEntity.status(HttpStatus.CREATED).body(dbuser);
    }

   }

