package io.gabbloquet.sandbox.Tweet.domain.entities;

import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Notification {
    private Tweet tweet;
    private User concernedUser;
    private Boolean isAlreadyRead;
}
