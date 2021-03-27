package io.gabbloquet.sandbox.infrastructure.postgre.dao;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tweets")
public class PostgresTweet {

    @Id
    private UUID id = randomUUID();
    private String message;

    @ManyToMany
    private List<PostgresUser> likes = new ArrayList<>();
    private UUID linkedTweet;
    private Timestamp date;
}
