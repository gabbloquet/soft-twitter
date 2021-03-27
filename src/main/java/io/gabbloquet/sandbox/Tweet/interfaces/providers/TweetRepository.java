package io.gabbloquet.sandbox.Tweet.interfaces.providers;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;

public interface TweetRepository {
    Tweet save(Tweet tweet);
}
