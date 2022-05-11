package in.ravi.springbootvalidationandexceptionhandling.service;

import in.ravi.springbootvalidationandexceptionhandling.common.UserRequest;
import in.ravi.springbootvalidationandexceptionhandling.entity.User;
import in.ravi.springbootvalidationandexceptionhandling.exception.UserNotFoundException;
import in.ravi.springbootvalidationandexceptionhandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User postUser(UserRequest userRequest) {
        User user = User.build(0,
                userRequest.getUserName(),
                userRequest.getEmail(),
                userRequest.getPhone(),
                userRequest.getGender(),
                userRequest.getAge()
        );
        return userRepository.save(user);
    }

    public User getUser(int userId) throws UserNotFoundException {
        User user = userRepository.getByUserId(userId);
        if(user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User Id is not Valid");
        }
    }
}
