package dev.dragonstb.looksforbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Dragonstb
 * @since 0.0.1;
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "mainpage";
    }

}
