package io.gabbloquet.sandbox.User.interfaces.providers;

import io.gabbloquet.sandbox.User.domain.entities.User;

import java.util.List;

public interface UserRepository {
    User create(User user);
    List<User> findAll();
    User get(User user);
}
