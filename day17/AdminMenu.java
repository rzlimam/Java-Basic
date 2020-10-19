package day17;

import java.util.Scanner;

public class AdminMenu {
	
	static Scanner sc = new Scanner(System.in);
	
	public void menu() {
		
		EmployeeDao emp = new EmployeeDao();
		RolesDao role = new RolesDao();
		UserDao user = new UserDao();
		
		int pilihan;
		
		do {
		System.out.println("===Menu Admin===");
		System.out.println("1.List Employee");
		System.out.println("2.List Role");
		System.out.println("3.List User");
		System.out.println("4. Keluar");
		
		System.out.print("Masukan pilihan : ");
		pilihan = sc.nextInt();
		switch(pilihan) {
		case 1:
			do {
			System.out.println("\n===List Employee===");
			emp.diplayEmployee();
			System.out.println();
			System.out.println("1. Add employee");
			System.out.println("2. Edit employee");
			System.out.println("3. Delete employee");
			System.out.println("4. Kembali");
			System.out.print("Masukan pilihan : ");
			pilihan = sc.nextInt();
			switch(pilihan) {
			case 1:
				System.out.println("Input employee");
				System.out.print("Employee number : ");
				sc.nextLine();
				String empNumber = sc.nextLine();
				System.out.print("Employee Name : ");
				String empName = sc.nextLine();
				System.out.println("Gender : ");
				String empGender = sc.nextLine();
				System.out.println("No. Telp : ");
				String empTelp = sc.nextLine();
				System.out.print("Adress : ");
				String empAdress = sc.nextLine();
				
				Employee newEmp = new Employee(empNumber, empName, empGender, empTelp, empAdress);
				emp.insertEmployee(newEmp);
				System.out.println();
				break;
			case 2:
				System.out.println("Update Employee");
				System.out.print("Employee number : ");
				sc.nextLine();
				empNumber = sc.nextLine();
				if(emp.getEmployee(empNumber) != null) {
					int idEmp = emp.getEmployee(empNumber).getIdEmp();
					System.out.print("Employee Name : ");
					empName = sc.nextLine();
					System.out.print("Gender : ");
					empGender = sc.nextLine();
					System.out.print("No. Telp : ");
					empTelp = sc.nextLine();
					System.out.print("Adress : ");
					empAdress = sc.nextLine();
					
					Employee editEmp = new Employee(idEmp, empNumber, empName, empGender, empTelp, empAdress);
					emp.updateEmployee(editEmp);
				} else
					System.out.println("Employee number not registered");
				System.out.println();
				break;
			case 3:
				System.out.println("Delete Employee");
				System.out.print("Employee number : ");
				sc.nextLine();
				empNumber = sc.nextLine();
				if(emp.getEmployee(empNumber) != null) {
					emp.deleteEmployee(empNumber);
				}else
					System.out.println("Employee number not registered");
				System.out.println();
				break;
			}
			}while(pilihan!=4);
			break;
		case 2:
			do {
			System.out.println("\n===List Role===");
			role.diplayRole();
			System.out.println();
			System.out.println("1. Add role");
			System.out.println("2. Edit role");
			System.out.println("3. Delete role");
			System.out.println("4. Kembali");
			System.out.print("Masukan pilihan : ");
			pilihan = sc.nextInt();
			switch(pilihan) {
			case 1:
				System.out.println("Input role");
				System.out.print("Role name : ");
				sc.nextLine();
				String roleName = sc.nextLine();
				
				Role newRole = new Role();
				newRole.setRoleName(roleName);
				role.insertRole(roleName);
				System.out.println();
				break;
			case 2:
				System.out.println("Update role");
				System.out.print("Input role name : ");
				sc.nextLine();
				roleName = sc.nextLine();
				if(role.getRole(roleName) != null) {
					int idRole = role.getRole(roleName).getIdRole();
					System.out.print("role name baru : ");
					roleName = sc.nextLine();
					Role editRole = new Role(idRole, roleName);
					role.updateRole(editRole);
				} else {
					System.out.println("Role not found");
				}
				break;
			case 3:
				System.out.println("Delete Role");
				System.out.print("Input role name : ");
				sc.nextLine();
				roleName = sc.nextLine();
				if(role.getRole(roleName) != null) {
					role.deleteRole(roleName);
					
				} else {
					System.out.println("Role not found");
				}
				break;
			}
			}while(pilihan!=4);
			break;
		case 3:
			do {
			System.out.println("\n===List User===");
			user.diplayUser();
			System.out.println("1. Add user");
			System.out.println("2. Edit user");
			System.out.println("3. Delete user");
			System.out.println("4. Kembali");
			System.out.print("Masukan pilihan : ");
			pilihan = sc.nextInt();
			switch(pilihan) {
			case 1:
				System.out.println("Input user");
				System.out.print("Masukan username : ");
				sc.nextLine();
				String username = sc.nextLine();
				System.out.print("Masukan password : ");
				String password = sc.nextLine();
				System.out.print("Masukan Nomor Employee : ");
				String empNum = sc.nextLine();
				if(emp.getEmployee(empNum) != null) {
					int idEmp = emp.getEmployee(empNum).getIdEmp();
					System.out.print("Masukan Id Role : ");
					int idRole = sc.nextInt();
					
					User newUser = new User(username, password, idEmp, idRole);
					user.insertUser(newUser);
				} else {
					System.out.println("Number employee not found");
				}
				
				break;
			case 2:
				System.out.println("Input user");
				System.out.print("Masukan username : ");
				sc.nextLine();
				username = sc.nextLine();
				if(user.cekUsername(username) != null) {
					int idUser = user.cekUsername(username).getIdUser();
					System.out.print("Input new username : ");
					username = sc.nextLine();
					System.out.print("Masukan password : ");
					password = sc.nextLine();
					System.out.print("Masukan Nomor Employee : ");
					empNum = sc.next();
					if(emp.getEmployee(empNum) != null) {
						int idEmp = emp.getEmployee(empNum).getIdEmp();
						System.out.print("Masukan Id Role : ");
						int idRole = sc.nextInt();
						
						User editUser = new User(idUser, username, password, idEmp, idRole);
						user.updateUser(editUser);
					}else {
						System.out.println("Employee not found");
					}
					
				}else {
					System.out.println("Username not found");
				}
				break;
			case 3:
				System.out.println("Input user");
				System.out.print("Masukan username : ");
				sc.nextLine();
				username = sc.nextLine();
				if(user.cekUsername(username) != null) {
					user.deleteUser(username);
				} else {
					System.out.println("user not found");
				}
				
			}
			}while(pilihan!=4);
			break;
	}
	}while(pilihan<5);
	}

}
