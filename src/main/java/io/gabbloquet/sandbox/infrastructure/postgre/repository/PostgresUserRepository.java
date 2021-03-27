package io.gabbloquet.sandbox.infrastructure.postgre.repository;

import io.gabbloquet.sandbox.User.domain.entities.User;
import io.gabbloquet.sandbox.User.interfaces.providers.UserRepository;
import io.gabbloquet.sandbox.infrastructure.postgre.dao.PostgresUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class PostgresUserRepository implements UserRepository {

    private PostgresSpringDataUserRepository postgresSpringDataUserRepository;

    @Override
    public User create(User user) {
        return postgresSpringDataUserRepository.save(PostgresUser.fromUser(user)).toUser();
    }

    @Override
    public List<User> findAll() {
        return postgresSpringDataUserRepository.findAll()
            .stream()
            .map(PostgresUser::toUser)
            .collect(Collectors.toList());
    }

    @Override
    public User get(User user) {
        return null;
    }
}
