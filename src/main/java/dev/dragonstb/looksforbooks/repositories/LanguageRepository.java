package dev.dragonstb.looksforbooks.repositories;

import dev.dragonstb.looksforbooks.entities.LanguageEntity;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
public interface LanguageRepository extends Neo4jRepository<LanguageEntity, String> {

    List<LanguageEntity> findByCode(String code);
}
