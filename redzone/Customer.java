package redzone;

public class Customer {
	
	private String nama;
	private Reservasi reservasi;
	
	
	public Customer(String nama, Reservasi reservasi) {
		super();
		this.nama = nama;
		this.reservasi = reservasi;
	}


	public String getNama() {
		return nama;
	}


	public void setNama(String nama) {
		this.nama = nama;
	}


	public Reservasi getReservasi() {
		return reservasi;
	}


	public void setReservasi(Reservasi reservasi) {
		this.reservasi = reservasi;
	}
	
}
