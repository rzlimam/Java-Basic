package day17;

public class User {
	
	private int idUser;
	private String username;
	private String password;
	private int idEmp;
	private int idRole;
	
//	private Employee emp;
//	private Role role;
	
	public User() {
		
	}
	
	public User(int idUser, String username, String password, int idEmp, int idRole) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.idEmp = idEmp;
		this.idRole = idRole;
	}
	
	public User(String username, String password, int idEmp, int idRole) {
		super();
		this.username = username;
		this.password = password;
		this.idEmp = idEmp;
		this.idRole = idRole;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

//	public Employee getEmp() {
//		return emp;
//	}
//
//	public void setEmp(int idEmp, String empNumber, String empName, String empGender, String empTelp, String empAdress) {
//		this.emp = new Employee(idEmp, empNumber, empName, empGender, empTelp, empAdress);
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(int idRole, String roleName) {
//		this.role = new Role(idRole, roleName);
//	}
	
	

}
