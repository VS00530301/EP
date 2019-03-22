package com.elasticpath.extensions.rest.resource.terms.permission;

import com.elasticpath.rest.authorization.parameter.AbstractCollectionValueStrategy;
import com.elasticpath.rest.definition.terms.TermsAndConditionsFormIdentifier;
import com.elasticpath.rest.id.Identifier;
import com.elasticpath.rest.id.transform.IdentifierTransformer;
import com.elasticpath.rest.id.transform.IdentifierTransformerProvider;
import com.elasticpath.rest.id.type.StringIdentifier;
import com.elasticpath.rest.identity.util.PrincipalsUtil;
import com.elasticpath.rest.resource.integration.epcommerce.repository.cartorder.CartOrderRepository;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;
import java.util.Collection;

public class TermsIdParameterStrategy extends AbstractCollectionValueStrategy {

    @Inject
    private CartOrderRepository cartOrderRepository;

    @Inject
    private IdentifierTransformerProvider identifierTransformerProvider;



    protected Collection<String> getParameterValues(final PrincipalCollection principals ) {

        String scope = PrincipalsUtil.getScope(principals);
        String userId = PrincipalsUtil.getUserIdentifier(principals);
        IdentifierTransformer<Identifier> transformer = identifierTransformerProvider.forUriPart(TermsAndConditionsFormIdentifier.TERMS_ID);

        return cartOrderRepository.findCartOrderGuidsByCustomerAsObservable(scope, userId)
                .map(termsId -> transformer.identifierToUri(StringIdentifier.of(termsId)))
                .toList()
                .blockingGet();

    }
}
