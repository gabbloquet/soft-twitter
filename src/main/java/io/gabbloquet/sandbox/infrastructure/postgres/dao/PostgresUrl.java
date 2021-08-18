package io.gabbloquet.sandbox.infrastructure.postgres.dao;

import io.gabbloquet.sandbox.utils.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "urls")
@Builder
public class PostgresUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String longUrl;
    private LocalDateTime createdDate;
    private LocalDateTime expiresDate;

    public Url toUrl() {
        return Url.builder()
                .id(id)
                .longUrl(longUrl)
                .createdDate(createdDate)
                .expiresDate(expiresDate)
                .build();
    }

    public static PostgresUrl fromUrl(Url url) {
        return new PostgresUrl().builder()
                .id(url.getId())
                .longUrl(url.getLongUrl())
                .createdDate(url.getCreatedDate())
                .expiresDate(url.getExpiresDate())
                .build();
    }
}
