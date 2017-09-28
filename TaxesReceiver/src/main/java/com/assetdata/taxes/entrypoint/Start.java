package com.assetdata.taxes.entrypoint;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.assetdata.taxes.bean.Item;
import com.assetdata.taxes.bean.SpecialItem;
import com.assetdata.taxes.constant.Constants;
import com.assetdata.taxes.utility.BillCounter;
import com.assetddata.taxes.exception.AmmountException;
import com.assetddata.taxes.exception.ReceiveException;

public class Start {

	public static void main(String[] args) {
		
		/*
		 *  - Con SpecialItem si identificano quei prodotti che tengono conto delle imposte di base
		 *  - Con Item invece quei prodotti (libri, cibo, e prodotti medicinali) che sono esentati dalle imposte di base
		 *  - Le tasse di importazione vengono calcolate qualora il Prodotto  abbia valorizzato la proprietà imported a 'true'
		 */
		
		try {
			System.out.println("\nOUTPUT 1");
			Item book = new Item(1, new BigDecimal("12.49"), "Book", Constants.NOT_IMPORTED);
			Item musicCd = new SpecialItem(1, new BigDecimal("14.99"), "Music CD", Constants.NOT_IMPORTED);
			Item chocolateBar = new Item(1, new BigDecimal("0.85"), "Chocolate Bar", Constants.NOT_IMPORTED);
			
			List<Item> items = new LinkedList<>();
			items.add(book);
			items.add(musicCd);
			items.add(chocolateBar);
			BillCounter.generateReceive(items);
			
			System.out.println("\nOUTPUT 2");
			
			Item importedBoxOfChocolates = new Item(1, new BigDecimal("10.00"), "Imported box of chocolates", Constants.IMPORTED);
			Item importedBoxOfPerfume = new SpecialItem(1, new BigDecimal("47.50"), "Imported Box of Perfume", Constants.IMPORTED);
			
			items = new LinkedList<>();
			items.add(importedBoxOfChocolates);
			items.add(importedBoxOfPerfume);
			BillCounter.generateReceive(items);
			
			
	
			System.out.println("\nOUTPUT 3");
			
			Item importedBottleOfPerfume = new SpecialItem(1, new BigDecimal("27.99"), "Imported bottle of Perfume", Constants.IMPORTED);
			Item  bottleOfPerfume = new SpecialItem(1, new BigDecimal("18.99"), "Imported box of chocolates", Constants.NOT_IMPORTED);
			Item packetHeadachePills = new Item(1, new BigDecimal("9.75"), "Packet of Headache pills", Constants.NOT_IMPORTED);
			Item boxImportedChocolate = new Item(1, new BigDecimal("11.25"), "Box of imported chocolate", Constants.IMPORTED);
			
			items = new LinkedList<>();
			items.add(importedBottleOfPerfume);
			items.add(bottleOfPerfume);
			items.add(packetHeadachePills);
			items.add(boxImportedChocolate);
			BillCounter.generateReceive(items);
		
		}catch(ReceiveException | AmmountException e) {
			e.printStackTrace();
		}
	}

}
