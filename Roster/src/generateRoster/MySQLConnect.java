/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateRoster;

/**
 *
 * @author Ray
 */
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class MySQLConnect {
    //Connection conn=null;

    private static Connection conn;
    private Statement stmt;
    private ResultSet rset;

    public static Connection ConnectDb() {
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
//            return conn;
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,e);
//            return null;
//        }
        try {
            // Load the Oracle JDBC driver
            OracleDataSource ods = new OracleDataSource();

            ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
            ods.setUser("hr");
            ods.setPassword("passhr");

            conn = ods.getConnection();
            System.out.println("connected.");
            return conn;
        } catch (SQLException e) {
            System.out.print("Unable to load driver " + e);
            System.exit(1);
            return null;
        }
    }
}
