package io.gabbloquet.sandbox.controllers;

import io.gabbloquet.sandbox.entities.User;
import io.gabbloquet.sandbox.useCases.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping(path = "/user")
public class UserController implements UserOperations {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping()
    public User create(User user) {
        return null;
    }

    @Override
    @PatchMapping()
    public User update(User user) {
        return null;
    }

    @Override
    @DeleteMapping()
    public HttpRequest delete(String userId) {
        return null;
    }

    @Override
    @GetMapping()
    public User get(String userId) {
        return this.userService.create();
    }
}
