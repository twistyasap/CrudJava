
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.miembros;
import vista.miembro;
        
        

public class DaoMiembro {
    Connection con;
    conexion conectar=new conexion();
    PreparedStatement ps;
    ResultSet rs;


    
    public List Listar(){
        List<miembros> lista=new ArrayList<>();
        String sql="select * from miembro";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                miembros m=new miembros();
                m.setId(rs.getInt(1));
                m.setRut(rs.getString(2));
                m.setNombre(rs.getString(3));
                m.setPaterno(rs.getString(4));
                m.setMaterno(rs.getString(5));
                m.setTaller(rs.getString(6));
                m.setDias(rs.getInt(7));
                m.setCuotas(rs.getInt(8));
                lista.add(m);
               

            }
        }catch (Exception e){
            
        }
        return lista;
    }
    
 public boolean insertar(miembros m){
     String sql="insert into miembro (rut,nombre,paterno,materno,taller,dias,cuotas)values (?,?,?,?,?,?,?)";
     try{
         con=conectar.getConnection();
         ps=con.prepareStatement(sql);
         ps.setString(1, m.getRut());
         ps.setString(2,m.getNombre());
         ps.setString(3,m.getPaterno());
         ps.setString(4,m.getMaterno());
         ps.setString(5,m.getTaller());
         ps.setInt(6,m.getDias());
         ps.setInt(7,m.getCuotas());
         int n=ps.executeUpdate();
         if(n!=0){
             return true;
         }else{
             return false;
         }

         
         
         
     }catch (Exception e){
         JOptionPane.showConfirmDialog(null, e);
         return false;
     }
 }   
 
  public boolean editar(miembros m){
     String sql="update miembro set rut=?,nombre=?,paterno=?,materno=?,taller=?,dias=?,cuotas=? where id=?";
      try{
         con=conectar.getConnection();
         ps=con.prepareStatement(sql);
         ps.setString(1, m.getRut());
         ps.setString(2,m.getNombre());
         ps.setString(3,m.getPaterno());
         ps.setString(4,m.getMaterno());
         ps.setString(5,m.getTaller());
         ps.setInt(6,m.getDias());
         ps.setInt(7,m.getCuotas());
         ps.setInt(8,m.getId());
         int n=ps.executeUpdate();
         if(n!=0){
             return true;
         }else{
             return false;
         }
         
         
     }catch (Exception e){
         JOptionPane.showConfirmDialog(null, e);
         return false;
        } 
}

     public boolean eliminar(miembros m){
         String sql="delete from miembro where id=?";
         try{
             con=conectar.getConnection();
             ps=con.prepareStatement(sql);
             ps.setInt(1, m.getId());
             int n=ps.executeUpdate();
             if(n!=0){
                 return true;
             }else{
                 return false;
             }
         }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
             return false;
         }
     }
}

