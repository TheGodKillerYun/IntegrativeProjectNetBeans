/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author danil
 */
public class Consultas extends Conexion{
    
    public boolean editar(Funciones menu){
        Connection con = getConexion();
        
        String sql = "UPDATE usuario SET nombre = ?, telefono = ?, fechaNacimiento = ? WHERE correo = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, menu.getNombre()); //posicion 1
            ps.setString(2, menu.getTelefono()); //posicion 3
            ps.setString(3, menu.getFechaNacimiento()); //posicion 4
            ps.setString(4, menu.getCorreo());
          
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close(); //cerrar conexion
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
   public boolean cambiar(Funciones menu){
        Connection con = getConexion();
        ResultSet rs = null;
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT contrasenia FROM usuario WHERE correo = ? AND contrasenia = ?");
            ps.setString(1, menu.getCorreo().trim());
            ps.setString(2, menu.getConActual().trim());
            rs = ps.executeQuery();
          
            if(rs.next()){
                ps = con.prepareStatement("UPDATE usuario SET contrasenia = ? WHERE correo = ?");
                ps.setString(1, menu.getConNueva());
                ps.setString(2,menu.getCorreo());
                ps.executeUpdate();
                return true;
            }else{
                return false;
            }
          }catch(Exception e){
              e.printStackTrace();
              return false;
          }finally{
            try{if(rs != null) rs.close();} catch (Exception e) {}
            try{if(con != null) con.close();} catch (Exception e) {}
        }          
    }
}
