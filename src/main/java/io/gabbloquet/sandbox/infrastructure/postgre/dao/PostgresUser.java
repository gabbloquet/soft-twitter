package io.gabbloquet.sandbox.infrastructure.postgre.dao;

import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
public class PostgresUser {

    @Id
    private UUID id = randomUUID();
    private String name;
    private String username;
    private String mail;
    private String picture;
    private String description;
    private String localisation;
    private LocalDateTime birthdate;
    private LocalDateTime createdDate;

    @ManyToMany
    private List<PostgresUser> followers = new ArrayList<>();

    @ManyToMany
    private List<PostgresUser> following = new ArrayList<>();

    public static User toUser(PostgresUser postgresUser) {
        return new User().builder()
            .name(postgresUser.getName())
            .username(postgresUser.getUsername())
            .mail(postgresUser.getMail())
            .picture(postgresUser.getPicture())
            .description(postgresUser.getDescription())
            .localisation(postgresUser.getLocalisation())
            .birthdate(postgresUser.getBirthdate())
            .createdDate(postgresUser.getCreatedDate())
            .followers(postgresUser.getFollowers().stream().map(PostgresUser::toUser).collect(Collectors.toList()))
            .following(postgresUser.getFollowing().stream().map(PostgresUser::toUser).collect(Collectors.toList()))
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
