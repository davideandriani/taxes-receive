package com.assetdata.taxes.bean;

import java.math.BigDecimal;

import com.assetdata.taxes.constant.Constants;
import com.assetdata.taxes.utility.Utility;
import com.assetddata.taxes.exception.AmmountException;

public class SpecialItem extends Item {

	public SpecialItem(int itemsNumber, BigDecimal price, String name, boolean imported) throws AmmountException {
		super(itemsNumber, price, name, imported);
	}
	
	@Override
	public BigDecimal generateTaxes() {
		BigDecimal totalTaxes = new BigDecimal(Constants.BASIC_SALE_TAXES);
		if(imported)
			totalTaxes = totalTaxes.add(new BigDecimal(Constants.IMPORT_TAXES));
		return Utility.roundUp(this.price.multiply(totalTaxes));
	}
	
}
