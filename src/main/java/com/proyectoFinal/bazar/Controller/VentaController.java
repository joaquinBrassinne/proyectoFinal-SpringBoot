
package com.proyectoFinal.bazar.Controller;

import com.proyectoFinal.bazar.dto.VentaDTO;
import com.proyectoFinal.bazar.model.Producto;
import com.proyectoFinal.bazar.model.Venta;
import com.proyectoFinal.bazar.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaServ;
    
    @GetMapping("/venta/traer")
    public List<Venta> getVenta(){
        return ventaServ.getVenta();
    }
    
    @GetMapping("/venta/traer/{codigo_venta}")
    public Venta getOneVenta(@PathVariable Long codigo_venta){
        return ventaServ.getOneVenta(codigo_venta);
    }
    
    @GetMapping("/ventas/producto/{codigo_venta}")
    public List<Producto> getProductosVenta(@PathVariable Long codigo_venta){
        return ventaServ.getProductosVenta(codigo_venta);
    }
    
    @GetMapping("/ventas/traer/dto/{codigo_venta}")
    public VentaDTO getVentaDTO(@PathVariable Long codigo_venta){
        return ventaServ.getVentaDTO(codigo_venta);
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductoOneVenta(@PathVariable Long codigo_venta){
        return ventaServ.getOneProductos(codigo_venta);
    }
    
    @GetMapping("/ventas/{fecha_venta}")
    public List<Venta> getVentaFecha(@PathVariable LocalDate fecha_venta){
        return ventaServ.getVentaFecha(fecha_venta);
    }
    
    @PostMapping("/venta/crear")
    public String saveVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta);
        return "venta creada correctamente";
    }
    
    @PutMapping("'/venta/editar")
    public String editVenta(@RequestBody Venta venta){
        ventaServ.editVenta(venta);
        return "Venta editado correctamente";
    }
    
    @DeleteMapping("/venta/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        
        ventaServ.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    
    }
}
