/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zona_fit.zonafit.datos;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection; 

import zona_fit.zonafit.dominio.cliente;
import static zona_fit.zonafit.conexion.Conexion.getConexion;

/**
 *
 * @author jesus
 */
public class ClienteDAO implements IClienteDAO{

    @Override
    public List<cliente> ListarClientes() {
        List<cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM zona_fit_db.cliente ORDER BY id";
        
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while( rs.next() ){
                var cliente = new cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMenbresia(rs.getInt("membresia"));
                
                clientes.add(cliente);
            }
        
        }catch(  Exception e ){
            System.out.println("Ha ocurrido un error al intentar conectarse a BD " + e.getMessage() );
        }finally{
        
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Ha ocurrido un error al intentar cerrar la BD " + e.getMessage() );
            }
            
        
        }
        
        
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM zona_fit_db.cliente WHERE id=?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMenbresia(rs.getInt("membresia"));
                return true;
            }
            
        
        }catch(  Exception e ){
            System.out.println("Ha ocurrido un error al intentar conectarse a BD " + e.getMessage() );
        }finally{
        
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Ha ocurrido un error al intentar cerrar la BD " + e.getMessage() );
            }
            
        
        }

        return false;
    }

    @Override
    public boolean agregarCliente(cliente cliente) {
        return false;
    }

    @Override
    public boolean modificarCliente(cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminarCliente(cliente cliente) {
        return false;
    }

    
    public static void main(String[] args) {
        System.out.println("Lista de Cliente");
        
        IClienteDAO clienteDao = new ClienteDAO();
        
        //var clientes = clienteDao.ListarClientes();
        //clientes.forEach( System.out::println );
        
        var cliente1 = new cliente(1);
        var encontrado = clienteDao.buscarClientePorId(cliente1);
        System.out.println("El cliente que se busco " + cliente1  );
        
        if(encontrado)
            System.out.println("Se encontro cliente " +  cliente1 );
        else 
            System.out.println("No se encontro el cliente con el id: " +  cliente1.getId() );
    }

   
}
