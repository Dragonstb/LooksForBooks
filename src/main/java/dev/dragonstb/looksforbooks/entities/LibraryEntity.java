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
@Node("Library")
public class LibraryEntity {

    @Id
    @Property("lid")
    private final String lid;

    @Property("name")
    private String name;

    @Relationship(type="IN_LIBRARY", direction=Relationship.Direction.INCOMING)
    private Set<VariantEntity> providedVariants = new HashSet<>();

    public LibraryEntity(String lid, String name) {
        this.lid = lid;
        this.name = name;
    }

    public String getLid() {
        return lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VariantEntity> getProvidedVariants() {
        return providedVariants;
    }

    public void setProvidedVariants(Set<VariantEntity> providedVariants) {
        this.providedVariants = providedVariants;
    }


}
