package io.gabbloquet.sandbox.infrastructure.mongodb.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tweets")
@Builder
public class MongoTweet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}
