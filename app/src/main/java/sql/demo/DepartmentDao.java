package sql.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DepartmentDao implements Dao<Department>{
    Connection connection;

    public DepartmentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department e) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into departments (dname) values (?)", Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, e.getName());
            pStatement.execute();
            ResultSet resultSet = pStatement.getGeneratedKeys();
            if (resultSet.next()) {
                e.setId(resultSet.getInt(1));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
    }

    @Override
    public List<Department> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Department e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Department e) {
        // TODO Auto-generated method stub
        
    }
    
}
