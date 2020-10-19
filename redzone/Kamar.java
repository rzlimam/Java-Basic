package redzone;

public class Kamar {
	
	private String nomorKamar;
	private LevelKamar levelkamar;
	private boolean isReady;
	
	public Kamar(String nomorKamar, LevelKamar levelkamar, boolean isReady) {
		super();
		this.nomorKamar = nomorKamar;
		this.levelkamar = levelkamar;
		this.isReady = isReady;
	}
	
	public Kamar(String nomorKamar) {
		super();
		this.nomorKamar = nomorKamar;
	}

	public String getNomorKamar() {
		return nomorKamar;
	}

	public void setNomorKamar(String nomorKamar) {
		this.nomorKamar = nomorKamar;
	}

	public LevelKamar getLevelkamar() {
		return levelkamar;
	}

	public void setLevelkamar(LevelKamar levelkamar) {
		this.levelkamar = levelkamar;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	
	
	
	

}
