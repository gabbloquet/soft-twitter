package io.gabbloquet.sandbox.User.domain.useCases;

import io.gabbloquet.sandbox.User.domain.entities.User;

public interface UserService {
    User create(User user);
    User update(User user);
    User get(String userId);
    void delete(String userId);
}
