package io.gabbloquet.sandbox.Tweet.interfaces;

import io.gabbloquet.sandbox.entities.Tweet;
import io.gabbloquet.sandbox.entities.User;

import java.net.http.HttpRequest;
import java.util.List;

public interface TweetOperations {
    Tweet tweeter(Tweet tweet);
    List<Tweet> getTweets(User user);
    HttpRequest delete(Tweet tweet);
}
