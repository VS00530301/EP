package com.elasticpath.extensions.rest.resource.availability.permission;

import com.elasticpath.rest.authorization.parameter.AbstractCollectionValueStrategy;
import com.elasticpath.rest.definition.available.AvailabilityForItemIdentifier;
import com.elasticpath.rest.id.transform.IdentifierTransformerProvider;
import com.elasticpath.rest.id.type.StringIdentifier;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

public class AvailableParameterStrategy extends AbstractCollectionValueStrategy {
    private static final Logger LOG = Logger.getLogger("AvailableParameterStrategy");

    @Inject
    private IdentifierTransformerProvider identifierTransformerProvider;

    protected Collection<String> getParameterValues(final PrincipalCollection principals) {
        LOG.info("AvailableParameterStrategy");
        return Collections.singletonList(identifierTransformerProvider.forUriPart(AvailabilityForItemIdentifier.URI_TEMPLATE).identifierToUri(StringIdentifier.of("available")));
    }
}
