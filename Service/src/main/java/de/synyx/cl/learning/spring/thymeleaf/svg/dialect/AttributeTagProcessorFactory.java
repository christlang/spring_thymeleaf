package de.synyx.cl.learning.spring.thymeleaf.svg.dialect;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;

public class AttributeTagProcessorFactory extends AbstractAttributeTagProcessor {

    public static AbstractAttributeTagProcessor create(String dialectPrefix, String attributeName) {
        return new AttributeTagProcessorFactory(dialectPrefix, attributeName);
    }

    private final String attributeNameToHandle;
    private static final int PRECEDENCE = 10000;


    public AttributeTagProcessorFactory(final String dialectPrefix, String attributeName) {
        super(
                TemplateMode.HTML, // This processor will apply only to HTML mode
                dialectPrefix,     // Prefix to be applied to name for matching
                null,              // No tag name: match any tag name
                false,             // No prefix to be applied to tag name
                attributeName,     // Name of the attribute that will be matched
                true,              // Apply dialect prefix to attribute name
                PRECEDENCE,        // Precedence (inside dialect's precedence)
                true);             // Remove the matched attribute afterwards

        this.attributeNameToHandle = attributeName;
    }


    protected void doProcess(
            final ITemplateContext context, final IProcessableElementTag tag,
            final AttributeName attributeName, final String attributeValue,
            final IElementTagStructureHandler structureHandler) {

        final IEngineConfiguration configuration = context.getConfiguration();

        final IStandardExpressionParser parser =
                StandardExpressions.getExpressionParser(configuration);

        final IStandardExpression expression = parser.parseExpression(context, attributeValue);

        final String output = (String) expression.execute(context);

        structureHandler.setAttribute(attributeNameToHandle, output);
    }
}
