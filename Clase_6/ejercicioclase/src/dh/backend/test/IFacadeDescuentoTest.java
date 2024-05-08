package dh.backend.test;

import dh.backend.model.Producto;
import dh.backend.model.Tarjeta;
import dh.backend.service.FacadeDescuento;
import dh.backend.service.IFacadeDescuento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeDescuentoTest {
    @Test
    @DisplayName("Testear que sumamos todos los descuentos")
    void testTodosDescuentos(){
        Tarjeta tarjeta = new Tarjeta("45464646", "Star Bank");
        Producto producto = new Producto("Latas de arvejas", "latas");
        int cantidad = 19;
        IFacadeDescuento facadeDescuento = new FacadeDescuento();
        int descuentoObtenido = facadeDescuento.calculoDescuento(tarjeta, producto, cantidad);

        assertEquals(45, descuentoObtenido);
    }

    @Test
    @DisplayName("Testear que solo obtuvimos descuento de producto")
    void testDescuentoProducto(){
        Tarjeta tarjeta = new Tarjeta("45464646", "Santander");
        Producto producto = new Producto("Latas de arvejas", "latas");
        int cantidad = 5;
        IFacadeDescuento facadeDescuento = new FacadeDescuento();
        int descuentoObtenido = facadeDescuento.calculoDescuento(tarjeta, producto, cantidad);

        assertEquals(10, descuentoObtenido);
    }

    @Test
    @DisplayName("Testear que solo obtuvimos descuento de cantidad")
    void testDescuentoCantidad(){
        Tarjeta tarjeta = new Tarjeta("45464646", "Santander");
        Producto producto = new Producto("zapatillas", "zapatillas");
        int cantidad = 15;
        IFacadeDescuento facadeDescuento = new FacadeDescuento();
        int descuentoObtenido = facadeDescuento.calculoDescuento(tarjeta, producto, cantidad);

        assertEquals(15, descuentoObtenido);
    }

}