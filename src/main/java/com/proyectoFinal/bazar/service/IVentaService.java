
package com.proyectoFinal.bazar.service;

import com.proyectoFinal.bazar.dto.VentaDTO;
import com.proyectoFinal.bazar.model.Producto;
import com.proyectoFinal.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    public List<Venta> getVenta();
    public void saveVenta(Venta venta);
    public void deleteVenta(Long codigo_venta);
    public void editVenta(Venta venta);
    public Venta getOneVenta(Long codigo_venta);
    public void getFechaVenta(LocalDate fecha_venta);
    public List<Producto> getProductosVenta(Long codigo_venta);
    public VentaDTO getVentaDTO(Long codigo_venta);
    public List<Producto> getOneProductos(Long codigo_venta);
    //public void getPlataTotal(LocalDate fecha_venta);
    public List<Venta> getVentaFecha(LocalDate fecha_venta);
}
