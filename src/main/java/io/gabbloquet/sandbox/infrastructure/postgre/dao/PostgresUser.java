package io.gabbloquet.sandbox.infrastructure.postgre.dao;

import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
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

import static java.util.UUID.randomUUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
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
}
