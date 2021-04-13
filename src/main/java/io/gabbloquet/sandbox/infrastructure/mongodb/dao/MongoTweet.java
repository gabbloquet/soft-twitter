package io.gabbloquet.sandbox.infrastructure.mongodb.dao;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tweets")
@Builder
public class MongoTweet {

    @Id
    private String id;
    private String message;

    @ManyToOne
    private MongoUser user;

    @ManyToMany
    private List<MongoUser> likes = new ArrayList<>();

    @ManyToOne
    private MongoTweet linkedTweet;
    private Timestamp date;

    public static MongoTweet fromTweet(Tweet tweet) {
        if (tweet != null)
            return new MongoTweet().builder()
                .message(tweet.getMessage())
                .likes(tweet.getLikes().stream().map(MongoUser::fromUser).collect(Collectors.toList()))
                .linkedTweet(fromTweet(tweet.getLinkedTweet()))
                .date(Timestamp.valueOf(tweet.getDate()))
                .build();
        return null;
    }

    public Tweet toTweet() {
        if (this != null)
            return new Tweet().builder()
                .id(id)
                .message(message)
                .user(user != null ? user.toUser() : null)
                .likes(likes.stream().map(MongoUser::toUser).collect(Collectors.toList()))
                .linkedTweet(linkedTweet != null ? linkedTweet.toTweet() : null)
                .date(date.toLocalDateTime())
                .build();
        return null;
    }
}
