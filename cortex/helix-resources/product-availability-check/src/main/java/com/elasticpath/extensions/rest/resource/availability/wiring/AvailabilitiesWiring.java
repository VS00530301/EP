package com.elasticpath.extensions.rest.resource.availability.wiring;

import com.elasticpath.extensions.rest.resource.availability.permission.AvailableParameterStrategy;
import com.elasticpath.rest.authorization.parameter.PermissionParameterStrategy;
import com.elasticpath.rest.definition.available.AvailabilityForItemIdentifier;
import com.elasticpath.rest.definition.available.AvailabilityForItemResource;
import com.elasticpath.rest.helix.api.AbstractHelixModule;
import com.google.inject.multibindings.MapBinder;
import org.apache.log4j.Logger;

import javax.inject.Named;


@Named
public class AvailabilitiesWiring extends AbstractHelixModule {

    private static final Logger LOG = Logger.getLogger(AvailabilitiesWiring.class);
    /**
     * Peaberry plumbing class used for importing required services and registering additional parameter resolvers.
     */
    @Override
    protected String resourceName() {
        return AvailabilityForItemResource.FAMILY;
    }

    @Override
    public void registerParameterResolvers(final MapBinder<String, PermissionParameterStrategy> resolvers) {
        LOG.info("AvailabilitiesWiring.registerParameterResolvers()");
        super.registerParameterResolvers(resolvers);
        resolvers.addBinding(AvailabilityForItemIdentifier.URI_TEMPLATE).toInstance(new AvailableParameterStrategy());
    }
}
