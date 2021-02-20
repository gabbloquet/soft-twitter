package io.gabbloquet.sandbox.Tweet.entities;

import io.gabbloquet.sandbox.User.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Answer {
    private int id;
    private User from;
    private LocalDateTime date;
}
