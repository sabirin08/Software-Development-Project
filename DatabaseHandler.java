import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

public class DatabaseHandler { 


private Connection getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } 
    String url = "jdbc:mysql://localhost:3306/employeedata"; 
    String user = "root"; 
    String password = "paSSuhsJzQ321!"; 
 
    // Establish the connection 
    return DriverManager.getConnection(url, user, password); 
} 
 
public void insertEmployee(Employee emp) { 
    String query = "INSERT INTO employee (empid, name, ssn, job_title, division, salary, pay_statement) VALUES (?, ?, ?, ?, ?, ?, ?)"; 
    try (Connection conn = getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) { 
        stmt.setInt(1, emp.getEmpId()); 
        stmt.setString(2, emp.getName()); 
        stmt.setString(3, emp.getSsn()); 
        stmt.setString(4, emp.getJobTitle()); 
        stmt.setString(5, emp.getDivision()); 
        stmt.setDouble(6, emp.getSalary()); 
        stmt.setString(7, emp.getPayStatement()); 
        stmt.executeUpdate(); 
        System.out.println("Employee added successfully."); 
    } catch (SQLException e) { 
        e.printStackTrace(); 
    } 
} 
 
public void updateEmployee(Employee emp) { 
    String query = "UPDATE employee SET name=?, ssn=?, job_title=?, division=?, salary=?, pay_statement=? WHERE empid=?"; 
    try (Connection conn = getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) { 
        stmt.setString(1, emp.getName()); 
        stmt.setString(2, emp.getSsn()); 
        stmt.setString(3, emp.getJobTitle()); 
        stmt.setString(4, emp.getDivision()); 
        stmt.setDouble(5, emp.getSalary()); 
        stmt.setString(6, emp.getPayStatement()); 
        stmt.setInt(7, emp.getEmpId()); 
        stmt.executeUpdate(); 
        System.out.println("Employee updated successfully."); 
    } catch (SQLException e) { 
        e.printStackTrace(); 
    } 
} 
 
public void searchEmployee(String input) { 
    String query = "SELECT * FROM employee WHERE name=? OR ssn=? OR empid=?"; 
    try (Connection conn = getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) { 
        stmt.setString(1, input); 
        stmt.setString(2, input); 
        try { 
            stmt.setInt(3, Integer.parseInt(input)); 
        } catch (NumberFormatException e) { 
            stmt.setInt(3, -1); // Invalid empid fallback 
        } 
        ResultSet rs = stmt.executeQuery(); 
        while (rs.next()) { 
            System.out.println("ID: " + rs.getInt("empid") + ", Name: " + rs.getString("name") + 
                    ", SSN: " + rs.getString("ssn") + ", Title: " + rs.getString("job_title") + 
                    ", Division: " + rs.getString("division") + ", Salary: " + rs.getDouble("salary") + 
                    ", Pay Statement: " + rs.getString("pay_statement")); 
        } 
    } catch (SQLException e) { 
        e.printStackTrace(); 
    } 
} 
 
public void updateSalaryByRange(double percent, double min, double max) { 
    String query = "UPDATE employee SET salary = salary + (salary * ? / 100) WHERE salary >= ? AND salary < ?"; 
    try (Connection conn = getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) { 
        stmt.setDouble(1, percent); 
        stmt.setDouble(2, min); 
        stmt.setDouble(3, max); 
        int rows = stmt.executeUpdate(); 
        System.out.println("Updated salaries for " + rows + " employee(s)."); 
    } catch (SQLException e) { 
        e.printStackTrace(); 
    } 
} 
 
public void showAllEmployees() { 
    String query = "SELECT * FROM employee"; 
    try (Connection conn = getConnection(); 
         Statement stmt = conn.createStatement(); 
         ResultSet rs = stmt.executeQuery(query)) { 
        while (rs.next()) { 
            System.out.println("ID: " + rs.getInt("empid") + ", Name: " + rs.getString("name") + 
                    ", SSN: " + rs.getString("ssn") + ", Job Title: " + rs.getString("job_title") + 
                    ", Division: " + rs.getString("division") + ", Salary: " + rs.getDouble("salary") + 
                    ", Pay Statement: " + rs.getString("pay_statement")); 
        } 
    } catch (SQLException e) { 
        e.printStackTrace(); 
    } 
} 
  

}
