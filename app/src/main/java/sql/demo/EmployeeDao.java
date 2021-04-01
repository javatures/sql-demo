package sql.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements Dao<Employee> {
    Connection connection;

    @Override
    public void insert(Employee employee) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into employees(dept_id, fname, surname, email, salary) values (?, ?, ?, ?, ?)");
            pStatement.setInt(1, employee.getDepartment().getId());
            pStatement.setString(2, employee.getFname());
            pStatement.setString(3, employee.getSurname());
            pStatement.setString(4, employee.getEmail());
            pStatement.setDouble(5, employee.getSalary());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public EmployeeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select eid, dept_id, fname, surname, email, salary, dname from employees inner join departments on departments.did=employees.dept_id");
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                Employee temp = new Employee(
                    rSet.getInt("eid"), 
                    new Department(rSet.getInt("dept_id"), rSet.getString("dname")), 
                    rSet.getString("fname"), 
                    rSet.getString("surname"), 
                    rSet.getString("email"), 
                    rSet.getDouble("salary"));
                list.add(temp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Employee e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Employee e) {
        // TODO Auto-generated method stub
        
    }
}
