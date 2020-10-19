package redzone;

public class Reservasi {
	
	private Kamar kamar;
	private String checkIn;
	private String checkOut;
	private int lama;
	private boolean sarapan;
	
	public Reservasi(Kamar kamar, String checkIn, String checkOut, int lama, boolean sarapan) {
		super();
		this.kamar = kamar;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.lama = lama;
		this.sarapan = sarapan;
	}

	public Kamar getKamar() {
		return kamar;
	}

	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getLama() {
		return lama;
	}

	public void setLama(int lama) {
		this.lama = lama;
	}

	public boolean isSarapan() {
		return sarapan;
	}

	public void setSarapan(boolean sarapan) {
		this.sarapan = sarapan;
	}

	
	
	

}
