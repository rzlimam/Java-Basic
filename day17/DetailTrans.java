package day17;

public class DetailTrans {
	
	private int idDetailTrans;
	private int idTrans;
	private int idItem;
	private int qty;
	
	private Transaction trans;
	private Item item;
	
	public DetailTrans(int idTrans, int idItem, int qty) {
		super();
		this.idTrans = idTrans;
		this.idItem = idItem;
		this.qty = qty;
	}
	
	public DetailTrans(int idDetailTrans, int idTrans, int idItem, int qty) {
		super();
		this.idDetailTrans = idDetailTrans;
		this.idTrans = idTrans;
		this.idItem = idItem;
		this.qty = qty;
	}

	public int getIdDetailTrans() {
		return idDetailTrans;
	}

	public void setIdDetailTrans(int idDetailTrans) {
		this.idDetailTrans = idDetailTrans;
	}

	public int getIdTrans() {
		return idTrans;
	}

	public void setIdTrans(int idTrans) {
		this.idTrans = idTrans;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Transaction getTrans() {
		return trans;
	}

	public void setTrans(Transaction trans) {
		this.trans = trans;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	
	

	

}
