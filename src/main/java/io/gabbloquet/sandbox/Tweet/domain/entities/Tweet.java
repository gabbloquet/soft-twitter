package io.gabbloquet.sandbox.Tweet.domain.entities;

import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Tweet {
    private int id;
    private Number userId;
    private String message;
    private List<String> hashtags;
    private List<Tweet> retweets;
    private List<User> likes;
    private Tweet linkedTweet;
    private LocalDateTime date;
}
