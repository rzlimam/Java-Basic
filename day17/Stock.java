package day17;

public class Stock {
	
	private int idItem;
	private int stock;
	private String desc;
	private String tgl;
	
	private Item item;
	
	public Stock() {
		
	}

	public Stock(int idItem, int stock, String desc, String tgl) {
		super();
		this.idItem = idItem;
		this.stock = stock;
		this.desc = desc;
		this.tgl = tgl;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTgl() {
		return tgl;
	}

	public void setTgl(String tgl) {
		this.tgl = tgl;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	
	

}
