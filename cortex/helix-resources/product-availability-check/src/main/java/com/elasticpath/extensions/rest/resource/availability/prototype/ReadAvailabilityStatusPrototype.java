package com.elasticpath.extensions.rest.resource.availability.prototype;

import com.elasticpath.rest.definition.available.AvailabilityEntity;
import com.elasticpath.rest.definition.available.AvailabilityStatusIdentifier;
import com.elasticpath.rest.definition.available.AvailabilityStatusResource;
import com.elasticpath.rest.helix.data.annotation.RequestIdentifier;
import io.reactivex.Single;
import org.apache.log4j.Logger;

import javax.inject.Inject;

    public class ReadAvailabilityStatusPrototype implements AvailabilityStatusResource.Read {


    private static final Logger LOG = Logger.getLogger(ReadAvailabilityStatusPrototype.class);

    private final AvailabilityStatusIdentifier availabilityStatusIdentifier;

    @Inject
    public ReadAvailabilityStatusPrototype(@RequestIdentifier final AvailabilityStatusIdentifier availabilityStatusIdentifier) {
        this.availabilityStatusIdentifier = availabilityStatusIdentifier;


    }

    @Override
    public Single<AvailabilityEntity> onRead() {
        LOG.info("test ----- ReadAvailabilityStatusPrototype");
        LOG.info(availabilityStatusIdentifier);

        return Single.just(AvailabilityEntity.builder()
                .withStatus("available")
                .withZipcode("123456").build());
    }
}
