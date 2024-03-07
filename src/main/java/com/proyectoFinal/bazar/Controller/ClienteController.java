
package com.proyectoFinal.bazar.Controller;

import com.proyectoFinal.bazar.model.Cliente;
import com.proyectoFinal.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService cliService;
    
    @GetMapping("/cliente/traer")
    public List<Cliente> getCliente(){
        return cliService.getClientes();
    }
    
    @GetMapping("/cliente/traer/{id_cliente}")
    public Cliente getOneCliente(@PathVariable Long id_cliente){
        return cliService.getOneCliente(id_cliente);
    }
    
    @PostMapping("/cliente/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        cliService.saveCliente(cliente);
        return "Cliente creado correctamente";
    }
    
    @PutMapping("/cliente/editar")
    public String editCliente(@RequestBody Cliente cliente){
        cliService.saveCliente(cliente);
        return "Cliente editado correctamente";
    }
    
    @DeleteMapping("/cliente/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliService.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }
}
