/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package sql.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/sqldemo";
        String username = "sqldemo";
        String password = "p4ssw0rd";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            EmployeeDao eDao = new EmployeeDao(connection);
            DepartmentDao dDao = new DepartmentDao(connection);
            
            Department department = new Department(0, "HR");
            dDao.insert(department);
            Employee bob = new Employee(0, department, "Bob", "Johnson", "bob.johnson@compay.com", 50000.00);
            eDao.insert(bob);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
