package de.synyx.cl.learning.spring.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class SvgConfig {

    @Bean
    public SpringTemplateEngine textTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(svgTemplateResolver());
        return templateEngine;
    }

    private ITemplateResolver svgTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".svg");
        templateResolver.setTemplateMode(TemplateMode.XML);
        templateResolver.setCacheable(false);
        return templateResolver;
    }
}
