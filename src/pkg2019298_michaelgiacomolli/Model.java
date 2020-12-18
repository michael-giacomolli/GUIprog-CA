
package pkg2019298_michaelgiacomolli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Model {
    
   //================= CONTROLLER.java SECTION ========================================================================    
    public boolean login(User user, String option){
        //OPTION DEFINES WHICH DATABASE HAS TO BE CHECKED (-customers- or -pro-) 
        boolean result = false;
        
        try {

            String dbServer = "jdbc:mysql://apontejaj.com:3306/Michael_2019298?useSSL=false";
            String dbUser = "Michael_2019298";
            String dbPassword = "2019298";
            
            if(option.equalsIgnoreCase("customer")){
                String query = "SELECT * FROM customer WHERE email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "';";
                
                // Get a connection to the database
                Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

                // Get a statement from the connection
                Statement stmt = conn.createStatement();

                // Execute the query
                ResultSet rs = stmt.executeQuery(query);

                // Loop through the result set
                if (rs.next()) {
                    result = true;
                }

                // Close the result set, statement and the connection
                rs.close();
                stmt.close();
                conn.close();
            }
            
            if(option.equalsIgnoreCase("pro")){
                String query = "SELECT * FROM pro WHERE email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "';";
                
                // Get a connection to the database
                Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

                // Get a statement from the connection
                Statement stmt = conn.createStatement();

                // Execute the query
                ResultSet rs = stmt.executeQuery(query);

                // Loop through the result set
                if (rs.next()) {
                    result = true;
                }

                // Close the result set, statement and the connection
                rs.close();
                stmt.close();
                conn.close();
            }
                        
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
        
    }
    //===================== FormController .java SECTION ==========================================================
    public boolean SignUp(User user, String option){
        
        boolean result = false;
        
        try {

            String dbServer = "jdbc:mysql://apontejaj.com:3306/Michael_2019298?useSSL=false";
            String dbUser = "Michael_2019298";
            String dbPassword = "2019298";
            
            if(option.equalsIgnoreCase("customer")){
                String query = "SELECT * FROM customer WHERE email = '" + user.getEmail() + "';";
                
                // Get a connection to the database
                Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

                // Get a statement from the connection
                Statement stmt = conn.createStatement();

                // Execute the query
                ResultSet rs = stmt.executeQuery(query);

                // Loop through the result set
                if (rs.next()) {
                    result = true;
                }

                // Close the result set, statement and the connection
                rs.close();
                stmt.close();
                conn.close();
            }
            
            if(option.equalsIgnoreCase("pro")){
                String query = "SELECT * FROM pro WHERE email = '" + user.getEmail() + "';";
                
                // Get a connection to the database
                Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

                // Get a statement from the connection
                Statement stmt = conn.createStatement();

                // Execute the query
                ResultSet rs = stmt.executeQuery(query);

                // Loop through the result set
                if (rs.next()) {
                    result = true;
                }

                // Close the result set, statement and the connection
                rs.close();
                stmt.close();
                conn.close();
            }
                        
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    //========= LET`S SET A NEW USER IN DB, SO........ ========================================================================
    public void NewUser(User user, String option){
        try {

            String dbServer = "jdbc:mysql://apontejaj.com:3306/Michael_2019298?useSSL=false";
            String dbUser = "Michael_2019298";
            String dbPassword = "2019298";
            
            if(option.equalsIgnoreCase("customer")){
                
                Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

                String query = "INSERT INTO customer (email, password, name, phone)" + " values (?, ?, ?, ?)";
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, user.getEmail());
                preparedStmt.setString (2, user.getPassword());
                preparedStmt.setString   (3, user.getName());
                preparedStmt.setInt    (4, Integer.parseInt(user.getMobile()));

                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
            }
                
            if(option.equalsIgnoreCase("pro")){
                
                Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

                String query = "INSERT INTO pro (email, password, name, phone, location)" + " values (?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, user.getEmail());
                preparedStmt.setString (2, user.getPassword());
                preparedStmt.setString   (3, user.getName());
                preparedStmt.setInt    (4, Integer.parseInt(user.getMobile()));
                preparedStmt.setString   (5, user.getAddress());

                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
            }
            
        }catch (Exception e){
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
        }
    }
}

