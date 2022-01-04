package de.synyx.cl.learning.spring.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamplesController {

    @GetMapping("/examples")
    public String index() {
        return "examples/index";
    }

    @GetMapping("/examples/restrictedAccessThymeleafExample")
    public String restrictedAccessThymeleafExample(@RequestParam(value="index", defaultValue = "0") String index,Model model) {
        model.addAttribute("index", index);
        return "examples/restrictedAccessThymeleafExample";
    }

    @GetMapping("/examples/restrictedAccessThymeleafExampleSvg")
    public String restrictedAccessThymeleafExampleSvg(@RequestParam(value="index", defaultValue = "0") String index,Model model) {
        model.addAttribute("index", index);
        return "/examples/restrictedAccessThymeleafExampleSVG";
    }
}
