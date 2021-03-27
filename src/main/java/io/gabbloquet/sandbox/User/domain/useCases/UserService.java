package io.gabbloquet.sandbox.User.domain.useCases;

import io.gabbloquet.sandbox.User.domain.entities.User;

import java.util.List;

public interface UserService {
    User create(User user);
    List<User> getAll();
    User update(User user);
    User get(String userId);
    void delete(String userId);
}
