package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Scanner;

public class ProgramII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Test 1: Department insert ===");
        DepartmentDao depDao = DaoFactory.createDepartmentDao();
        Department dep = new Department(null, "Food");
        depDao.insert(dep);
        System.out.println(dep);

        System.out.println("=== Test 2: Department update ===");
        Department newDepartment = depDao.findById(1);
        newDepartment.setName("Administration");
        depDao.update(newDepartment);
        System.out.println(newDepartment);

        System.out.println("=== Test 3: Department delete by id ===");
        System.out.print("Enter id for test delete: ");
        int id = sc.nextInt();
        depDao.deleteById(id);
        System.out.println("Delete completed!");

        System.out.println("=== Test 4: Department find by id ===");
        Department newDep = depDao.findById(3);
        System.out.println(newDep);

        System.out.println("=== Test 5: Department find all ===");
        for (Department dep1 : depDao.findAll()) {
            System.out.println(dep1);
        }
        sc.close();
    }

}
