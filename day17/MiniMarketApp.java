package day17;


import java.util.Scanner;

public class MiniMarketApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		UserDao user = new UserDao();
		RolesDao role = new RolesDao();
		EmployeeDao emp = new EmployeeDao();
		ItemDao item = new ItemDao();
		
//		int idItem = sc.nextInt();
//		int stock = sc.nextInt();
//		int minStock = -stock;
//		String desc = "PJ";
//		sc.nextLine();
//		String tgl = sc.nextLine();
//		
//		Stock pj = new Stock(idItem, minStock, desc, tgl);
//		item.insertStock(pj);
		
		AdminMenu admin = new AdminMenu();
		InvenMenu inv = new InvenMenu();
		KasirMenu kasir = new KasirMenu();
		
		boolean flag;
		do {
		flag = true;
		System.out.println("Login");
		System.out.println("==============");
		System.out.print("Username : ");
		String username = sc.nextLine();
		System.out.print("Password : ");
		String password = sc.nextLine();
		if(user.cekUsername(username) != null) {
			try {
			User users = new User(username, password);
			user.login(users);
			
			String roleName = role.getRoleName(users.getIdRole()).getRoleName();
			String empName = emp.getEmpName(users.getIdEmp()).getEmpName();
			if(users.getIdRole() == 1) {
				System.out.println("Selamat datang "+roleName+", "+empName);
				admin.menu();
			} else if(users.getIdRole() == 2) {
				System.out.println("Selamata datang "+roleName+", "+empName);
				kasir.menu(users);
			} else if(users.getIdRole() == 3) {
				System.out.println("Selamata datang "+roleName+", "+empName);
				inv.menu();
			} else {
				System.out.println("Password Salah");
				System.out.println();
			}
			} catch (NullPointerException e) {
				System.out.println("Password Salah");
				// TODO: handle exception
			}
				
		}else {
			System.out.println("Username belum terdafar");
			System.out.println();
		}
		}while(flag == true);
//		user.login(users);
		sc.close();
	}

}
