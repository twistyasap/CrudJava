
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class conexion {

    static Connection Conectar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    Connection con;
    public Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/gymdb";
        String user="root";
         String pass="";
         
         try{
             con=DriverManager.getConnection(url,user,pass);
             
         }catch (Exception e){
             
         }
         return con;
        
    }

 
  
    }
   
   