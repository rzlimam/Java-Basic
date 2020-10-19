package day17;

public class Supplier {
	
	private int idSupplier;
	private String kodeSupplier;
	private String namaSupplier;
	private String noTelp;
	private String alamat;
	
	public Supplier() {
		
	}
	
	public Supplier(int idSupplier, String kodeSupplier, String namaSupplier, String noTelp, String alamat) {
		super();
		this.idSupplier = idSupplier;
		this.kodeSupplier = kodeSupplier;
		this.namaSupplier = namaSupplier;
		this.noTelp = noTelp;
		this.alamat = alamat;
	}
	
	public Supplier(String kodeSupplier, String namaSupplier, String noTelp, String alamat) {
		super();
		this.kodeSupplier = kodeSupplier;
		this.namaSupplier = namaSupplier;
		this.noTelp = noTelp;
		this.alamat = alamat;
	}

	public int getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getKodeSupplier() {
		return kodeSupplier;
	}

	public void setKodeSupplier(String kodeSupplier) {
		this.kodeSupplier = kodeSupplier;
	}

	public String getNamaSupplier() {
		return namaSupplier;
	}

	public void setNamaSupplier(String namaSupplier) {
		this.namaSupplier = namaSupplier;
	}

	public String getNoTelp() {
		return noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	
	
	

}
