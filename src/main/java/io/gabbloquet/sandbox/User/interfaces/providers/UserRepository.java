package io.gabbloquet.sandbox.User.interfaces.providers;

import io.gabbloquet.sandbox.User.domain.entities.User;

public interface UserRepository {
    User create(User user);
    User get(User user);
}
