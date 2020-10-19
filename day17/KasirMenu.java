package day17;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KasirMenu {
	
	static Scanner sc = new Scanner(System.in);
	
	public void menu(User user) {
		
		DetailTransDao dt = new DetailTransDao();
		ItemDao item = new ItemDao();
		EmployeeDao emp = new EmployeeDao();
		
		Map<Integer, Temporary> tempMap = new HashMap<Integer, Temporary>();
		
		
		
		for(Map.Entry<Integer, Temporary> tes : tempMap.entrySet()) {
			System.out.println(tes.getValue().getIdItem());
			System.out.println(tes.getValue().getQty());
		}
		
		int pilihan;
		
		int idEmp = user.getIdEmp();
		
		do {
		System.out.println("===Menu Kasir===");
		System.out.println("1. Input transaksi");
		System.out.println("2. Print transaksi");
		
		System.out.print("Masukan pilihan : ");
		pilihan = sc.nextInt();
		
		switch(pilihan) {
		case 1:
			String input;
			do {
				item.displayItem();
				System.out.println("Input transaksi");
				System.out.print("Kode item : ");
				String kodeItem = sc.next();
				if(item.getItem(kodeItem) != null) {
					int idItem = item.getItem(kodeItem).getIdItem();
					int harga = item.getPrice(idItem).getPrice();
					System.out.println("Stock : "+item.nowStock(idItem));
					System.out.print("Qty : ");
					int qty = sc.nextInt();
					
					if(item.nowStock(idItem) > qty) {
					
//					if(item.getStock(idItem).getStock() >= qty) {
						int subTotal;
						if(dt.findIdItem(idItem).getIdItem() != idItem ) {
							subTotal = harga * qty;
							Temporary newTemp = new Temporary(idEmp, idItem, qty, subTotal);
							dt.insertTemp(newTemp);
						} else {
							int newQty = dt.findIdItem(idItem).getQty() + qty;
							subTotal = harga * newQty;
							Temporary editTemp = new Temporary(idEmp, idItem, newQty, subTotal);
							dt.updateTemp(editTemp);
						}
					} else {
						System.out.println("Stok kurang");
					}
				} else {
					System.out.println("Kode item tidak ada");
				}
				System.out.print("input lagi? (y/n) : ");
				input = sc.next();
			} while(input.equalsIgnoreCase("y"));
			break;
			
		case 2:
			String edit;
			do {
			dt.displayTransaksi(idEmp);
			System.out.print("Ada perubahan? (y/n)");
			edit = sc.next();
			if(edit.equalsIgnoreCase("y")) {
				System.out.println("1. Ganti jumlah");
				System.out.println("2. Cancel item");
				System.out.print("pilih : ");
				int ganti = sc.nextInt();
				switch(ganti) {
				case 1:
					System.out.print("kode item : ");
					String kodeItem = sc.next();
					if(item.getItem(kodeItem) != null) {
						int idItem = item.getItem(kodeItem).getIdItem();
						int idTemp = dt.getIdTemp(idItem).getIdTemp();
						System.out.print("input qty : ");
						int newQty = sc.nextInt();
						int harga = item.getPrice(idItem).getPrice();
						System.out.println(harga);
						int newSubTotal = harga * newQty;
						System.out.println(newSubTotal);
						Temporary editQty = new Temporary(idTemp, idEmp, idItem, newQty, newSubTotal); 
						dt.updateTemp(editQty);
					}else {
						System.out.println("kode item not found");
						System.out.println();
					}
					break;
				case 2:
					System.out.println("Cancel item");
					System.out.println("kode item : ");
					kodeItem = sc.next();
					if(item.getItem(kodeItem) != null) {
						int idItem = item.getItem(kodeItem).getIdItem();
						int idTemp = dt.getIdTemp(idItem).getIdTemp();
						dt.cancelItem(idTemp);
					} else {
						System.out.println("kode item not found");
						System.out.println();
					}
					break;
				}
				
			} else {
				System.out.print("Proses transaksi? (y/n) : ");
				sc.nextLine();
				String proses = sc.nextLine();
				if(proses.equalsIgnoreCase("Y")) {
					tempMap = dt.getTemporary(idEmp);
					int jmlBayar = dt.getTotalBayar(idEmp);
					System.out.print("Cash : ");
					int cash = sc.nextInt();
					if(cash < jmlBayar) {
						System.out.println("Uang tidak cukup");
					} else {
						int change = cash - jmlBayar;
						System.out.println("Change : "+change);
						String noTrans = dt.getNomorTrans(5);
//						LocalDateTime now = LocalDateTime.now();
//						String tgl = now.toString();
//						Transaction newTrans = new Transaction(noTrans, idEmp, tgl, jmlBayar);
//						dt.insertTrans(newTrans);
//						int idTrans = dt.getIdTrans(noTrans).getIdTrans();
//						for(Map.Entry<Integer, Temporary> myTemp : tempMap.entrySet()) {
////							DetailTrans newDetail = new DetailTrans(idTrans, myTemp.getValue().getIdItem(), myTemp.getValue().getQty());
////							dt.insertDetailTrans(newDetail);
//							int oldStock = item.getStock(myTemp.getValue().getIdItem()).getStock();
//							int newStock = oldStock - myTemp.getValue().getQty();
//							Stock stock = new Stock(myTemp.getValue().getIdItem(), newStock);
//							item.updateStock(stock);
//						}
						dt.saveTransaction(noTrans, idEmp, jmlBayar);
						
						System.out.println();
						System.out.println("---------------------AlfaIndo----------------------");
						System.out.println("Kasir : "+emp.getEmpName(idEmp).getEmpName());
						System.out.println("Tanggal Transaksi : "+dt.getIdTrans(noTrans).getTglTrans());
						dt.displayTransaksi(idEmp);
						
						System.out.println("Cash \t\t: "+cash);
						System.out.println("Change \t\t: "+change);
						System.out.println("-----------Terima kasih telah berbelanja-----------");
						System.out.println();
						dt.deleteTemp();
					}
				}
			}
			}while(edit.equalsIgnoreCase("y"));
			break;
		}
		}while(pilihan<3);
	}

}
