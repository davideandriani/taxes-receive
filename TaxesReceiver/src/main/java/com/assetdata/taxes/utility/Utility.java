package com.assetdata.taxes.utility;

import java.math.BigDecimal;

import com.assetdata.taxes.constant.Constants;

public class Utility {

	public static BigDecimal roundUp(BigDecimal totalTaxes) {
		BigDecimal result = totalTaxes.divide(Constants.ROUND_UP_AMOUNT);
		BigDecimal a = result.setScale(0,BigDecimal.ROUND_UP);
		result = a.multiply(Constants.ROUND_UP_AMOUNT);
		return result;
	}
}
