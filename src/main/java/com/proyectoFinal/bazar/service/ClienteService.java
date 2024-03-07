
package com.proyectoFinal.bazar.service;

import com.proyectoFinal.bazar.model.Cliente;
import com.proyectoFinal.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository clienteRepo;
    
    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaCliente = clienteRepo.findAll();
        return listaCliente;
    }
    

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public void editCliente(Cliente cliente) {
        
        this.saveCliente(cliente);
    }

    @Override
    public Cliente getOneCliente(Long id_cliente) {
        Cliente cliente = clienteRepo.findById(id_cliente).orElse(null);
        return cliente;
    }
}
