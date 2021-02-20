package io.gabbloquet.sandbox.User.interfaces;

import io.gabbloquet.sandbox.entities.User;

import java.net.http.HttpRequest;

public interface UserOperations {
    User create(User user);
    User update(User user);
    HttpRequest delete(String userId);
    User get(String userId);
}
