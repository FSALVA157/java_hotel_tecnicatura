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
}
