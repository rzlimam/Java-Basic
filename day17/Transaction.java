package day17;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
	
	private int idTrans;
	private String nomorTrans;
	private int idEmp;
	private String tglTrans;
	private int jmlbayar;
	
	private Employee emp;
	
	public Transaction() {
		
	}
	
	public Transaction(int idTrans, String nomorTrans, int idEmp, String tglTrans, int jmlbayar) {
		super();
		this.idTrans = idTrans;
		this.nomorTrans = nomorTrans;
		this.idEmp = idEmp;
		this.tglTrans = tglTrans;
		this.jmlbayar = jmlbayar;
	}
	
	public Transaction(String nomorTrans, int idEmp, String tglTrans, int jmlbayar) {
		super();
		this.nomorTrans = nomorTrans;
		this.idEmp = idEmp;
		this.tglTrans = tglTrans;
		this.jmlbayar = jmlbayar;
	}


	public int getIdTrans() {
		return idTrans;
	}


	public void setIdTrans(int idTrans) {
		this.idTrans = idTrans;
	}


	public String getNomorTrans() {
		return nomorTrans;
	}


	public void setNomorTrasn(String nomorTrans) {
		this.nomorTrans = nomorTrans;
	}


	public int getIdEmp() {
		return idEmp;
	}


	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}


	public String getTglTrans() {
		return tglTrans;
	}


	public void setTglTrans(String tglTrans) {
		this.tglTrans = tglTrans;
	}


	public int getJmlbayar() {
		return jmlbayar;
	}


	public void setJmlbayar(int jmlbayar) {
		this.jmlbayar = jmlbayar;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	

}
