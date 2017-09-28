package com.assetdata.taxes.utility;

import java.math.BigDecimal;
import java.util.List;

import com.assetdata.taxes.bean.Item;
import com.assetdata.taxes.bean.Receive;
import com.assetddata.taxes.exception.ReceiveException;

public class BillCounter {

	
	public static Receive generateReceive(List<Item> items) throws ReceiveException {
		Receive recipe = new Receive();
		recipe.setItemPriceList(items);
		if(items==null || items.isEmpty())
			throw new ReceiveException("La lista non può essere vuota");
		BigDecimal totalTaxes = new BigDecimal(0);
		for(Item i : items) {
			totalTaxes = totalTaxes.add(i.getTaxes());
		}
		recipe.setTaxes(Utility.roundUp(totalTaxes));
		System.out.println(recipe.print());
		return recipe;
	}
	
	

}
