package abstractas;

import interfaces.IHabitacion;
import java.util.List;

public abstract class HabitacionGeneral<T extends Comodidad> implements IHabitacion<T> {
    protected String tipo;
    protected double precio;
    protected List<T> comodidades;

    public HabitacionGeneral(String tipo, double precio, List<T> comodidades) {
        this.tipo = tipo;
        this.precio = precio;
        this.comodidades = comodidades;
    }

    @Override
    public String toString() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Tipo de habitación: ").append(getTipo()).append("\n");
        detalles.append("Precio por noche: ").append(getPrecio()).append("\n");
        detalles.append("Comodidades:\n");
        for (Comodidad comodidad : comodidades) {
            detalles.append("  - ").append(comodidad.getNombre()).append(" a $").append(comodidad.getPrecio()).append("\n");
        }
        return detalles.toString();
    }


}
