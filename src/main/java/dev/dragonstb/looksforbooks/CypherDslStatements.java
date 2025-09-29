package dev.dragonstb.looksforbooks;

import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.Statement;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
public final class CypherDslStatements {

    private static Statement ALL_AUTHORS_NAMES_ONLY = null;

    /** Gets the statement for quering a list of
     * {@link dev.dragonstb.looksforbooks.projections.AuthorProjection AuthorProjections}
     * @since 0.0.1
     * @author Dragonstb
     * @return Cypher DSL query statement.
     */
    public static final Statement getAllAuthorsButNamesOnly() {
        if( ALL_AUTHORS_NAMES_ONLY == null ) {
            Node author = Cypher.node("Author").named("a");
            ALL_AUTHORS_NAMES_ONLY = Cypher.match(author)
                    .returning(
                            author.property("firstName").as("firstName"),
                            author.property("lastName").as("lastName")
                    ).build();
        }

        return ALL_AUTHORS_NAMES_ONLY;
    }

}
