package com.elasticpath.extensions.rest.resource.availability.relationship;

import com.elasticpath.rest.definition.available.AvailabilityForItemIdentifier;
import com.elasticpath.rest.definition.available.ItemToAvailabilityRelationship;
import com.elasticpath.rest.definition.items.ItemIdentifier;
import com.elasticpath.rest.helix.data.annotation.RequestIdentifier;
import io.reactivex.Observable;
import org.apache.log4j.Logger;

import javax.inject.Inject;

public class ItemToAvailabilityRelationshipImpl implements ItemToAvailabilityRelationship.LinkTo {
    private static final Logger LOG = Logger.getLogger(ItemToAvailabilityRelationshipImpl.class);

    private  final ItemIdentifier itemIdentifier;
    /**
     * Constructor.
     *
     * @param itemIdentifier itemIdentifier
     */
    @Inject
    public ItemToAvailabilityRelationshipImpl(@RequestIdentifier final ItemIdentifier itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    @Override
    public Observable<AvailabilityForItemIdentifier> onLinkTo() {
        LOG.info("ItemToAvailabilityRelationshipImpl.onLinkTo()");
        return Observable.just(AvailabilityForItemIdentifier.builder()
                .withItem(itemIdentifier)
                .build());
    }
}
