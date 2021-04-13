package io.gabbloquet.sandbox.Tweet.interfaces.entrypoints;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.domain.useCases.TweetService;
import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/tweets")
@AllArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    @PostMapping
    public Tweet tweeter(@RequestBody Tweet tweet) {
        return tweetService.createTweet(tweet);
    }

    @GetMapping
    public List<Tweet> getTweets() {
        return tweetService.getTweets();
    }

    @GetMapping("/user")
    public List<Tweet> getTweets(User user) {
        return tweetService.getTweets(user);
    }

    @DeleteMapping
    public HttpRequest delete(Tweet tweet) {
        return null;
    }
}
