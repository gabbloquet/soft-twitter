package io.gabbloquet.sandbox.User.interfaces.entrypoints;

import io.gabbloquet.sandbox.User.domain.entities.User;
import io.gabbloquet.sandbox.User.domain.useCases.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private static final String RESOURCE_PATH = "{id}";
    private final UserService userService;

    @PostMapping()
    public User create(User user) {
        return userService.create(user);
    }

    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(RESOURCE_PATH)
    public User get(@PathVariable(required = false) String id) {
        return null;
    }

    @PatchMapping()
    public User update(User user) {
        return null;
    }

    @DeleteMapping()
    public void delete(String userId) {

    }
}
