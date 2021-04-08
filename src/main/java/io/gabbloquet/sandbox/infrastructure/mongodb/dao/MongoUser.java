package io.gabbloquet.sandbox.infrastructure.mongodb.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
@Builder
public class MongoUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}
