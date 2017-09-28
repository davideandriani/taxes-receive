package com.assetdata.taxes.constant;

import java.math.BigDecimal;

public interface Constants {

	
	public static final double BASIC_SALE_TAXES = 0.1;
	public static final double IMPORT_TAXES = 0.05;
	public static final double NO_TAXES = 0.00;
	
	public static final BigDecimal ROUND_UP_AMOUNT = new BigDecimal(0.05);
	
	public static final boolean IMPORTED = true;
	public static final boolean NOT_IMPORTED = false;
}
