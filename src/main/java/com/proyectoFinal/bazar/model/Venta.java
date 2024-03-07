
package com.proyectoFinal.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    
    @OneToMany(mappedBy = "venta")
    private List<Producto> lista_producto;
    
    
    @OneToOne
    @JoinColumn(name = "IdCliente",//Nombre que queremos que tenga la FK
            referencedColumnName ="id_cliente"  ) //Nombre del atributo al que queremos asociar la FK
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> lista_producto, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.lista_producto = lista_producto;
        this.unCliente = unCliente;
    }
    
    
}
