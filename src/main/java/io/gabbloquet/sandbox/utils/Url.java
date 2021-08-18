package io.gabbloquet.sandbox.utils;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Url {
    private long id;
    private String longUrl;
    private LocalDateTime createdDate;
    private LocalDateTime expiresDate;
}
