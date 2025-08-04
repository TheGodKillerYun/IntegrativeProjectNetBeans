/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.*;

public class ConsultasSM extends Conexion{
    
    public boolean registrar(Cuentas cuenta){
        
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuario(nombre,correo,contrasenia) VALUES (?,?,?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getNombre());
            ps.setString(2, cuenta.getCorreo());
            ps.setString(3, cuenta.getContrasenia());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
   
        
        public boolean iniciarsesion(Cuentas cuenta){
        Connection con = getConexion();
        ResultSet rs = null;
        
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contrasenia = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getCorreo());
            ps.setString(2, cuenta.getContrasenia());
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                return true;
            }
            return false;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
               System.err.println(e); 
            }
        }
    }
        
        public boolean correo(Cuentas cuenta){
        Connection con = getConexion();
        ResultSet rs = null;
        
        String sql = "SELECT * FROM usuario WHERE correo = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getCorreo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                return true;
            }
            return false;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
               System.err.println(e); 
            }
        }
    }
        
        public boolean recuperarContrasenia(Cuentas cuenta){
        
        Connection con = getConexion();
        
        String sql = "UPDATE usuario SET contrasenia = ? WHERE correo = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getContrasenia());
            ps.setString(2, cuenta.getCorreo());
            
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
               System.err.println(e); 
            }
        }
    }
    
}
