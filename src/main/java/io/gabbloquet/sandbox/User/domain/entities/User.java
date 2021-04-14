package io.gabbloquet.sandbox.User.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String username;
    private String mail;
    private String picture;
    private String description;
    private String localisation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private LocalDateTime createdDate;
    private List<User> followers;
    private List<User> following;
}
