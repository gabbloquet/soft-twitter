package io.gabbloquet.sandbox.infrastructure.mongodb.dao;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.infrastructure.postgres.dao.PostgresUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    private PostgresUser user;

    @ManyToMany
    private List<PostgresUser> likes = new ArrayList<>();

    @ManyToOne
    private MongoTweet linkedTweet;
    private Timestamp date;

    public static MongoTweet fromTweet(Tweet tweet) {
        return new MongoTweet().builder()
            .message(tweet.getMessage())
            .likes(tweet.getLikes().stream().map(PostgresUser::fromUser).collect(Collectors.toList()))
            .linkedTweet(fromTweet(tweet.getLinkedTweet()))
            .date(Timestamp.valueOf(tweet.getDate()))
            .build();
    }

    public Tweet toTweet() {
        return new Tweet().builder()
            .id(Long.valueOf(id))
            .message(message)
            .user(user.toUser())
            .likes(likes.stream().map(PostgresUser::toUser).collect(Collectors.toList()))
            .linkedTweet(linkedTweet.toTweet())
            .date(date.toLocalDateTime())
            .build();
    }
}
