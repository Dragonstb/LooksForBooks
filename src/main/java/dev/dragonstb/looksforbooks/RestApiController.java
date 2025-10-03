package dev.dragonstb.looksforbooks;

import dev.dragonstb.looksforbooks.projections.AuthorProjection;
import dev.dragonstb.looksforbooks.repositories.AuthorRepository;
import java.util.List;
import org.neo4j.cypherdsl.core.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
@RestController
@RequestMapping("rest")
public class RestApiController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public Page<AuthorProjection> getAllAuthors(Pageable pageable) {
        Page<AuthorProjection> authors = authorRepository.getAllNamesOnly(pageable);
        return authors;
    }

    @GetMapping("/authors-with-cdsl")
    public List<AuthorProjection> getAllAuthorsWithCypherDSL() {
        Statement statement = CypherDslStatements.getAllAuthorsButNamesOnly();
        List<AuthorProjection> authors = authorRepository.findAll( statement, AuthorProjection.class )
                .stream().toList();
        return authors;
    }

}
