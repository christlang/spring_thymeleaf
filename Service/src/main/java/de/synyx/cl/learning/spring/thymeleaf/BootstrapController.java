package de.synyx.cl.learning.spring.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BootstrapController {

    @GetMapping("/bootstrap")
    public String index() {
        return "bootstrap/00_index";
    }

    @GetMapping("/bootstrap/01_starter_template")
    public String template() {
        return "bootstrap/01_starter_template";
    }
}
