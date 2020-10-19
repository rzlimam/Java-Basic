package day17;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



public class DetailTransDao {
	
	private final String TBL_DETAILTRANS = "detailtransaction";
	private final String COL_IDDETAILTRANS = "iddetailtrans";
	private final String COL_IDTRANS = "idtransaction";
	private final String COL_IDITEMS = "iditem";
	private final String COL_QTY = "qty";
	
	//table Transaksi
	private final String TBL_TRANS = "transactions";
	private final String COL_NOTRANS = "nomortransaction";
	private final String COL_IDEMPLOYEES = "idemployee";
	private final String COL_TGLTRANS = "tgltransaction";
	private final String COL_JMLBAYAR = "jmlbayar";
	
	//table temp
	private final String TBL_TEMP = "temporary";
	private final String COL_IDTEMP = "idtemp";
	private final String COL_IDEMPTEMP = "idemp";
	private final String COL_IDITEMTEMP = "iditem";
	private final String COL_QTYS = "qty";
	private final String COL_SUBTOTAL = "subtotal";
	private final String COL_TOTITEM = "totitem";
	private final String COL_TOTBAYAR = "jmlbayar";
	
	// table employee
	private final String TBL_EMPLOYEE = "employees";
	private final String COL_IDEMP = "idemp";
	private final String COL_EMPNUM = "empnum";
	private final String COL_EMPNAME = "empname";
	private final String COL_EMPGENDER = "empgender";
	private final String COL_EMPTELP = "emptelp";
	private final String COL_EMPADRESS = "empadress";
	
	//table item
	private final String TBL_ITEM = "Items";
	private final String COL_IDITEM = "iditem";
	private final String COL_KODEITEM = "kodeitem";
	private final String COL_NAMAITEM = "namaitem";
	private final String COL_IDCAT = "idcategory";
	private final String COL_AS = "activestate";
	
	//table price
	private final String TBL_PRICE = "itemprice";
	private final String COL_IDPRICE = "idprice";
	private final String COL_IDITEMPRICE = "iditem";
	private final String COL_PRICE = "price";
	private final String COL_TGLSTART = "tglstart";
	private final String COL_TGLEND = "tglend";
	
	//table stock
	private final String TBL_STOCK = "itemstock";
	private final String COL_IDITEMSTOCK = "iditem";
	private final String COL_STOCK = "stock";
	
