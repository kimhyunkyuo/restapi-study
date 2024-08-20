package com.example.restapi.users;

import com.example.restapi.exception.ErrorCode;
import com.example.restapi.exception.LogicException;
import com.example.restapi.exception.UserException;
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
            throw new UserException(ErrorCode.NOTFOUND);
        } else {
            return optionalUser.get();
        }

    }
}