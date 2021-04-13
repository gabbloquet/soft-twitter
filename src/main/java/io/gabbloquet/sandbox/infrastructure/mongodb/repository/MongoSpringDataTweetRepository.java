package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoTweet;
import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoUser;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Profile("nosql")
public interface MongoSpringDataTweetRepository extends MongoRepository<MongoTweet, String> {
    List<MongoTweet> findByUserOrderByDateDesc(MongoUser user);
}
