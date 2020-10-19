package redzone;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelApp {
	
	public static void main(String[] args) {
		
		HotelProcess hp = new HotelProcess();
		
		ArrayList<Kamar> rooms = new ArrayList<Kamar>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		rooms = hp.insertKamar();
		
		int pilihan =0;
		Scanner sc = new Scanner(System.in);
		
		
		do {
		System.out.println("Aplikasi resevarsi Hotel");
		System.out.println("1. List Kamar");
		System.out.println("2. Pesan Kamar");
		System.out.println("3. Lihat Tagihan");
		
		System.out.print("Masukan pilihan : ");
		pilihan = sc.nextInt();
		
		switch(pilihan) {
		case 1:
			System.out.println("\n===List Kamar===");
			hp.displayKamar(rooms);
			break;
		case 2:
			System.out.println("\n====Pesan Kamar====");
			System.out.print("Masukan nama : ");
			sc.nextLine();
			String nama = sc.nextLine();
			System.out.print("Masukan Nomor kamar : ");
			String nomor = sc.next();
			hp.pesanKamar(nama, nomor, rooms, customers);
			System.out.println();
			break;
		case 3:
			System.out.println("\n===Tagihan===\n");
			hp.displayCustomer(customers);
			System.out.print("Masukan nama : ");
			sc.nextLine();
			nama = sc.nextLine();
			hp.displayBill(nama,customers);
			System.out.println();
			break;
		} 
		}while(pilihan<4);
		
	}

}
