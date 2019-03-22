package com.elasticpath.extensions.domain.productavailabilitycheck.impl;

import com.elasticpath.extensions.domain.productavailabilitycheck.ProductAvailabilityCheck;
import com.elasticpath.extensions.domain.termsandconditions.impl.TermsAndConditionsFlagImpl;
import com.elasticpath.persistence.api.AbstractEntityImpl;
import org.apache.openjpa.persistence.DataCache;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = TermsAndConditionsFlagImpl.TABLE_NAME)
@DataCache(enabled = true)
public class ProductAvailabilityCheckImpl extends AbstractEntityImpl implements ProductAvailabilityCheck {

    /** Serial version id. */
    private static final long serialVersionUID = 5000000001L;

    /** Database Table. */
    public static final String TABLE_NAME = "TPRODUCTAVAILABILITYCHECK";
    private String zipCode;
    private long uidpk;
    private String guid;


    @Basic
    @Column(name = "ZIPCODE")
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    @Id
    @Column(name = "UIDPK")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = TABLE_NAME)
    @TableGenerator(name = TABLE_NAME, table = "JPA_GENERATED_KEYS", pkColumnName = "ID", valueColumnName = "LAST_VALUE", pkColumnValue = TABLE_NAME)
    public long getUidPk() {
        return uidpk;
    }

    @Override
    public void setUidPk(final long uidPk) {
        this.uidpk = uidPk;
    }

    @Basic
    @Column(name = "GUID")
    public String getGuid() {
        return guid;
    }

    @Override
    public void setGuid(final String guid) {
        this.guid = guid;
    }
}
