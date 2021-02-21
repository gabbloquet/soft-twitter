package io.gabbloquet.sandbox.Tweet.interfaces.entrypoints;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.User.domain.entities.User;

import java.net.http.HttpRequest;
import java.util.List;

public interface TweetOperations {
    Tweet tweeter(Tweet tweet);
    List<Tweet> getTweets(User user);
    HttpRequest delete(Tweet tweet);
}
