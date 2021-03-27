package io.gabbloquet.sandbox.infrastructure.postgre.repository;

import io.gabbloquet.sandbox.infrastructure.postgre.dao.PostgresUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostgresSpringDataUserRepository extends JpaRepository<PostgresUser, UUID> {

}
