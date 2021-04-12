package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.interfaces.providers.TweetRepository;
import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoTweet;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Profile("nosql")
public class MongoTweetRepository implements TweetRepository {

    private MongoSpringDataTweetRepository mongoSpringDataTweetRepository;

    @Override
    public Tweet save(Tweet tweet) {
        return mongoSpringDataTweetRepository.save(MongoTweet.fromTweet(tweet)).toTweet();
    }

    @Override
    public List<Tweet> findAll() {
        return mongoSpringDataTweetRepository.findAll()
            .stream()
            .map(MongoTweet::toTweet)
            .collect(Collectors.toList());
    }
}
