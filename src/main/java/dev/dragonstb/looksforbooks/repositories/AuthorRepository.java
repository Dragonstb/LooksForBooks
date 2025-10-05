package dev.dragonstb.looksforbooks.repositories;

import dev.dragonstb.looksforbooks.entities.AuthorEntity;
import dev.dragonstb.looksforbooks.projections.AuthorProjection;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.support.CypherdslStatementExecutor;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
public interface AuthorRepository extends Neo4jRepository<AuthorEntity, String>, CypherdslStatementExecutor<AuthorEntity> {

    List<AuthorEntity> findByFirstName(String firstName);

    List<AuthorEntity> findByLastName(String lastName);

    @Query("MATCH (a:Author) RETURN a.firstName AS firstName, a.lastName AS lastName")
    List<AuthorProjection> getAllNamesOnly();

    @Query(value = "MATCH (a:Author) RETURN a.firstName AS firstName, a.lastName AS lastName, a.aid AS aid"
            + " ORDER BY lastName, firstName, aid ASC SKIP $skip LIMIT $limit",
            countQuery = "MATCH (a:Author) RETURN count(a)")
    Page<AuthorProjection> getAllNamesOnly(Pageable pageable);
}
