package dh.backend.service;

import dh.backend.model.Empleado;
import dh.backend.model.EmpleadoEfectivo;

public class LiquidadorEfectivo extends Liquidador{
    @Override
    public double calcularSueldo(Empleado empleado) {
        if( empleado instanceof EmpleadoEfectivo empleadoEfectivo){
            // EmpleadoEfectivo empleadoEfectivo = ((EmpleadoEfectivo)empleado);
            return empleadoEfectivo.getSueldoBase()+empleadoEfectivo.getPremios()-empleadoEfectivo.getDescuentos();
        }
        return 0;
    }

    @Override
    public String imprimir(Empleado empleado) {
        return "documento impreso";
    }
}
