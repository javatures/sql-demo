package sql.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        // TODO Auto-generated method stub
        return null;
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
