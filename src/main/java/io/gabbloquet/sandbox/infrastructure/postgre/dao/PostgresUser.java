package io.gabbloquet.sandbox.infrastructure.postgre.dao;

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
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
public class PostgresUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String mail;
    private String picture;
    private String description;
    private String localisation;
    private LocalDate birthdate;
    private LocalDateTime createdDate;

    @ManyToMany
    private List<PostgresUser> followers = new ArrayList<>();

    @ManyToMany
    private List<PostgresUser> following = new ArrayList<>();

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
            .followers(followers.stream().map(PostgresUser::toUser).collect(Collectors.toList()))
            .following(following.stream().map(PostgresUser::toUser).collect(Collectors.toList()))
            .build();
    }

    public static PostgresUser fromUser(User user) {
        return new PostgresUser().builder()
            .name(user.getName())
            .username(user.getUsername())
            .mail(user.getMail())
            .picture(user.getPicture())
            .description(user.getDescription())
            .localisation(user.getLocalisation())
            .birthdate(user.getBirthdate())
            .createdDate(user.getCreatedDate())
            .followers(user.getFollowers().stream().map(PostgresUser::fromUser).collect(Collectors.toList()))
            .following(user.getFollowing().stream().map(PostgresUser::fromUser).collect(Collectors.toList()))
            .build();
    }
}
