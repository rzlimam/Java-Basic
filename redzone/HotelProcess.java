package redzone;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelProcess {
	
//	static ArrayList<LevelKamar> kelas = new ArrayList<LevelKamar>();
	static Scanner sc = new Scanner(System.in);

	
	public ArrayList<Kamar> insertKamar() {
		
		ArrayList<LevelKamar> kelas = new ArrayList<LevelKamar>();
		
		LevelKamar vip = new LevelKamar("VIP", 50000);
		LevelKamar business = new LevelKamar("Business", 30000);
		LevelKamar standar = new LevelKamar("Standar", 10000);
		
		kelas.add(vip);
		kelas.add(business);
		kelas.add(standar);
		
		ArrayList<Kamar> kamar = new ArrayList<Kamar>();
		
		Kamar v1 = new Kamar("V01", vip, true);
		Kamar v2 = new Kamar("V02", vip, true);
		Kamar b1 = new Kamar("B01", business, true);
		Kamar b2 = new Kamar("B02", business, true);
		Kamar s1 = new Kamar("S01", standar, true);
		Kamar s2 = new Kamar("S02", standar, true);
		Kamar s3 = new Kamar("S03", standar, true);
		
		kamar.add(v1);
		kamar.add(v2);
		kamar.add(b1);
		kamar.add(b2);
		kamar.add(s1);
		kamar.add(s2);
		kamar.add(s3);
		
		
		return kamar;
	
	}
	
	
	public void displayKamar(ArrayList<Kamar> rooms) {
		for(Kamar kamar : rooms) {
			System.out.println("Nomor Kamar : "+kamar.getNomorKamar());
			System.out.println("Level Kamar : "+kamar.getLevelkamar().getLevelKamar());
			System.out.println("Harga Kamar : "+kamar.getLevelkamar().getHarga());
			if(kamar.isReady() == true) 
				System.out.println("AVAILABLE");
			else
				System.out.println("BOOKED");
			System.out.println();
				
		}
	}
	
	public boolean cekNama(String nama, ArrayList<Customer> customers) {
		for(Customer cust : customers) {
			if(cust.getNama().equalsIgnoreCase(nama)) {
				return true;
			}
		}
		System.out.println("Anda belum memesan kamar");
		return false;
	}
	
	public ArrayList<Customer> pesanKamar(String nama, String nomor, ArrayList<Kamar> rooms, ArrayList<Customer> customers) {
		for(Kamar kl : rooms) {
			if(kl.getNomorKamar().equalsIgnoreCase(nomor)) {
				if(kl.isReady()) {
					kl.setReady(false);
					System.out.print("Tanggal check in (dd-mm-yyyy) : ");
					String checkIn = sc.nextLine();
					System.out.print("Tanggal check out (dd-mm-yyyy) : ");
					String checkOut = sc.nextLine();
					System.out.print("Lama menginap (hari) : ");
					int lama = sc.nextInt();
					System.out.print("Sarapan y/n : ");
					sc.nextLine();
					String sarapan = sc.nextLine();
					boolean makan = true;
					if(sarapan.equalsIgnoreCase("y")) {
						makan = true;
					} else {
						makan = false;
					}
					Reservasi reserv = new Reservasi(kl, checkIn, checkOut, lama, makan);
					Customer cust = new Customer(nama, reserv);
					customers.add(cust);
					return customers;
					} else {
						System.out.println("Kamar tidak tersedia");
					}
				} 
			}
		return null;
	}
	
	public void displayCustomer(ArrayList<Customer> customers) {
		System.out.println("Daftar customers");
		int counter = 1;
		for(Customer cust : customers) {
			System.out.println(counter+". "+cust.getNama());
			counter++;
		}
	}
	
	public void displayBill(String nama, ArrayList<Customer> customers) {
		for(Customer cust : customers) {
			if(cust.getNama().equalsIgnoreCase(nama)) {
				System.out.println("Nama Customer : "+cust.getNama());
				System.out.println("Nomor Kamar : "+cust.getReservasi().getKamar().getNomorKamar());
				System.out.println("Kelas Kamar : "+cust.getReservasi().getKamar().getLevelkamar().getLevelKamar());
				System.out.println("Tgl check in : "+cust.getReservasi().getCheckIn());
				System.out.println("Tgl check out : "+cust.getReservasi().getCheckOut());
				System.out.println("Lama menginap : "+cust.getReservasi().getLama());
				System.out.println("Harga Kamar/hari : "+cust.getReservasi().getKamar().getLevelkamar().getHarga());
				int harga = cust.getReservasi().getKamar().getLevelkamar().getHarga() * cust.getReservasi().getLama();
				System.out.println("Total harga Kamar : "+harga);
				int breakfast;
				if(cust.getReservasi().isSarapan()) {
					System.out.println("Harga Sarapan : 5000");
					breakfast = cust.getReservasi().getLama() * 5000;
				} else {
					System.out.println("Tidak memesan sarapan");
					breakfast = 0;
				}
				int total = harga + breakfast;
				System.out.println("Total bayar : "+total);
			}
		}
	}

}
