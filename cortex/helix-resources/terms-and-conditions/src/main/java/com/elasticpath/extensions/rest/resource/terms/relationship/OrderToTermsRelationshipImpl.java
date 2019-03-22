package com.elasticpath.extensions.rest.resource.terms.relationship;

import com.elasticpath.rest.definition.orders.OrderIdentifier;
import com.elasticpath.rest.definition.terms.OrderToTermsRelationship;
import com.elasticpath.rest.definition.terms.TermsAndConditionsFormIdentifier;
import com.elasticpath.rest.helix.data.annotation.RequestIdentifier;
import io.reactivex.Observable;
import org.apache.log4j.Logger;

import javax.inject.Inject;

public class OrderToTermsRelationshipImpl implements OrderToTermsRelationship.LinkTo {

    private static final Logger LOG = Logger.getLogger(OrderToTermsRelationshipImpl.class);
    @Inject
    @RequestIdentifier
    private OrderIdentifier orderIdentifier;

    @Override
    public Observable<TermsAndConditionsFormIdentifier> onLinkTo() {
        LOG.info("Linked message order Id"+orderIdentifier.getOrderId().getValue());
        return Observable.just(TermsAndConditionsFormIdentifier.builder()
        .withScope(orderIdentifier.getScope())
        .withTermsId(orderIdentifier.getOrderId())
        .build());
    }
}
