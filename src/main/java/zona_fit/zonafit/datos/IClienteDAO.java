/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package zona_fit.zonafit.datos;
import java.util.List;
import zona_fit.zonafit.dominio.cliente;


/**
 *
 * @author jesus
 */
public interface IClienteDAO {
    List<cliente> ListarClientes();
    boolean buscarClientePorId(cliente cliente);
    boolean agregarCliente(cliente cliente);
    boolean modificarCliente(cliente cliente);
    boolean eliminarCliente(cliente cliente);
}
