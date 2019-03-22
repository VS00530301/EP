/*
 * Copyright © 2018 Elastic Path Software Inc. All rights reserved.
 */

package com.elasticpath.extensions.domain.cartorder.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.apache.openjpa.persistence.DataCache;
import org.apache.openjpa.persistence.ElementDependent;
import org.apache.openjpa.persistence.jdbc.ElementForeignKey;
import org.apache.openjpa.persistence.jdbc.ElementJoinColumn;

import com.elasticpath.domain.cartorder.impl.CartOrderImpl;
import com.elasticpath.extensions.domain.cartorder.ExtCartOrder;
import com.elasticpath.extensions.domain.termsandconditions.CartOrderTermsAndConditionsFlag;
import com.elasticpath.extensions.domain.termsandconditions.impl.CartOrderTermsAndConditionsFlagImpl;

/**
 * ExtCartOrderImpl extending CartOrderImpl.
 */
@Entity
@DiscriminatorValue("TERMS")
@DataCache(enabled = false)
public final class ExtCartOrderImpl extends CartOrderImpl implements ExtCartOrder {
	private static final long serialVersionUID = 5000000001L;

	private Map<String, CartOrderTermsAndConditionsFlag> cartOrderTermsAndConditionsFlags =
			new HashMap<String, CartOrderTermsAndConditionsFlag>();

	/**
	 * @return map of string and CartOrderTermsAndConditionsFlag
	 */
	@OneToMany(targetEntity = CartOrderTermsAndConditionsFlagImpl.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@MapKey(name = "code")
	@ElementJoinColumn(name = "CARTORDER_UID", nullable = false)
	@ElementForeignKey(name = "FK_CARTORDERTNCS_CARTORDER")
	@ElementDependent
	@Override
	public Map<String, CartOrderTermsAndConditionsFlag> getCartOrderTermsAndConditionsFlags() {
		return cartOrderTermsAndConditionsFlags;
	}

	/**
	 * @param cartOrderTermsAndConditionsFlags map of string and CartOrderTermsAndConditionsFlag
	 */
	@Override
	public void setCartOrderTermsAndConditionsFlags(final Map<String, CartOrderTermsAndConditionsFlag> cartOrderTermsAndConditionsFlags) {
		this.cartOrderTermsAndConditionsFlags = cartOrderTermsAndConditionsFlags;
	}

	@Override
	public void addCartOrderTermsAndConditionsFlag(final CartOrderTermsAndConditionsFlag cartOrderTermsAndConditionsFlag) {
		this.getCartOrderTermsAndConditionsFlags().put(cartOrderTermsAndConditionsFlag.getCode(), cartOrderTermsAndConditionsFlag);
	}

	@Override
	public void removeCartOrderTermsAndConditionsFlag(final String code) {
		this.getCartOrderTermsAndConditionsFlags().remove(code);
	}
}
