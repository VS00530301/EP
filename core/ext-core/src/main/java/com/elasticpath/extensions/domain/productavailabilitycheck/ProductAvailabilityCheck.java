package com.elasticpath.extensions.domain.productavailabilitycheck;

import com.elasticpath.persistence.api.Entity;

/* interface product availability check */
public interface ProductAvailabilityCheck extends Entity {

    /* return code*/
    String getZipCode();

    /*param code setting */
    void setZipCode(String zipCode);
}
