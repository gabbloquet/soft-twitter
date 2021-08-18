package io.gabbloquet.sandbox.Tweet.domain.useCases;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.interfaces.providers.TweetRepository;
import io.gabbloquet.sandbox.User.domain.entities.User;
import io.gabbloquet.sandbox.utils.UrlService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.parseBoolean;

@Service
@AllArgsConstructor
public class TweetServiceImpl implements TweetService {

    private final UrlService urlService;
    private final TweetRepository tweetRepository;

    @Override
    public Tweet createTweet(Tweet tweet) {
        tweet.setLikes(new ArrayList<>());
        tweet.setDate(LocalDateTime.now());

        String optionalUrl = tweet.getUrl();
        if(parseBoolean(optionalUrl)) {
            String shortUrl = urlService.convertToShortUrl(optionalUrl);
            tweet.replaceUrlBy(shortUrl);
        }

        return tweetRepository.save(tweet);
    }

    @Override
    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    @Override
    public List<Tweet> getTweets(String username) {
      User user = User.builder().username(username).build();
      return tweetRepository.find(user);
    }

    @Override
    public void delete(Tweet tweet) {

    }
}
