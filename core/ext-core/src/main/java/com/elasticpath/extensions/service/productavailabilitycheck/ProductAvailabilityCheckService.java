package com.elasticpath.extensions.service.productavailabilitycheck;

import com.elasticpath.extensions.domain.productavailabilitycheck.ProductAvailabilityCheck;

public interface ProductAvailabilityCheckService {

    /**
     * @param zipCode zipCode
     * @return ProductAvailabilityCheck
     */
    ProductAvailabilityCheck findByZipCode(String zipCode);
}
