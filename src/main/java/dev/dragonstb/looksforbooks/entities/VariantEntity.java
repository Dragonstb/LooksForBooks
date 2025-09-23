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
@Node("Variant")
public class VariantEntity {

    @Property("title")
    private String title;

    @Property("edition")
    private int edition;

    @Relationship(type="IN_LIBRARY", direction=Relationship.Direction.OUTGOING)
    private Set<LibraryEntity> inLibraries = new HashSet<>();

    @Relationship(type="IN_LANGUAGE", direction=Relationship.Direction.OUTGOING)
    private Set<LanguageEntity> inLanguages = new HashSet<>();

    @Relationship(type="HAS_VARIANT", direction=Relationship.Direction.INCOMING)
    private Set<BookEntity> ofBooks = new HashSet<>();

    public VariantEntity(String title, int edition) {
        this.title = title;
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Set<LibraryEntity> getInLibraries() {
        return inLibraries;
    }

    public void setInLibraries(Set<LibraryEntity> inLibraries) {
        this.inLibraries = inLibraries;
    }

    public Set<LanguageEntity> getInLanguages() {
        return inLanguages;
    }

    public void setInLanguages(Set<LanguageEntity> inLanguages) {
        this.inLanguages = inLanguages;
    }

    public Set<BookEntity> getOfBooks() {
        return ofBooks;
    }

    public void setOfBooks(Set<BookEntity> ofBooks) {
        this.ofBooks = ofBooks;
    }


}
