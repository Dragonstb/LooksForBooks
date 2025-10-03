package dev.dragonstb.looksforbooks;

import dev.dragonstb.looksforbooks.projections.AuthorProjection;
import dev.dragonstb.looksforbooks.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
@Controller
@RequestMapping("/imp")
public class ImperativeController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public String getAuthorsAsPagedTable(Pageable pageable, Model model) {
        Page<AuthorProjection> page = authorRepository.getAllNamesOnly(pageable);

        long fromEntry = 1+pageable.getPageNumber()*pageable.getPageSize();
        long toEntry = fromEntry+pageable.getPageSize()-1;
        if(toEntry > page.getTotalElements()) {
            toEntry = page.getTotalElements();
        }

        model.addAttribute("fromEntry", fromEntry);
        model.addAttribute("toEntry", toEntry);
        model.addAttribute("page", page);
        
        return "authorTablePlaceholder";
    }

}
