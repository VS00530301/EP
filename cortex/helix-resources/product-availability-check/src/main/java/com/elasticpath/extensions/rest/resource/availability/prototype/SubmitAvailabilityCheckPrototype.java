package com.elasticpath.extensions.rest.resource.availability.prototype;

import com.elasticpath.rest.definition.available.AvailabilityForItemIdentifier;
import com.elasticpath.rest.definition.available.AvailabilityForItemResource;
import com.elasticpath.rest.definition.available.AvailabilityStatusIdentifier;
import com.elasticpath.rest.form.SubmitResult;
import com.elasticpath.rest.helix.data.annotation.RequestIdentifier;
import io.reactivex.Single;
import org.apache.log4j.Logger;

import javax.inject.Inject;

public class SubmitAvailabilityCheckPrototype implements AvailabilityForItemResource.SubmitWithResult {
    private static final Logger LOG = Logger.getLogger(SubmitAvailabilityCheckPrototype.class);

    private final AvailabilityForItemIdentifier availabilityForItemIdentifier;


    @Inject
    public SubmitAvailabilityCheckPrototype(@RequestIdentifier final AvailabilityForItemIdentifier availabilityForItemIdentifier) {
        this.availabilityForItemIdentifier = availabilityForItemIdentifier;

    }

    @Override
    public Single<SubmitResult<AvailabilityStatusIdentifier>> onSubmitWithResult() {
        LOG.info("----------------Parent Constrscor AvailabilityStatusIdentifier----------------");
        /* LOG.info(availabilityEntity.getZipcode());*/
        return Single.just(SubmitResult.<AvailabilityStatusIdentifier>builder()
                .withIdentifier(AvailabilityStatusIdentifier
                        .builder()
                        .withItem(availabilityForItemIdentifier.getItem())
                        .build())
                .build());
    }
}
