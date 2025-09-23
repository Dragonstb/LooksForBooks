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
@Node("Book")
public class BookEntity {

    @Property("title")
    private String title;

    @Relationship(type="IN_LANGUAGE", direction=Relationship.Direction.OUTGOING)
    private Set<LanguageEntity> inLanguages = new HashSet<>();

    @Relationship(type="HAS_VARIANT", direction=Relationship.Direction.OUTGOING)
    private Set<VariantEntity> inVariants = new HashSet<>();

    public BookEntity(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<LanguageEntity> getInLanguages() {
        return inLanguages;
    }

    public void setInLanguages(Set<LanguageEntity> inLanguages) {
        this.inLanguages = inLanguages;
    }

    public Set<VariantEntity> getInVariants() {
        return inVariants;
    }

    public void setInVariants(Set<VariantEntity> inVariants) {
        this.inVariants = inVariants;
    }

    
}
