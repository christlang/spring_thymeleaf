package de.synyx.cl.learning.spring.thymeleaf.mapping;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Element {

    private String name;
    private int price;
}
