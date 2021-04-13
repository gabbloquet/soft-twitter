package io.gabbloquet.sandbox.Tweet.interfaces.providers;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.User.domain.entities.User;

import java.util.List;

public interface TweetRepository {
    Tweet save(Tweet tweet);
    List<Tweet> findAll();
    List<Tweet> find(User user);
}
