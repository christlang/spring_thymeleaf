package de.synyx.cl.learning.spring.thymeleaf.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MappingController {

    private ElementStore elementStore;

    public MappingController(ElementStore elementStore) {
        this.elementStore = elementStore;


        Element e = new Element();
        e.setName("Club Mate");
        e.setPrice(2000);
        elementStore.getCreateNewElement(e);
    }

    @GetMapping("/example")
    public String example(@RequestParam(value = "editNr", required = false, defaultValue="-1") int editNr, Model model) {

        model.addAttribute("element", elementStore.getElements().get(0));
        model.addAttribute("elements", elementStore.getElements());
        model.addAttribute("newElement", new Element());
        model.addAttribute("editNr", editNr);

        return "mapping/mapping-controller";
    }

    @PostMapping("/example/new")
    public String newElement(@ModelAttribute("name") String name, @ModelAttribute(value="price") int price) {
        Element e = new Element();
        e.setName(name);
        e.setPrice(price);

        elementStore.getCreateNewElement(e);

        return "redirect:/example";
    }

    @PostMapping("/example/new2")
    public String newElement2(@ModelAttribute("newElement") Element element) {

        elementStore.getCreateNewElement(element);

        return "redirect:/example";
    }

    @PostMapping("/example/edit")
    public String editElement(@ModelAttribute("editElement") Element element) {

        elementStore.getElements().set(element.getId(), element);

        return "redirect:/example";
    }
}
