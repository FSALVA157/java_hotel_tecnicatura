package finales;

import abstractas.Comodidad;
import java.time.LocalDate;

public class ComodidadBasica extends Comodidad {

    public ComodidadBasica(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantidad_dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        return cantidad_dias * this.getPrecio();   
    }

}
