package de.synyx.cl.learning.spring.thymeleaf.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MappingController {

    private List<Element> elements = new ArrayList<>();

    @GetMapping("/example")
    public String example(Model model) {

        Element e = new Element();
        e.setName("Club Mate");
        e.setPrice(2000);

        model.addAttribute("element", e);
        model.addAttribute("elements", elements);
        model.addAttribute("newElement", new Element());

        return "mapping/mapping-controller";
    }

    @PostMapping("/example/new")
    public String newElement(@ModelAttribute("name") String name, @ModelAttribute(value="price") int price) {
        Element e = new Element();
        e.setName(name);
        e.setPrice(price);

        elements.add(e);

        return "redirect:/example";
    }

    @PostMapping("/example/new2")
    public String newElement2(@ModelAttribute("newElement") Element element) {

        elements.add(element);

        return "redirect:/example";
    }
}
