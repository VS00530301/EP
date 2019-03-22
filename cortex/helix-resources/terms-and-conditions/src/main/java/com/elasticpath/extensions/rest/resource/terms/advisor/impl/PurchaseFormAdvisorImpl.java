package com.elasticpath.extensions.rest.resource.terms.advisor.impl;

import com.elasticpath.extensions.rest.resource.integration.epcommerce.repository.TermsValidationService;
import com.elasticpath.rest.advise.LinkedMessage;
import com.elasticpath.rest.definition.purchases.CreatePurchaseFormIdentifier;
import com.elasticpath.rest.definition.terms.PurchaseFormTermsAdvisor;
import com.elasticpath.rest.definition.terms.TermsAndConditionsFormIdentifier;
import com.elasticpath.rest.helix.data.annotation.RequestIdentifier;
import com.elasticpath.rest.helix.data.annotation.ResourceService;
import io.reactivex.Observable;

import javax.inject.Inject;

public class PurchaseFormAdvisorImpl implements PurchaseFormTermsAdvisor.LinkedFormAdvisor {

    @Inject
    @RequestIdentifier
    private CreatePurchaseFormIdentifier createPurchaseFormIdentifier;

    @Inject
    @ResourceService
    private TermsValidationService validateTermsAccepted;

    @Override
    public Observable<LinkedMessage<TermsAndConditionsFormIdentifier>> onLinkedAdvise() {
        return validateTermsAccepted.validateTermsAccepted(createPurchaseFormIdentifier.getOrder());
    }
}
