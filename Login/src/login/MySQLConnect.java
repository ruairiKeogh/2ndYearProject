/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author X00121581
 */
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {
    //Connection conn=null;
    
    private static Connection conn;
    private Statement stmt;
    private ResultSet rset;
    
    public static Connection ConnectDb() {
        
        try {
            // Load the Oracle JDBC driver
            OracleDataSource ods = new OracleDataSource();

            //ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521/XE");
            //ods.setUser("hr");
            //ods.setPassword("passhr");
            
            ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");               
            ods.setUser("X00121581");
            ods.setPassword("db29Jan96");
            

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
