
package com.proyectoFinal.bazar.service;

import com.proyectoFinal.bazar.model.Cliente;
import java.util.List;


public interface IClienteService  {
    public List<Cliente> getClientes();
    public void saveCliente(Cliente cliente);
    public void deleteCliente(Long id_cliente);
    public void editCliente(Cliente cliente);
    public Cliente getOneCliente(Long id_cliente);
}
