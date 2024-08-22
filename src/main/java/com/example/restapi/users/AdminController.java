package com.example.restapi.users;

import com.example.restapi.exception.ErrorCode;
import com.example.restapi.exception.UsersException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;


    @GetMapping("users/{id}")
    public User getUserById(Long id){

            User user = userRepository.findById(id).orElseThrow(
                    () -> new UsersException(ErrorCode.NOTFOUND)
            );

        return new User();
    }

    @DeleteMapping("users/{id}")
    public User deleteUserById(Long id){

        return new User();
    }

}



