package com.elasticpath.extensions.service.productavailabilitycheck.impl;

import com.elasticpath.extensions.domain.productavailabilitycheck.ProductAvailabilityCheck;
import com.elasticpath.extensions.service.productavailabilitycheck.ProductAvailabilityCheckService;
import com.elasticpath.persistence.api.PersistenceEngine;

import java.util.List;

public class ProductAvailabilityCheckServiceImpl implements ProductAvailabilityCheckService {

    private PersistenceEngine persistenceEngine;

    public PersistenceEngine getPersistenceEngine() {
        return persistenceEngine;
    }

    public void setPersistenceEngine(final PersistenceEngine persistenceEngine) {
        this.persistenceEngine = persistenceEngine;
    }

    @Override
    public ProductAvailabilityCheck findByZipCode(final String zipCode) {
        final List<ProductAvailabilityCheck> productAvailabilityCheck = this.persistenceEngine.retrieveByNamedQuery("FIND_TNC_BY_ZIPCODE",zipCode);

        if(!productAvailabilityCheck.isEmpty()){
            return productAvailabilityCheck.get(0);
        }
        return null;
    }
}
