
package com.proyectoFinal.bazar.dto;

import com.proyectoFinal.bazar.model.Producto;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaDTO {
    
    private Long codigo_venta;
    private Double total;
    private String nombre_cliente;
    private String apellido_cliente;
    private LocalDate fecha_compra;
    private List<Producto> lista_productos;

    public VentaDTO() {
    }

    public VentaDTO(Long codigo_venta, Double total, String nombre_cliente, String apellido_cliente, LocalDate fecha_compra, List<Producto> lista_productos) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.fecha_compra = fecha_compra;
        this.lista_productos = lista_productos;
    }

   
    
    
    
}
