package com.elasticpath.extensions.rest.resource.availability.prototype;

import com.elasticpath.rest.definition.available.AvailabilityEntity;
import com.elasticpath.rest.definition.available.AvailabilityForItemResource;
import io.reactivex.Single;

import java.util.logging.Logger;

public class ReadProductAvailabilityCheck implements AvailabilityForItemResource.Read {
    private static final Logger LOG = Logger.getLogger("ReadProductAvailabilityCheck");

    @Override
    public Single<AvailabilityEntity> onRead() {
        LOG.info("ReadProductAvailabilityCheck.onRead()");
        return Single.just(AvailabilityEntity
                .builder()
                .withZipcode("")
                .build()
        );
    }
}
