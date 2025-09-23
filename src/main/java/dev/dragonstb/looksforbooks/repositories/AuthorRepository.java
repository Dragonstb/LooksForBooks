package dev.dragonstb.looksforbooks.repositories;

import dev.dragonstb.looksforbooks.entities.AuthorEntity;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
public interface AuthorRepository extends Neo4jRepository<AuthorEntity, String> {

    List<AuthorEntity> findByFirstName(String firstName);

    List<AuthorEntity> findByLastName(String lastName);
}
