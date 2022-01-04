package de.synyx.cl.learning.spring.thymeleaf;

import de.synyx.cl.learning.spring.thymeleaf.svg.dialect.SvgDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.IContext;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Service
public class SvgService {

    /**
     * this is the entrypoint-prefix where the {@link #svgTemplateEngine} searches for the
     * given template name. e.g. blabla/helloWorld -> ${PREFIX}/blabla/helloWorld
     */
    private static final String RESOURCES_TEMPLATES_DIR_PREFIX = "templates/";

    private final ISpringTemplateEngine svgTemplateEngine;

    @Autowired
    public SvgService(final MessageSource messageSource) {
        this.svgTemplateEngine = this.svgTemplateEngine(messageSource);
    }

    public String createSvg(final String templateName, final IContext templateContext) {
        return this.svgTemplateEngine.process(templateName, templateContext);
    }

    private ISpringTemplateEngine svgTemplateEngine(final MessageSource messageSource) {
        final SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(this.svgXmlTemplateResolver());
        engine.addDialect(new SvgDialect());
        engine.setMessageSource(messageSource);
        return engine;
    }

    private ITemplateResolver svgXmlTemplateResolver() {
        final ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix(RESOURCES_TEMPLATES_DIR_PREFIX);
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }
}
