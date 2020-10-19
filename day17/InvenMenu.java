package day17;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class InvenMenu {
	
	static Scanner sc = new Scanner(System.in);
	
	public void menu() {
		
		ItemDao item = new ItemDao();
		CategoryDao cat = new CategoryDao();
		SupplierDao sup = new SupplierDao();
		SupplierItemDao supitem = new SupplierItemDao();
		
		
		int pilihan;
		
		do {
		System.out.println("===Menu Inventory===");
		System.out.println("1.List Item");
		System.out.println("2.List Category");
		System.out.println("3.List Suppliers");
		System.out.println("4.Supllier Item");
		
		System.out.print("Masukan pilihan : ");
		pilihan = sc.nextInt();
		switch(pilihan) {
		case 1:
			System.out.println("\n===List Item===");
			System.out.println();
			System.out.println("1. Display Item");
			System.out.println("2. Add Item");
			System.out.println("3. Edit Item");
			System.out.println("4. Delete Item");
			System.out.println("5. Add Price");
			System.out.println("6. Insert Stock");
			System.out.println("7. Report stock");
			System.out.print("Masukan pilihan : ");
			pilihan = sc.nextInt();
			switch(pilihan) {
			case 1:
				item.displayItem();
				break;
			case 2:
				System.out.println("Insert Item");
				System.out.print("Kode Item : ");
				sc.nextLine();
				String kodeItem = sc.nextLine();
				System.out.print("Nama item : ");
				String namaItem = sc.nextLine();
				System.out.print("Kode Category : ");
				String kodeCat = sc.nextLine();
				
				if(cat.getCategory(kodeCat) != null) {
					int idCat = cat.getCategory(kodeCat).getIdCategory();
					System.out.println(idCat);
					System.out.print("Active state : ");
					int as = sc.nextInt();
					String active;
					if(as == 1) 
						active = "true";
					else
						active = "false";
					
					Item newItem = new Item(kodeItem, namaItem, idCat, active);
					item.insertItem(newItem);
					
					int idItem = item.getItem(kodeItem).getIdItem();
					
					System.out.print("Harga : ");
					int harga = sc.nextInt();
					System.out.print("Tgl start : ");
					sc.nextLine();
					String tglStart = sc.nextLine();
					Price itemPrice = new Price(idItem, harga, tglStart);
					item.insertPrice(itemPrice);
					
					
					System.out.print("Stock : ");
					int stock = sc.nextInt();
					String desc = "SA";
					Date now = new Date();
					String tgl = now.toString();
					Stock itemStock = new Stock(idItem, stock, desc, tgl);
					item.insertStock(itemStock);
					
				}else {
					System.out.println("Kategori tidak ada");
				}			
				break;
			case 3:
				System.out.println("Edit item");
				System.out.print("Kode Item : ");
				sc.nextLine();
				kodeItem = sc.nextLine();
				if(item.getItem(kodeItem) != null) {
					int idItem = item.getItem(kodeItem).getIdItem();
					System.out.print("Nama item : ");
					namaItem = sc.nextLine();
					int idCat = item.getItem(kodeItem).getIdCategory();
					System.out.print("Active state : ");
					int as = sc.nextInt();
					String active;
					if(as == 1) 
						active = "true";
					else
						active = "false";
					
					Item editItem = new Item(idItem, kodeItem, namaItem, idCat, active);
					
					item.updateItem(editItem);
				} else
					System.out.println("Kode item tidak ditemukan");
				break;
			case 4:
				System.out.println("Hapus item");
				System.out.print("Kode Item : ");
				sc.nextLine();
				kodeItem = sc.nextLine();
				if(item.getItem(kodeItem) != null) {
					item.deleteItem(kodeItem);
				} else
					System.out.println("Kode item tidak ada");
				break;
			case 5:
				System.out.println("Add Price");
				System.out.print("Kode Item : ");
				sc.nextLine();
				kodeItem = sc.nextLine();
				if(item.getItem(kodeItem) != null) {
					int idItem = item.getItem(kodeItem).getIdItem();
					if(item.getPrice(idItem) != null) {
						int idPrice = item.getPrice(idItem).getIdPrice();
						int oldPrice = item.getPrice(idItem).getPrice();
						String tglStart = item.getPrice(idItem).getTglStart();
						System.out.print("Price : ");
						int price = sc.nextInt();
						System.out.print("Tgl start : ");
						sc.nextLine();
						String newTgl = sc.nextLine();
						
						Price editPrice = new Price(idPrice, idItem, oldPrice, tglStart, newTgl);
						item.updatePrice(editPrice);
						
						Price newPrice =  new Price(idItem, price, newTgl);
						item.insertPrice(newPrice);
					} else {
						System.out.print("Price : ");
						int price = sc.nextInt();
						System.out.print("Tgl start : ");
						sc.nextLine();
						String newTgl = sc.nextLine();
						
						Price newPrice =  new Price(idItem, price, newTgl);
						item.insertPrice(newPrice);
					}
				}else
					System.out.println("Kode item tidak ada");
				break;
//			case 6:
//				System.out.println("Edit Price");
//				System.out.print("Kode Item : ");
//				sc.nextLine();
//				kodeItem = sc.nextLine();
//				if(item.getItem(kodeItem) != null) {
//					int idItem = item.getItem(kodeItem).getIdItem();
//					if(item.getPrice(idItem) != null) {
//						int idPrice = item.getPrice(idItem).getIdPrice();
//						namaItem = item.getItem(kodeItem).getNamaItem();
//						System.out.println("Nama item : "+namaItem);
//						int oldPrice = item.getPrice(idItem).getPrice();
//						System.out.println("Price : "+oldPrice);
//						String tglStart = item.getPrice(idItem).getTglStart();
//						System.out.println("Tgl start : "+tglStart);
//						System.out.print("Tgl end : ");
//						sc.nextLine();
//						String tglEnd = sc.nextLine();
//						
//						Price editPrice = new Price(idPrice, idItem, oldPrice, tglStart, tglEnd);
//						item.updatePrice(editPrice);
//					}
//				} else
//					System.out.println("Kode item tidak ada");
//				break;
			case 6:
				System.out.println("Add stock");
				System.out.print("Kode item : ");
				sc.nextLine();
				kodeItem = sc.nextLine();
				if(item.getItem(kodeItem) != null) {
					int idItem = item.getItem(kodeItem).getIdItem();
					System.out.print("Masukan stock : ");
					int stock = sc.nextInt();
					String desc = "PB";
					LocalDateTime now = LocalDateTime.now();
					String tgl = now.toString();
					
					Stock newStock = new Stock(idItem, stock, desc, tgl);
					item.insertStock(newStock);	
				}
				break;
			case 7:
				System.out.println("Display Stock Report");
				item.displayStock();
				System.out.println();
				break;
//			case 7:
//				System.out.println("Edit Stock");
//				System.out.print("Kode Item : ");
//				sc.nextLine();
//				kodeItem = sc.nextLine();
//				if(item.getItem(kodeItem) != null) {
//					System.out.print("Masukan Stock : ");
//					int newStock = sc.nextInt();
//					int idItem = item.getItem(kodeItem).getIdItem();
//					if(item.getStock(idItem) != null) {
//						int oldStock =  item.getStock(idItem).getStock();
//						int stock  = newStock + oldStock;
//						
//						Stock editStock = new Stock(idItem, stock);
//						item.updateStock(editStock);
//					}
//				}else
//					System.out.println("Kode item tidak ada");
			}
			break;
		case 2:
			System.out.println("\n===List Category===");
			System.out.println();
			System.out.println("1. Display Category");
			System.out.println("2. Add Category");
			System.out.println("3. Edit Category");
			System.out.println("4. Delete Category");
			System.out.print("Masukan pilihan : ");
			pilihan = sc.nextInt();
			switch(pilihan) {
			case 1:
				System.out.println("Display Category");
				cat.displayCategory();
				break;
			case 2:
				System.out.println("Add Category");
				System.out.print("Kode Category");
				sc.nextLine();
				String kodeCat = sc.nextLine();
				System.out.print("Nama Category");
				String namaCat = sc.nextLine();
				
				Category newCat = new Category(kodeCat, namaCat);
				cat.insertCategory(newCat);
				System.out.println();
				break;
			case 3:
				System.out.println("Edit Category");
				System.out.print("Kode Category : ");
				sc.nextLine();
				kodeCat = sc.nextLine();
				if(cat.getCategory(kodeCat) != null) {
					int idCat = cat.getCategory(kodeCat).getIdCategory();
					System.out.print("Nama Category : ");
					namaCat = sc.nextLine();
					
					Category editCat = new Category(idCat, kodeCat, namaCat);
					cat.updateCategory(editCat);
				}
				System.out.println();
				break;
			}
			
			break;
		case 3:
			System.out.println("\n===List Supplier===");
			System.out.println();
			System.out.println("1. Display Supplier");
			System.out.println("2. Add Supplier");
			System.out.println("3. Edit Supplier");
			System.out.println("4. Delete Supplier");
			System.out.print("Masukan pilihan : ");
			pilihan = sc.nextInt();
			switch(pilihan) {
			case 1:
				System.out.println("Display Supplier");
				sup.displaySup();
				break;
			case 2:
				System.out.println("Insert Supplier");
				System.out.print("Supplier code : ");
				sc.nextLine();
				String kodeSup = sc.nextLine();
				System.out.print("Supplier name : ");
				String namaSup = sc.nextLine();
				System.out.print("No.Telp : ");
				String noTelp = sc.nextLine();
				System.out.print("Alamat : ");
				String alamat = sc.nextLine();
				
				Supplier newSup = new Supplier(kodeSup, namaSup, noTelp, alamat);
				sup.insertSupplier(newSup);
				break;
			case 3:
				System.out.println("Edit Supplier");
				System.out.print("Supplier code : ");
				sc.nextLine();
				kodeSup = sc.nextLine();
				if(sup.getSup(kodeSup) != null) {
					int idSup = sup.getSup(kodeSup).getIdSupplier();
					System.out.println("Nama supplier : " + sup.getSup(kodeSup).getNamaSupplier());
					namaSup = sup.getSup(kodeSup).getNamaSupplier();
					System.out.print("No Telp : ");
					noTelp = sc.nextLine();
					System.out.print("Alamat : ");
					alamat = sc.nextLine();
					
					Supplier editSup = new Supplier(idSup, kodeSup, namaSup, noTelp, alamat);
					sup.updateSup(editSup);
				} else
					System.out.println("Kode Supplier tidak ada");
				break;
			case 4:
				System.out.println("Hapus Supplier");
				System.out.print("Supplier code : ");
				sc.nextLine();
				kodeSup = sc.nextLine();
				if(sup.getSup(kodeSup) != null) {
					sup.deleteSup(kodeSup);
				} else
					System.out.println("Kode Supplier tidak ada");
				break;
			}
			break;
		case 4:
			System.out.println();
			System.out.println("===Supplier Item===");
			System.out.println("1. Display supplier item");
			System.out.println("2. Insert supplier item");
			System.out.print("Masukan pilihan : ");
			pilihan = sc.nextInt();
			switch(pilihan) {
			case 1:
				supitem.displaySupItem();
				System.out.println();
				break;
			case 2:
				System.out.print("Insert kode supplier : ");
				sc.nextLine();
				String kodeSup = sc.nextLine();
				if(sup.getSup(kodeSup) != null) {
					int idSup = sup.getSup(kodeSup).getIdSupplier();
					System.out.print("Insert kode item : ");
					String kodeItem = sc.nextLine();
					int idItem = item.getItem(kodeItem).getIdItem();
					
					supitem.insertSupItem(idSup, idItem);
				} else {
					System.out.println("Supplier not found");
				}
				
			}
			
		}
	}while(pilihan<8);
	}

}
