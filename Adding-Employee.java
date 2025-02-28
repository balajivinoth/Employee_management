import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    public void addEmployee(String name, int age, String department, double salary) {
        String sql = "INSERT INTO employees (name, age, department, salary, hire_date) VALUES (?, ?, ?, ?, CURDATE())";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, department);
            ps.setDouble(4, salary);
            ps.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
