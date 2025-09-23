package dev.dragonstb.looksforbooks.entities;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
@Node("Author")
public class AuthorEntity {

    @Property("firstName")
    private String firstName;

    @Property("lastName")
    private String lastName;

    @Relationship(type="AUTHOR_OF", direction=Relationship.Direction.OUTGOING)
    private Set<BookEntity> ofBooks = new HashSet<>();

    public AuthorEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<BookEntity> getOfBooks() {
        return ofBooks;
    }

    public void setOfBooks(Set<BookEntity> ofBooks) {
        this.ofBooks = ofBooks;
    }

    
}
