/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg5;

/**
 *
 * @author sstoneman1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnect {

    public static void main(String[] args) throws SQLException {
        String host = "jdbc:derby://localhost:1527/Contact";
        String uName = "student";
        String uPass = "student";
        int id;
        String firstName;
        String lastName;
        String title;
        String department;
        String email;

        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            
            Statement state = con.createStatement( );
            String SQL = "SELECT * FROM STUDENT.COLLEAGUES";
            
            ResultSet Rset = state.executeQuery( SQL );
            
            while(Rset.next())
            {
                id = Rset.getInt("ID");
                firstName = Rset.getString("FIRSTNAME");
                lastName = Rset.getString("LASTNAME");
                title = Rset.getString("TITLE");
                department = Rset.getString("DEPARTMENT");
                email = Rset.getString("EMAIL");
                
                System.out.println("\nID: " + id + "\nFirst Name: " + firstName 
                        + "\nLast Name: " + lastName+ "\nTitle: " +
                        title + "\nDepartment:" + department +
                        "\nEmail:" + email);
            }
            
            
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

}

