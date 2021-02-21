package io.gabbloquet.sandbox.Tweet.interfaces.entrypoints;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.User.domain.entities.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController implements TweetOperations {

    @Override
    @PostMapping
    public Tweet tweeter(Tweet tweet) {
        return null;
    }

    @Override
    @GetMapping
    public List<Tweet> getTweets(User user) {
        return null;
    }

    @Override
    @DeleteMapping
    public HttpRequest delete(Tweet tweet) {
        return null;
    }
}
