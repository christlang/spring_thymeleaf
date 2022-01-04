

```shell
spring init --dependencies=web,thymeleaf,devtools --package-name de.synyx.cl.learning.spring.thymeleaf Service
```


## WebJars

* Anleitung: https://www.baeldung.com/maven-webjars
* Richtiges raus suchen: https://www.webjars.org/
* Bootstrap - Anleitung: https://getbootstrap.com/docs/5.1/getting-started/introduction/
* Spring-Boot Beispiel: https://spring.io/blog/2021/12/17/client-side-development-with-spring-boot-applications
* Webjars-Example: https://github.com/webjars/sample-spring_boot
* Grid-Layout-Anleitung: https://getbootstrap.com/docs/5.1/layout/grid/
* Flex-Box-Anleitung: https://css-tricks.com/snippets/css/a-guide-to-flexbox/#flexbox-background


## restricted access unter Thymeleaf

* https://github.com/thymeleaf/thymeleaf/issues/809
  * mehr Details: https://github.com/thymeleaf/thymeleaf/issues/816#issuecomment-826401631
* Fehler sollte mit thymeleaf version 3.0.12 auftreten
  * aber nur in th:attr nicht in th:text
* möglicher Workaround eigener Dialekt
  * https://www.thymeleaf.org/doc/articles/sayhelloextendingthymeleaf5minutes.html

```shell
cd Service
mvn spring-boot:run
browser http://localhost:8080/examples/restrictedAccessThymeleafExample
```

* StandardExpressionExecutionContext
