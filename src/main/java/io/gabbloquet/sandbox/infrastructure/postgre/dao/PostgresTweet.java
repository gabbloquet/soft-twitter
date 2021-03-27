package io.gabbloquet.sandbox.infrastructure.postgre.dao;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tweets")
@Builder
public class PostgresTweet {

    @Id
    private UUID id = randomUUID();
    private String message;

    @ManyToOne
    private PostgresUser user;

    @ManyToMany
    private List<PostgresUser> likes = new ArrayList<>();

    @ManyToOne
    private PostgresTweet linkedTweet;
    private Timestamp date;

    public static PostgresTweet fromTweet(Tweet tweet) {
        return new PostgresTweet().builder()
            .message(tweet.getMessage())
            .likes(tweet.getLikes().stream().map(PostgresUser::fromUser).collect(Collectors.toList()))
            .linkedTweet(fromTweet(tweet.getLinkedTweet()))
            .date(Timestamp.valueOf(tweet.getDate()))
            .build();
    }

    public Tweet toTweet() {
        return new Tweet().builder()
            .id(this.id)
            .message(this.message)
            .user(PostgresUser.toUser(this.user))
            .likes(this.likes.stream().map(PostgresUser::toUser).collect(Collectors.toList()))
            .linkedTweet(this.linkedTweet.toTweet())
            .date(this.date.toLocalDateTime())
            .build();
    }
}
