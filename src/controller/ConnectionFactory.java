package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ConnectionFactory {
   /*  JDBC FORMATO 
        private final String DRIVE = "com.mysql.jdbc.Driver";
        private final String URL = "jdbc:mysql://localhost:3306/financeiro_db";
        private final String USER = "root";
        private final String PASS ="";
        
        public Connection getConnecyion(){
            
            try {
                Class.forName(DRIVE);
                return DriverManager.getConnection(URL, USER, PASS);
                
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException("Erro na Conexão",ex);
            }
            
        }
        public static void closeConnection(Connection con){
            try {
                 if(con!=null){
                     con.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }          
                   
        }
        
        public static void closeConnection(Connection con, PreparedStatement stmt){
                    closeConnection(con);
            try {
               if(stmt != null){
                   stmt.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }          
                   
        }
         public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
                    closeConnection(con, stmt);
            try {
               if(rs != null){
                   rs.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }          
                   
        } 
        */
    	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinanceiroUnit"); 
    
        public EntityManager getConnection(){
            return factory.createEntityManager();
        }

}
