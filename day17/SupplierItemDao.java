package day17;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SupplierItemDao {
	
	private final String TBL_SUPITEM = "suppliers_items";
	private final String COL_IDSUPITEM = "idsuppitem";
	private final String COL_IDSUPPLIER = "idsupplier";
	private final String COL_IDITEMS = "iditem";
	
	//tabel item
	private final String TBL_ITEM = "Items";
	private final String COL_IDITEM = "iditem";
	private final String COL_KODEITEM = "kodeitem";
	private final String COL_NAMAITEM = "namaitem";
	private final String COL_IDCAT = "idcategory";
	private final String COL_AS = "activestate";
	
	//tabel supplier
	private final String TBL_SUP = "suppliers";
	private final String COL_IDSUP = "idsupplier";
	private final String COL_CODESUP = "suppliercode";
	private final String COL_NAMESUP = "namasupplier";
	private final String COL_NOTELP = "notelp";
	private final String COL_ALAMAT = "alamat";
	

	public void displaySupItem() {
		DataSource ds =new DataSource();
		int counter = 1;
		System.out.println("No\tSupplier\tItem");
		System.out.println("=============================");
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "SELECT SUP." + COL_NAMESUP + ", IT." + COL_NAMAITEM + " FROM " + TBL_SUPITEM + " AS SI " +
					" JOIN " + TBL_SUP + " AS SUP ON SUP." + COL_IDSUP + " = SI." + COL_IDSUPPLIER +
					" JOIN " + TBL_ITEM + " AS IT ON IT." + COL_IDITEM + " = SI." + COL_IDITEMS + 
					" GROUP BY SUP." + COL_IDSUPPLIER + ", IT." + COL_IDITEM;
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				System.out.println(counter + ".\t" + result.getString(COL_NAMESUP) + "\t\t" + result.getString(COL_NAMAITEM));
				counter++;
			}
			statement.close();
			ds.closeConnection();		
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertSupItem(int idSup, int idItem) {
		DataSource ds =new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "INSERT INTO " + TBL_SUPITEM +
					"(" + COL_IDSUPPLIER + "," +
					COL_IDITEMS + ") VALUES (" +
					idSup + "," + idItem + ")";
			statement.execute(query);
			statement.close();
			ds.closeConnection();
			System.out.println("Insert sucessed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
