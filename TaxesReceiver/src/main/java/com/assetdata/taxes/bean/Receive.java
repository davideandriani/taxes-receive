package com.assetdata.taxes.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Receive {

	private Map<String, BigDecimal> itemPriceList;
	private BigDecimal taxes;
	private BigDecimal total = new BigDecimal(0);
	
	
	
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Map<String, BigDecimal> getItemPriceList() {
		return itemPriceList;
	}
	public void setItemPriceList(Map<String, BigDecimal> itemPriceList) {
		this.itemPriceList = itemPriceList;
	}
	public void setItemPriceList(List<Item> itemList) {
		
		this.itemPriceList = new LinkedHashMap<>();
		for(Item i: itemList)
			this.itemPriceList.put(i.getName(), i.getPrice().add(i.getTaxes()));
	}
	public BigDecimal getTaxes() {
		return taxes;
	}
	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}
	
	public String print() {
		StringBuffer result = new StringBuffer();
		for(Map.Entry<String, BigDecimal> entry : this.itemPriceList.entrySet()) {
			result.append(entry.getKey()).append(" : ").append(entry.getValue().setScale(2, RoundingMode.HALF_UP)).append("\n");
			total = total.add(entry.getValue());
		
		}
		result.append("\n")
			.append("--------------------------\n")
			.append("Sales Taxes : ").append(this.taxes.setScale(2, RoundingMode.HALF_UP));
		result.append("\n\n").append("TOTAL : ").append(this.total.setScale(2, RoundingMode.HALF_UP));
		return result.toString();
	}
}
