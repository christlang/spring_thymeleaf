package de.synyx.cl.learning.spring.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class ExamplesController {

    SvgService svgService;

    public ExamplesController(SvgService svgService) {
        this.svgService = svgService;
    }

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
    @ResponseBody
    public String restrictedAccessThymeleafExampleSvg(@RequestParam(value="index", defaultValue = "0") String index,Model model) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("index", index);

        IContext context = new Context(Locale.GERMAN, variables);

        return svgService.createSvg("/examples/restrictedAccessThymeleafExample.svg", context);
    }
}
