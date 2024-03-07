package com.proyectoFinal.bazar.service;

import com.proyectoFinal.bazar.model.Producto;
import com.proyectoFinal.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public List<Producto> getProducto() {
        List<Producto> listaProducto = prodRepo.findAll();
        return listaProducto;
    }

    @Override
    public void saveProducto(Producto producto) {
        prodRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        prodRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }

    @Override
    public Producto getOneProducto(Long codigo_producto) {
        Producto prod = prodRepo.findById(codigo_producto).orElse(null);
        return prod;
    }

    @Override
    public List<Producto> faltaDeStock() {
        List<Producto> listaProducto = this.getProducto();
        List<Producto> listaProductoSinStock = new ArrayList<>();

        for (Producto prod : listaProducto) {
            if (prod.getCantidad_disponible() <= 5) {
                listaProductoSinStock.add(prod);
            }
            return listaProductoSinStock;
        }
        return listaProductoSinStock;
    }

}
