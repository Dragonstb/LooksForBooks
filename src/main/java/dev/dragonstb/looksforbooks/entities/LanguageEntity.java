package dev.dragonstb.looksforbooks.entities;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
@Node("Language")
public class LanguageEntity {

    @Id
    @Property("code")
    private final String code;

    @Property("name")
    private String name;

    @Relationship(type="IN_LANGUAGE", direction=Relationship.Direction.INCOMING)
    private Set<VariantEntity> ofVariants = new HashSet<>();

    @Relationship(type="IN_LANGUAGE", direction=Relationship.Direction.INCOMING)
    private Set<BookEntity> ofBooks = new HashSet<>();

    public LanguageEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VariantEntity> getOfVariants() {
        return ofVariants;
    }

    public void setOfVariants(Set<VariantEntity> ofVariants) {
        this.ofVariants = ofVariants;
    }

    public Set<BookEntity> getOfBooks() {
        return ofBooks;
    }

    public void setOfBooks(Set<BookEntity> ofBooks) {
        this.ofBooks = ofBooks;
    }


}
