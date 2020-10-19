package day17;

public class Category {
	
	private int idCategory;
	private String categoryCode;
	private String categoryName;
	
	public Category() {
		
	}
	
	public Category(int idCategory, String categoryCode, String categoryName) {
		super();
		this.idCategory = idCategory;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}
	
	public Category(String categoryCode, String categoryName) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
