
package com.proyectoFinal.bazar.service;

import com.proyectoFinal.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
     public List<Producto> getProducto();
    public void saveProducto(Producto producto);
    public void deleteProducto(Long codigo_producto);
    public void editProducto(Producto producto);
    public Producto getOneProducto(Long codigo_producto);
    public List<Producto> faltaDeStock();
}
