package io.gabbloquet.sandbox.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
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
    private List<Answer> answers;
    private LocalDate date;
}
