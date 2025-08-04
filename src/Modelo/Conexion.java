/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danil
 */
public class Conexion {
     private final String BASE = "SelfMove";
    private final String USER = "root";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/" + BASE;
    private Connection con;
    
    public Connection getConexion(){
        try{
            this.con = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
        }catch(SQLException e){
            System.err.println(e);
        } 
        return this.con;
    }
    
}
