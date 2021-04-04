package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoTweet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoSpringDataTweetRepository extends MongoRepository<MongoTweet, UUID> {
}
