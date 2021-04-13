package io.gabbloquet.sandbox.Tweet.domain.useCases;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.interfaces.providers.TweetRepository;
import io.gabbloquet.sandbox.User.domain.entities.User;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    @Override
    public Tweet createTweet(Tweet tweet) {
        tweet.setLikes(new ArrayList<>());
        tweet.setDate(LocalDateTime.now());
        return tweetRepository.save(tweet);
    }

    @Override
    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    @Override
    public List<Tweet> getTweets(User user) {
        return null;
    }

    @Override
    public void delete(Tweet tweet) {

    }
}
