package in.ravi.springbootvalidationandexceptionhandling.controller;

import in.ravi.springbootvalidationandexceptionhandling.common.UserRequest;
import in.ravi.springbootvalidationandexceptionhandling.entity.User;
import in.ravi.springbootvalidationandexceptionhandling.exception.UserNotFoundException;
import in.ravi.springbootvalidationandexceptionhandling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/postUser")
    public ResponseEntity<User> postUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(userService.postUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
}
