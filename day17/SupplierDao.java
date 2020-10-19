package day17;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SupplierDao {
	
	private final String TBL_SUP = "suppliers";
	private final String COL_IDSUP = "idsupplier";
	private final String COL_CODESUP = "suppliercode";
	private final String COL_NAMESUP = "namasupplier";
	private final String COL_NOTELP = "notelp";
	private final String COL_ALAMAT = "alamat";
	
	public void insertSupplier(Supplier sup) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			statement.execute("INSERT INTO "+ TBL_SUP + 
						"(" + COL_CODESUP + "," +
						COL_NAMESUP + "," +
						COL_NOTELP + "," +
						COL_ALAMAT + ") VALUES ( '" +
						sup.getKodeSupplier() + "', '" +
						sup.getNamaSupplier() + "', '" +
						sup.getNoTelp() + "', '" +
						sup.getAlamat() + "')" );
			statement.close();
			ds.closeConnection();
			System.out.println("Supplier inserted!");
		} catch (SQLException e) {
			System.out.println("Input gagal "+e.getMessage());
		}
	}
	
	public Supplier getSup(String kodeSup) {
		DataSource ds = new DataSource();
		Supplier sup = new Supplier();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "SELECT * FROM " + TBL_SUP + 
					" WHERE " + COL_CODESUP + " = '" + kodeSup + "'";
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				sup.setIdSupplier(result.getInt(COL_IDSUP));
				sup.setKodeSupplier(result.getString(COL_CODESUP));
				sup.setNamaSupplier(result.getString(COL_NAMESUP));
				sup.setNoTelp(result.getString(COL_NOTELP));
				sup.setAlamat(result.getString(COL_ALAMAT));
				statement.close();
				ds.closeConnection();
				return sup;
			}
			statement.close();
			ds.closeConnection();
		} catch (SQLException e) {
			System.out.println("Kode Supplier tidak ada "+e.getMessage());
		}
		return null;
	}
	
	public void updateSup(Supplier sup) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			statement.execute("UPDATE " + TBL_SUP +
					" SET " + COL_CODESUP + " = '" + sup.getKodeSupplier() + "'" +
					"," + COL_NAMESUP + " = '" + sup.getNamaSupplier() + "'," +
					COL_NOTELP + " = '" + sup.getNoTelp() + "'," +
					COL_ALAMAT + " = '" + sup.getAlamat() + "'" +
					" WHERE " + COL_IDSUP + " = " + sup.getIdSupplier() );
			statement.close();
			ds.closeConnection();
			System.out.println("Data berhasil diubah");
		} catch (SQLException e) {
			System.out.println("Data gagal dimasukan "+e.getMessage());
		}
	}
	
	public void deleteSup(String kodeSup) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			statement.execute("DELETE FROM " + TBL_SUP +
					" WHERE " + COL_CODESUP + " = '" + kodeSup + "'");
			statement.close();
			ds.closeConnection();
			System.out.println("Data berhasil dihapus");
		} catch (SQLException e) {
			System.out.println("Data gagal dihapus "+e.getMessage());
		}
	}
	
	public void displaySup() {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "SELECT * FROM " + TBL_SUP;
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				System.out.println("Kode Supplier : " + result.getString(COL_CODESUP));
				System.out.println("Nama Supplier : " + result.getString(COL_NAMESUP));
				System.out.println("No. Telp : " + result.getString(COL_NOTELP));
				System.out.println("Alamat : " + result.getString(COL_ALAMAT));
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Gagal retrieve "+e.getMessage());
		}
	}

}
