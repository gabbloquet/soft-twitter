package io.gabbloquet.sandbox.Tweet.domain.useCases;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;

import java.util.List;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    List<Tweet> getTweets();
    List<Tweet> getTweets(String user);
    void delete(Tweet tweet);
}
