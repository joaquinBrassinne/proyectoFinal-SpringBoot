
package com.proyectoFinal.bazar.service;

import com.proyectoFinal.bazar.dto.VentaDTO;
import com.proyectoFinal.bazar.model.Producto;
import com.proyectoFinal.bazar.model.Venta;
import com.proyectoFinal.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    //INYECCION DE DEPENDENCIAS
    @Autowired
    private IVentaRepository ventaRepo;
    
    //METODO GET
    @Override
    public List<Venta> getVenta() {
        List<Venta> listaVenta = ventaRepo.findAll();
        return listaVenta;
    }
    //METODO CREATE
    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    //METODO DELETE
    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    //METODO EDIT
    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public Venta getOneVenta(Long codigo_venta) {
        //OBTENER UNA VENTA
        Venta venta = ventaRepo.findById(codigo_venta).orElse(null);
        return venta;
    }

    @Override
    public void getFechaVenta(LocalDate fecha_venta) {
        
    }
    
    @Override
    public List<Producto> getProductosVenta(Long codigo_venta){
        //OBTENGO LA VENTA ATRAVES DE SU CODIGO Y DEVUELVO LA LISTA DE PRODUCTOS!
        Venta vent = this.getOneVenta(codigo_venta);
        return vent.getLista_producto();
 
    }
    
    //PATRON DTO
@Override
public VentaDTO getVentaDTO(Long codigo_venta) {
    VentaDTO ventaDTO = new VentaDTO();
    
    //TRAIGO LA VENTA ATRAVEZ DEL CODIGO
    Venta venta = this.getOneVenta(codigo_venta);
    
    
    ventaDTO.setApellido_cliente(venta.getUnCliente().getApellido());
    ventaDTO.setNombre_cliente(venta.getUnCliente().getNombre());
    ventaDTO.setCodigo_venta(venta.getCodigo_venta());
    ventaDTO.setFecha_compra(venta.getFecha_venta());
    
    //CREO UNA LISTA PRODUCTOS QUE TRAIGA LOS PRODUCTOS
    List<Producto> productos = venta.getLista_producto();
    //PRODUCTOS EN LA QUE VAMOS A SETEAR LOS VALORES
    List<Producto> productosConCantidad = new ArrayList<>();
    Double total = 0.0;
    
    for (Producto producto : productos) {
       
        total = producto.getCosto() + total;
        Producto productoConCantidad = new Producto();
        productoConCantidad.setCodigo_producto(producto.getCodigo_producto());
        productoConCantidad.setNombre(producto.getNombre());
        productoConCantidad.setMarca(producto.getMarca());
        productoConCantidad.setCosto(producto.getCosto());
        productoConCantidad.setCantidad_disponible(producto.getCantidad_disponible());
        productosConCantidad.add(productoConCantidad);
        venta.setTotal(total);
    }
    
    ventaDTO.setTotal(venta.getTotal());
    ventaDTO.setLista_productos(productosConCantidad);
    
    return ventaDTO;
}


    @Override
    public List<Producto> getOneProductos(Long codigo_venta) {
        Venta venta = this.getOneVenta(codigo_venta);
        
        List<Producto> listaProductosVenta = venta.getLista_producto();
        return listaProductosVenta;
    }
    
    
    @Override
    public List<Venta> getVentaFecha(LocalDate fecha_venta){
        LocalDate fechaHoy = LocalDate.now();
        fecha_venta = null;
       
        List<Venta> ventas = this.getVenta();
        List<Venta> listaVenta = new ArrayList<>();
        
        Double total = 0.0;
        for(Venta vent: ventas){
            if(fecha_venta == fechaHoy){
                total += vent.getTotal();
                vent.setTotal(total);
                listaVenta.add(vent);
            }
            return listaVenta;
        }
        return listaVenta;
    }

    
    


    
}
