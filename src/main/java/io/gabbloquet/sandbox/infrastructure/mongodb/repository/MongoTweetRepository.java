package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.interfaces.providers.TweetRepository;
import io.gabbloquet.sandbox.infrastructure.postgre.repository.PostgresSpringDataTweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Profile("nosql")
public class MongoTweetRepository implements TweetRepository {

    private MongoSpringDataTweetRepository mongoSpringDataTweetRepository;

    @Override
    public Tweet save(Tweet tweet) {
        return null;
    }

    @Override
    public List<Tweet> findAll() {
        return null;
    }
}
