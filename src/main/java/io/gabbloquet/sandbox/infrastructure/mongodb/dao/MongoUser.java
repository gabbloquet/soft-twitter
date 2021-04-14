package io.gabbloquet.sandbox.infrastructure.mongodb.dao;

import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
@Builder
public class MongoUser {

    @Id
    private String username;
    private String name;
    private String mail;
    private String picture;
    private String description;
    private String localisation;
    private LocalDate birthdate;
    private LocalDateTime createdDate;

    @ManyToMany
    private List<MongoUser> followers = new ArrayList<>();

    @ManyToMany
    private List<MongoUser> following = new ArrayList<>();

    public User toUser() {
        return new User().builder()
            .name(name)
            .username(username)
            .mail(mail)
            .picture(picture)
            .description(description)
            .localisation(localisation)
            .birthdate(birthdate)
            .createdDate(createdDate)
            .followers(followers.stream().map(MongoUser::toUser).collect(Collectors.toList()))
            .following(following.stream().map(MongoUser::toUser).collect(Collectors.toList()))
            .build();
    }

    public static MongoUser fromUser(User user) {
        return new MongoUser().builder()
            .name(user.getName())
            .username(user.getUsername())
            .mail(user.getMail())
            .picture(user.getPicture())
            .description(user.getDescription())
            .localisation(user.getLocalisation())
            .birthdate(user.getBirthdate())
            .createdDate(user.getCreatedDate())
            .followers(user.getFollowers().stream().map(MongoUser::fromUser).collect(Collectors.toList()))
            .following(user.getFollowing().stream().map(MongoUser::fromUser).collect(Collectors.toList()))
            .build();
    }
}
