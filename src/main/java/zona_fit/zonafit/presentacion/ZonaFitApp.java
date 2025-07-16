/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zona_fit.zonafit.presentacion;

import java.util.Scanner;
import zona_fit.zonafit.datos.ClienteDAO;
import zona_fit.zonafit.datos.IClienteDAO;
import zona_fit.zonafit.dominio.cliente;

/**
 *
 * @author jesus
 */
public class ZonaFitApp {
        public static void main(String[] args) {
            zonaFitApp();
    }
        
        
    private static void zonaFitApp(){
        var salir = false;
        var consola = new Scanner( System.in );
        IClienteDAO clienteDao = new ClienteDAO();
        
        
        while( !salir ){
        
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, clienteDao);
            
            }catch( Exception e  ){
                System.out.println("Ha ocurrido un error" + e.getMessage() );
            }
        
        
            System.out.println();
        }
        
    }
    
    
    
    private static int mostrarMenu(Scanner consola){
            System.out.println(""" 
                           Zona Fit
                           Menu: 
                           1.- Listar cliente.
                           2.- Buscar Cliente.
                           3.- Agregar Cliente.
                           4.- MOdificar Cliente.
                           5.- Eliminar Cliente.
                           6.- Salir
                           
                           
                           Elige una Opcion: \s""");
            
            
            return Integer.parseInt(consola.nextLine());
    }
    
    
    private static boolean ejecutarOpciones( Scanner consola, int opcion, IClienteDAO clienteDao ){
        
        var salir = false;
        
        switch(opcion){
            
            case 1 -> {
                 System.out.println("Listado de Clientes" );
                 var clientes = clienteDao.ListarClientes();
                 clientes.forEach( System.out::println );
                 break;
            }
            
            case 2 -> {
                System.out.println("Buscar Cliente por Id" );
                System.out.println("Proporcione el Id del ciente" );
                var idCliente = Integer.parseInt(consola.nextLine());
                var clienteBuscar = new cliente(idCliente);
                var encontrado = clienteDao.buscarClientePorId(clienteBuscar);
                
                    if(encontrado)
                        System.out.println("Se encontro al  cliente " +  clienteBuscar );
                    else 
                       System.out.println("No se encontro el cliente con el id:" +  idCliente );
                break;
            }
            
            case 3 -> {
                System.out.println("--- Agregar Cliente ---");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                // Creamos el objeto cliente (sin el id)
                var cliente = new cliente(nombre, apellido, membresia);
                var agregado = clienteDao.agregarCliente(cliente);
                if(agregado)
                    System.out.println("Cliente agregado: " + cliente);
                else
                    System.out.println("Cliente NO agregado: " + cliente);
            
            
            }
            
            case 4 -> {
                System.out.println("--- Modificar Cliente ---");
                System.out.print("Id Cliente: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                // Creamos el objeto a modificar
                var cliente = new cliente(idCliente, nombre, apellido, membresia);
                var modificado = clienteDao.modificarCliente(cliente);
                if(modificado)
                    System.out.println("Cliente modificado: " + cliente);
                else
                    System.out.println("Cliente NO modificado: " + cliente);
            
            }
            case 5 -> { 
                System.out.println("--- Eliminar Cliente ---");
                System.out.print("Id Cliente: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new cliente(idCliente);
                var eliminado = clienteDao.eliminarCliente(cliente);
                if(eliminado)
                    System.out.println("Cliente Eliminado: " + cliente);
                else
                    System.out.println("Cliente NO eliminado: " + cliente);
            }
            case 6 -> { 
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: " + opcion);
    
        }
        
        return salir;
    }
    
}
