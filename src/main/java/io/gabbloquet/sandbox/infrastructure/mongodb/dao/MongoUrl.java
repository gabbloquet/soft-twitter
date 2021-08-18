package io.gabbloquet.sandbox.infrastructure.mongodb.dao;

import io.gabbloquet.sandbox.utils.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "urls")
@Builder
public class MongoUrl {

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

  public static MongoUrl fromUrl(Url url) {
    return new MongoUrl().builder()
      .id(url.getId())
      .longUrl(url.getLongUrl())
      .createdDate(url.getCreatedDate())
      .expiresDate(url.getExpiresDate())
      .build();
  }
}
