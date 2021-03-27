package io.gabbloquet.sandbox.Tweet.domain.useCases;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.User.domain.entities.User;

import java.util.List;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    List<Tweet> getTweets();
    List<Tweet> getTweets(User user);
    void delete(Tweet tweet);
}
