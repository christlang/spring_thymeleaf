package de.synyx.cl.learning.spring.thymeleaf.mapping;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementStore {

    List<Element> elements = new ArrayList<>();

    public List<Element> getElements() {
        return elements;
    }

    public Element getCreateNewElement(Element element) {
        Element e = new Element();
        e.setId(elements.size());
        e.setName(element.getName());
        e.setPrice(element.getPrice());

        elements.add(e);

        return e;
    }
}
