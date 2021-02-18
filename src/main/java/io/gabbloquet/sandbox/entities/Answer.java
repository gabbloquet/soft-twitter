package io.gabbloquet.sandbox.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Answer {
    private int id;
    private User from;
    private Tweet tweet;
    private LocalDate date;
}
