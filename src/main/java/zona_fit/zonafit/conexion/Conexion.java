/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zona_fit.zonafit.conexion;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jesus
 */
public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var pass = "admin";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
        }catch( Exception e ){
            System.out.println("Ha ocurrido un error al intentar conectarse a BD " + e.getMessage() );
        }
        
        return conexion;
         
    }
    
    
    public static void main(String[] args) {
        System.out.println("Iniciando...");
        var conexion = Conexion.getConexion();
        if(conexion != null) System.out.println("Conexion exitosa");
        else System.out.println("Conexion fallida");
    }
    
}
