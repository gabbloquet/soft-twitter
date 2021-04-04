package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoSpringDataUserRepository extends MongoRepository<MongoUser, UUID> {
}
