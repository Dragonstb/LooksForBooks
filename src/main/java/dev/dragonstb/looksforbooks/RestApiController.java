package dev.dragonstb.looksforbooks;

import dev.dragonstb.looksforbooks.entities.AuthorEntity;
import dev.dragonstb.looksforbooks.repositories.AuthorRepository;
import java.util.List;
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
    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity> authors = authorRepository.findAll();
        return authors;
    }

}