	public void insertTemp(Temporary temp) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "INSERT INTO " + TBL_TEMP +
					"(" + COL_IDEMPTEMP + "," +
					COL_IDITEMTEMP + "," +
					COL_QTYS + "," +
					COL_SUBTOTAL + ") VALUES (" +
					temp.getIdEmp() + "," +
					temp.getIdItem() + "," +
					temp.getQty() + "," +
					temp.getSubTotal() + ")";
			statement.execute(query);
			statement.close();
			ds.closeConnection();
			System.out.println("data masuk");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Temporary findIdItem(int idItem) {
		DataSource ds = new DataSource();
		Temporary temp = new Temporary();
		try {
			Statement statement = ds.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + TBL_TEMP +
					" WHERE " + COL_IDITEMTEMP + " = " + idItem);
			while(result.next()) {
				temp.setIdTemp(result.getInt(COL_IDTEMP));
				temp.setIdItem(result.getInt(COL_IDITEMTEMP));
				temp.setIdEmp(result.getInt(COL_IDEMPTEMP));
				temp.setQty(result.getInt(COL_QTYS));
				temp.setSubTotal(result.getInt(COL_SUBTOTAL));
			}
			statement.close();
			ds.closeConnection();
			return temp;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Temporary getIdTemp (int idItem) {
		DataSource ds = new DataSource();
		Temporary temp = new Temporary();
		try {
			Statement statement = ds.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + TBL_TEMP +
					" WHERE " + COL_IDITEMTEMP + " = '" + idItem + "'");
			while(result.next()) {
				temp.setIdTemp(result.getInt(COL_IDTEMP));
				temp.setIdItem(result.getInt(COL_IDITEMTEMP));
				temp.setIdEmp(result.getInt(COL_IDEMPTEMP));
				temp.setQty(result.getInt(COL_QTYS));
				temp.setSubTotal(result.getInt(COL_SUBTOTAL));
			}
			statement.close();
			ds.closeConnection();
			return temp;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void updateTemp(Temporary temp) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "UPDATE " + TBL_TEMP + 
					" SET " + COL_QTYS + " = " + temp.getQty() + "," +
					COL_SUBTOTAL + " = " + temp.getSubTotal() +
					" WHERE " + COL_IDTEMP + " = " + temp.getIdTemp();
			statement.execute(query);
			statement.close();
			ds.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cancelItem(int idTemp) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			statement.execute("DELETE FROM " + TBL_TEMP +
					" WHERE " + COL_IDTEMP + " = " + idTemp);
			statement.close();
			ds.closeConnection();
			System.out.println("item canceled");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteTemp() {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			statement.execute("DELETE FROM " + TBL_TEMP);
			statement.close();
			ds.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public Map<Integer, Temporary> getTemporary(int idEmp) {
		DataSource ds = new DataSource();
		Map<Integer, Temporary> tempMap = new HashMap<Integer, Temporary>();
		
		try {
			Statement statement = ds.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + TBL_TEMP +
					" WHERE " + COL_IDEMP + " = " + idEmp);
			while(result.next()) {
				Temporary temp = new Temporary();
				temp.setIdTemp(result.getInt(COL_IDTEMP));
				temp.setIdEmp(result.getInt(COL_IDEMPTEMP));
				temp.setIdItem(result.getInt(COL_IDITEMTEMP));
				temp.setQty(result.getInt(COL_QTYS));
				temp.setSubTotal(result.getInt(COL_SUBTOTAL));
				tempMap.put(result.getInt(COL_IDITEMTEMP), temp);
			}
			statement.close();
			ds.closeConnection();
			return tempMap;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void displayTransaksi(int idEmp) {
		DataSource ds = new DataSource();
		System.out.println("-----------------------------");
		System.out.println("Item\tPrice\tQty\tSubtotal");
		System.out.println("-----------------------------");
		try {
			Statement statement = ds.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT TEMP.*, EMP.*, IT.*, PR.* FROM " + TBL_TEMP + " AS TEMP " +
					" JOIN " + TBL_EMPLOYEE + " AS EMP ON EMP." + COL_IDEMP + " = TEMP." + COL_IDEMPTEMP +
					" JOIN " + TBL_ITEM + " AS IT ON IT." + COL_IDITEM + " = TEMP." + COL_IDITEMTEMP +
					" JOIN " + TBL_PRICE + " AS PR ON PR." + COL_IDITEMPRICE + " = IT." + COL_IDITEM +
					" WHERE TEMP." + COL_IDEMP + " = " + idEmp +
					" AND PR." + COL_TGLEND + " is null");
			while(result.next()) {
				System.out.println(result.getString(COL_NAMAITEM) +
						"\t" + result.getInt(COL_PRICE) +
						"\t" + result.getInt(COL_QTYS) +
						"\t" + result.getInt(COL_SUBTOTAL));
			}
			System.out.println("-----------------------------");
			
			System.out.println("Total item \t: "+getTotalItem(idEmp));
			System.out.println("Total bayar \t: "+getTotalBayar(idEmp));
			
			statement.close();
			ds.closeConnection();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public int getTotalItem(int idEmp) {
		DataSource ds = new DataSource();
		int totalItem = 0;
		try {
			Statement statement = ds.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT count(*) AS "+ COL_TOTITEM +" FROM " + TBL_TEMP +
					" WHERE " + COL_IDEMPTEMP + " = " + idEmp);
			while(result.next()) {
				totalItem = result.getInt(COL_TOTITEM);
			}
			statement.close();
			ds.closeConnection();
			return totalItem;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public int getTotalBayar(int idEmp) {
		DataSource ds = new DataSource();
		int total = 0;
		try {
			
			Statement statement = ds.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT SUM(" + COL_SUBTOTAL + ") AS " +
					COL_TOTBAYAR +" FROM " + TBL_TEMP +
					" WHERE " + COL_IDEMPTEMP + " = " + idEmp +
					" GROUP BY " + COL_IDEMPTEMP);
			while(result.next()) {
				total = result.getInt(COL_TOTBAYAR);
			}
			statement.close();
			ds.closeConnection();
			return total;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public void insertDetailTrans(DetailTrans dt) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "INSERT INTO " + TBL_DETAILTRANS +
					"(" + COL_IDTRANS + "," +
					COL_IDITEMS + "," +
					COL_QTY + ") VALUES (" +
					dt.getIdTrans() + "," +
					dt.getIdItem() + "," +
					dt.getQty() + ")";
			statement.execute(query);
			statement.close();
			ds.getConnection();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertTrans(Transaction trans) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "INSERT INTO " + TBL_TRANS +
					"(" + COL_NOTRANS + "," +
					COL_IDEMPLOYEES + "," +
					COL_TGLTRANS + "," +
					COL_JMLBAYAR + ") VALUES ('" +
					trans.getNomorTrans() + "'," +
					trans.getIdEmp() + ", '" +
					trans.getTglTrans() + "'," +
					trans.getJmlbayar() + ")";
			statement.execute(query);
			statement.close();
			ds.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Transaction getIdTrans(String noTrans) {
		DataSource ds = new DataSource();
		Transaction trans = new Transaction();
		try {
			Statement statement = ds.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + TBL_TRANS +
					" WHERE " + COL_NOTRANS + " = '" + noTrans + "'");
			while(result.next()) {
				trans.setIdTrans(result.getInt(COL_IDTRANS));
				trans.setNomorTrasn(result.getString(COL_NOTRANS));
				trans.setIdEmp(result.getInt(COL_IDEMPLOYEES));
				trans.setTglTrans(result.getString(COL_TGLTRANS));
				trans.setJmlbayar(result.getInt(COL_TOTBAYAR));
			}
			statement.close();
			ds.closeConnection();
			return trans;
		} catch(SQLException e) {
			System.out.println(e.getMessage()); 
		}
		return null;
	}
	
	public String getNomorTrans(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return "TRX-"+sb.toString(); 
    } 
	
	public void saveTransaction(String noTrans, int idEmp, int totalBayar) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			statement.execute("CALL pl_transaction( '" + noTrans + "'," + idEmp + "," + totalBayar + ")");
			statement.close();
			ds.closeConnection();
		} catch(SQLException e) {
			System.out.println("Query failed "+e.getMessage());
		}
	}
	
//	public void printStruk(String noTrans) {
//		DataSource ds = new DataSource();
//		EmployeeDao emp = new EmployeeDao();
//		try {
//			Statement statement = ds.getConnection().createStatement();
//			ResultSet result = statement.executeQuery("SELECT TR.*, EMP.*, DET.*, IT.*, PR.* FROM " + TBL_TRANS + " AS TR " +
//					" JOIN " + TBL_EMPLOYEE + " AS EMP ON EMP." + COL_IDEMP + " = TR." + COL_IDEMPLOYEES +
//					" JOIN " + TBL_DETAILTRANS + " AS DET ON DET." + COL_IDDETAILTRANS + " = TR." + COL_IDTRANS +
//					" JOIN " + TBL_ITEM + " AS IT ON IT." + COL_IDITEM + " = DET." + COL_IDITEMS +
//					" JOIN " + TBL_PRICE + " AS PR ON PR." + COL_IDITEMPRICE + " = IT." + COL_IDITEM +
//					" WHERE TR." + COL_NOTRANS + " = '" + noTrans + "'");
//			System.out.println("Kasir + "+result.getString(COL_EMPNAME));
//			System.out.println("Nomor Transaksi : "+result.getString(COL_NOTRANS));
//			System.out.println("Waktu Transaksi : "+result.getString(COL_TGLTRANS));
//			System.out.println("Item\tQty\tSubtotal");
//			System.out.println("-----------------------");
//			while(result.next()) {
//				System.out.println(result.getString(COL_NAMAITEM) +
//						"\t" + result.getInt(COL_PRICE) +
//						"\t" + result.getInt(COL_QTY) +
//						"\t" + result.getInt(COL_SUBTOTAL));
//			}
//			System.out.println("-----------------------");
//			
//			System.out.println("Total Item : "+getTotalItem(result.getInt(COL_IDEMPLOYEES)));
//			System.out.println("Total Bayar : "+getTotalBayar(result.getInt(COL_IDEMPLOYEES)));
//			
//			statement.close();
//			ds.closeConnection();
//		} catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
//	}

}
