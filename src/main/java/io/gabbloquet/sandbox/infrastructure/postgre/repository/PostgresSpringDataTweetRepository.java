package io.gabbloquet.sandbox.infrastructure.postgre.repository;

import io.gabbloquet.sandbox.infrastructure.postgre.dao.PostgresTweet;

import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("sql")
public interface PostgresSpringDataTweetRepository extends JpaRepository<PostgresTweet, UUID> {
}
