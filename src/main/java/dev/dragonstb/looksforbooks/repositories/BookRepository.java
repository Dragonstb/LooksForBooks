package dev.dragonstb.looksforbooks.repositories;

import dev.dragonstb.looksforbooks.entities.BookEntity;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
public interface BookRepository extends Neo4jRepository<BookEntity, String> {

    List<BookEntity> findByTitle(String name);
}
