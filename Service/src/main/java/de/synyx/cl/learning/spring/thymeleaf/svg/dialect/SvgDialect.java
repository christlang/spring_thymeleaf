package de.synyx.cl.learning.spring.thymeleaf.svg.dialect;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Needed to replace attributes that have no special name, that usually are addressed by th:attr.
 *
 * th:attr got some restrictions on thymeleaf 3.0.12
 * see https://github.com/thymeleaf/thymeleaf/issues/809
 * new is not allowed
 * static access to code is not allowed
 *
 * this is the workaround inspired by
 * https://www.thymeleaf.org/doc/articles/sayhelloextendingthymeleaf5minutes.html
 * https://www.thymeleaf.org/doc/articles/sayhelloagainextendingthymeleafevenmore5minutes.html
 *
 * will replace
 * svg:x1="${variable}" by x1="variableContent"
 *
 */
public class SvgDialect extends AbstractProcessorDialect {

    public SvgDialect() {
        super(
                "SVG-Dialect",    // Dialect name
                "svg",                  // Dialect prefix (hello:*)
                1000);                  // Dialect precedence
    }


    /*
     * Initialize the dialect's processors.
     *
     * Note the dialect prefix is passed here because, although we set
     * "svg" to be the dialect's prefix at the constructor, that only
     * works as a default, and at engine configuration time the user
     * might have chosen a different prefix to be used.
     */
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        // here we can identify all attributes that should be replaced dynamically
        processors.add(AttributeTagProcessorFactory.create(dialectPrefix, "y1"));
        processors.add(AttributeTagProcessorFactory.create(dialectPrefix, "y2"));
        processors.add(AttributeTagProcessorFactory.create(dialectPrefix, "stroke"));
        return processors;
    }


}