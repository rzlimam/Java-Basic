package day17;

public class Temporary {
	
	private int idTemp;
	private int idEmp;
	private int idItem;
	private int qty;
	private int subTotal;
	
	private Employee emp;
	
	public Temporary() {
		
	}

	public Temporary(int idTemp, int idEmp, int idItem, int qty, int subTotal) {
		super();
		this.idTemp = idTemp;
		this.idEmp = idEmp;
		this.idItem = idItem;
		this.qty = qty;
		this.subTotal = subTotal;
	}
	
	public Temporary(int idEmp, int idItem, int qty, int subTotal) {
		super();
		this.idEmp = idEmp;
		this.idItem = idItem;
		this.qty = qty;
		this.subTotal = subTotal;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getIdTemp() {
		return idTemp;
	}

	public void setIdTemp(int idTemp) {
		this.idTemp = idTemp;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
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

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	

}
