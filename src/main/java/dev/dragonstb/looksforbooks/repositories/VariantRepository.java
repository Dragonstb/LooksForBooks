package dev.dragonstb.looksforbooks.repositories;

import dev.dragonstb.looksforbooks.entities.VariantEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
public interface VariantRepository extends Neo4jRepository<VariantEntity, String> {

    List<VariantEntity> findByTitle(String name);

    List<VariantEntity> findByEdition(int edition);

    Optional<VariantEntity> findFirstByTitleAndEdition(String title, int edition);

}
