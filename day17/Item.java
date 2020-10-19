package day17;

import day16.Category;

public class Item {
	
	private int idItem;
	private String kodeItem;
	private String namaItem;
	private int idCategory;
	private String as;
	private Category category;
	
	public Item(String kodeItem, String namaItem, int idCategory, String as) {
		super();
		this.kodeItem = kodeItem;
		this.namaItem = namaItem;
		this.idCategory = idCategory;
		this.as = as;
	}
	
	public Item(int idItem, String kodeItem, String namaItem, int idCategory, String as) {
		super();
		this.idItem = idItem;
		this.kodeItem = kodeItem;
		this.namaItem = namaItem;
		this.idCategory = idCategory;
		this.as = as;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getKodeItem() {
		return kodeItem;
	}

	public void setKodeItem(String kodeItem) {
		this.kodeItem = kodeItem;
	}

	public String getNamaItem() {
		return namaItem;
	}

	public void setNamaItem(String namaItem) {
		this.namaItem = namaItem;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getAs() {
		return as;
	}

	public void setAs(String as) {
		this.as = as;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(int idCategory, String categoryCode, String categoryName) {
		this.category = new Category(idCategory, categoryCode, categoryName);
	}


}
