package com.assetdata.taxes.bean;

import java.math.BigDecimal;

import com.assetdata.taxes.constant.Constants;
import com.assetdata.taxes.utility.Utility;
import com.assetddata.taxes.exception.AmmountException;

public class Item implements TaxedItem {

	public Item() {
		
	}
	public Item(int itemsNumber, BigDecimal price, String name, boolean imported) throws AmmountException{
		
		this.itemsNumber = itemsNumber;
		this.price = price;
		if(price==null || price.compareTo(BigDecimal.ZERO)==-1)
			throw new AmmountException("Valore non valido");
		this.name = name;
		this.imported = imported;
		this.taxes = this.generateTaxes();
	}
	
	protected BigDecimal taxes;
	protected int itemsNumber;
	protected BigDecimal price;
	protected String name;
	protected boolean imported;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getTaxes() {
		return taxes;
	}
	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}
	public int getItemsNumber() {
		return itemsNumber;
	}
	public void setItemsNumber(int itemsNumber) {
		this.itemsNumber = itemsNumber;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal generateTaxes() {
		BigDecimal totalTaxes = new BigDecimal(Constants.NO_TAXES);
		if(imported)
			totalTaxes = totalTaxes.add(new BigDecimal(Constants.IMPORT_TAXES));
		return Utility.roundUp(this.price.multiply(totalTaxes));
	}
	
	
}
