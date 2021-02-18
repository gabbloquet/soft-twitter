package io.gabbloquet.sandbox.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
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
    private LocalDate birthdate;
    private LocalDate createdDate;
    private List<User> followers;
    private List<User> following;
}
