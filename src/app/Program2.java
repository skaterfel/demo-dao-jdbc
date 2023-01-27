package app;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: Department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);

//
		System.out.println();
		System.out.println("=== Test 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
//		
		System.out.println();
		System.out.println("=== Test 3: Department insert  ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
//		
		System.out.println();
		System.out.println("=== Test 4: Department update  ===");
		department = departmentDao.findById(2);
		department.setName("OldSchool");
		departmentDao.update(department);
		System.out.println("Update completed!");
//		
		System.out.println();
		System.out.println("=== Test 5: Department delete  ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		
		sc.close();
	}
}