package day17;

	public class Price {
	
	private int idPrice;
	private int idItem;
	private int price;
	private String tglStart;
	private String tglEnd;
	
	
	public Price() {
		
	}

	public Price(int idPrice, int idItem, int price, String tglStart, String tglEnd) {
		super();
		this.idPrice = idPrice;
		this.idItem = idItem;
		this.price = price;
		this.tglStart = tglStart;
		this.tglEnd = tglEnd;
	}
	
	public Price(int idItem, int price, String tglStart) {
		super();
		this.idItem = idItem;
		this.price = price;
		this.tglStart = tglStart;
	}

	public int getIdPrice() {
		return idPrice;
	}

	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTglStart() {
		return tglStart;
	}

	public void setTglStart(String tglStart) {
		this.tglStart = tglStart;
	}

	public String getTglEnd() {
		return tglEnd;
	}

	public void setTglEnd(String tglEnd) {
		this.tglEnd = tglEnd;
	}

	
	
	
	

}
