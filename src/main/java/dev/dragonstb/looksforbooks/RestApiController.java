package dev.dragonstb.looksforbooks;

import dev.dragonstb.looksforbooks.projections.AuthorProjection;
import dev.dragonstb.looksforbooks.repositories.AuthorRepository;
import java.util.List;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.Statement;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<AuthorProjection> getAllAuthors() {
        List<AuthorProjection> authors = authorRepository.getAllNamesOnly();
        return authors;
    }

    @GetMapping("/authors-with-cdsl")
    public List<AuthorProjection> getAllAuthorsWithCypherDSL() {
        List<AuthorProjection> authors = authorRepository.findAll(getAllAuthorsButNamesOnly(), AuthorProjection.class)
                .stream().toList();
        return authors;
    }

    static Statement getAllAuthorsButNamesOnly() {
        Node author = Cypher.node("Author").named("a");
        return Cypher.match(author)
                .returning(
                        author.property("firstName").as("firstName"),
                        author.property("lastName").as("lastName")
                ).build();
    }
}
