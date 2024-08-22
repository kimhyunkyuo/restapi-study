package com.example.restapi.users;

import com.example.restapi.exception.ErrorCode;
import com.example.restapi.exception.LogicException;
import com.example.restapi.exception.UsersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User regist(User user) {
        // 중복 처리...
        // 해당 되는 email이 있으면 중복 나서 에러
        User emailUser = userRepository.findByEmail(user.getEmail());
        if (emailUser != null) {
            throw new LogicException(ErrorCode.DUPLICATE);
        }

        User dbUser = userRepository.save(user);
        return dbUser;
    }

    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UsersException(ErrorCode.NOTFOUND);
        } else {
            return optionalUser.get();
        }
    }
    public User updateuUser(User user){

        User emailUser = userRepository.findByEmail(user.getEmail());
        if(emailUser == null){
            throw new UsersException(ErrorCode.NOTUPDATEEMAIL);
        }
        emailUser.setWdate(user.getWdate());
        emailUser.setUsername(user.getUsername());
        emailUser.setPassword(user.getPassword());
        emailUser.setGender(user.getGender());
        User dbUser = userRepository.save(user);
        return dbUser;
    }

    public void delete(Long id) {
        Optional<User> dbUser = userRepository.findById(id);
        if(dbUser.isEmpty()){
            throw new UsersException(ErrorCode.NOTFOUND);
        }
        userRepository.delete(dbUser.get());
    }
}