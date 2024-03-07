package com.proyectoFinal.bazar.Controller;

import com.proyectoFinal.bazar.model.Producto;
import com.proyectoFinal.bazar.service.IProductoService;
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
public class ProductoController {
    
    
    @Autowired
    private IProductoService prodService;
    
    @GetMapping("/producto/traer")
    public List<Producto> getVenta(){
        return prodService.getProducto();
    }
    
    @GetMapping("/producto/falta_stock")
    public List<Producto> faltaDeStock(){
        return prodService.faltaDeStock();
    }
    
    @GetMapping("/producto/traer/{codigo_producto}")
    public Producto getOneProducto(@PathVariable Long codigo_producto){
        return prodService.getOneProducto(codigo_producto);
    }
    
    @PostMapping("/producto/crear")
    public String saveProducto(@RequestBody Producto producto){
        prodService.saveProducto(producto);
        return "Producto creado correctamente";
    }
    
    @PutMapping("/producto/editar")
    public String editProducto(@RequestBody Producto producto){
        prodService.editProducto(producto);
        return "Producto editado correctamente";
    }
    
    @DeleteMapping("/producto/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        prodService.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente"; 
    }
    
}
