package dev.dragonstb.looksforbooks.repositories;

import dev.dragonstb.looksforbooks.entities.LibraryEntity;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
public interface LibraryRepository extends Neo4jRepository<LibraryEntity, String> {

    List<LibraryEntity> findByName(String name);
}
