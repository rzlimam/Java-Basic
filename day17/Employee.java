package day17;

public class Employee {
	
	private int idEmp;
	private String empNumber;
	private String empName;
	private String empGender;
	private String empTelp;
	private String empAdress;
	
	public Employee() {
		
	}
	
	public Employee(int idEmp, String empNumber, String empName, String empGender, String empTelp, String empAdress) {
		super();
		this.idEmp = idEmp;
		this.empNumber = empNumber;
		this.empName = empName;
		this.empGender = empGender;
		this.empTelp = empTelp;
		this.empAdress = empAdress;
	}
	
	public Employee(String empNumber, String empName, String empGender, String empTelp, String empAdress) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.empGender = empGender;
		this.empTelp = empTelp;
		this.empAdress = empAdress;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpTelp() {
		return empTelp;
	}

	public void setEmpTelp(String empTelp) {
		this.empTelp = empTelp;
	}

	public String getEmpAdress() {
		return empAdress;
	}

	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}
	
	
	

}
