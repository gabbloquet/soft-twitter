package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.User.domain.entities.User;
import io.gabbloquet.sandbox.User.interfaces.providers.UserRepository;
import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoUser;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Profile("nosql")
public class MongoUserRepository implements UserRepository {

    private MongoSpringDataUserRepository mongoSpringDataUserRepository;

    @Override
    public User create(User user) {
        return mongoSpringDataUserRepository.save(MongoUser.fromUser(user)).toUser();
    }

    @Override
    public List<User> findAll() {
        return mongoSpringDataUserRepository.findAll()
            .stream()
            .map(MongoUser::toUser)
            .collect(Collectors.toList());
    }

    @Override
    public User get(User user) {
        return null;
    }
}
