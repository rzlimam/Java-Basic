package day17;

import java.sql.SQLException;
import java.sql.Statement;



public class TransactionDao {
	
	private final String TBL_TRANS = "transaction";
	private final String COL_IDTRANS = "idtransaction";
	private final String COL_NOMORTRANS = "nomortrasaction";
	private final String COL_IDEMPLOYEE = "idemployee";
	private final String COL_TGLTRANS = "tgltrasaction";
	private final String COL_JMLBAYAR = "jmlbayar";
	
	// table employee
	private final String TBL_EMPLOYEE = "employees";
	private final String COL_IDEMP = "idemp";
	private final String COL_EMPNUM = "empnum";
	private final String COL_EMPNAME = "empname";
	private final String COL_EMPGENDER = "empgender";
	private final String COL_EMPTELP = "emptelp";
	private final String COL_EMPADRESS = "empadress";
	
	public void insertTrans(Transaction transaction) {
		DataSource ds = new DataSource();
		try {
			Statement statement = ds.getConnection().createStatement();
			String query = "INSERT INTO " + TBL_TRANS +
					"(" + COL_NOMORTRANS + "," +
					COL_IDEMPLOYEE + "," +
					COL_TGLTRANS + "," +
					COL_JMLBAYAR + ") VALUES (" +
					transaction.getNomorTrans() + "," +
					transaction.getIdEmp() + "," +
					transaction.getTglTrans() + "," +
					transaction.getJmlbayar() +")";
			statement.execute(query);
			statement.close();
			ds.closeConnection();
			System.out.println("Trasaction inserted");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
