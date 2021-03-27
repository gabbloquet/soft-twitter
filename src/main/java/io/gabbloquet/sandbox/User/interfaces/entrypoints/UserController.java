package io.gabbloquet.sandbox.User.interfaces.entrypoints;

import io.gabbloquet.sandbox.User.domain.entities.User;
import io.gabbloquet.sandbox.User.domain.useCases.UserService;
import io.gabbloquet.sandbox.User.domain.useCases.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public User create(User user) {
        return userService.create(user);
    }

    @PatchMapping()
    public User update(User user) {
        return null;
    }

    @DeleteMapping()
    public void delete(String userId) {

    }

    @GetMapping()
    public User get(String userId) {
        return null;
    }
}
