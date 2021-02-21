package io.gabbloquet.sandbox.User.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String username;
    private String mail;
    private String picture;
    private String description;
    private String localisation;
    private LocalDateTime birthdate;
    private LocalDateTime createdDate;
    private List<User> followers;
    private List<User> following;
}
