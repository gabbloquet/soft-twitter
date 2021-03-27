package io.gabbloquet.sandbox.infrastructure.postgre.repository;

import io.gabbloquet.sandbox.infrastructure.postgre.dao.PostgresTweet;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresSpringDataTweetRepository extends JpaRepository<PostgresTweet, UUID> {

}
