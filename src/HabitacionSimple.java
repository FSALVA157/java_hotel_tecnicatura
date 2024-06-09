

import abstractas.HabitacionGeneral;
import interfaces.IHabitacion;
import java.time.LocalDate;
import java.util.List;

    

public class HabitacionSimple extends HabitacionGeneral<ComodidadBasica>{
    

    public HabitacionSimple(String tipo, double precio, List<ComodidadBasica> comodidades) {
        super(tipo, precio,comodidades);
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public List<ComodidadBasica> getComodidades() {
        return this.comodidades;
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantidad_reservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        return cantidad_reservas < 4;
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double precio_comodidades = 0;
        for (Object comodidad : this.comodidades) {
            ComodidadBasica comodidad_aux = (ComodidadBasica) comodidad;
            precio_comodidades +=  comodidad_aux.getPrecio();  
        }
        double precio_diario = this.getPrecio() + precio_comodidades;
        int noches = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        return noches * precio_diario;
        
    }

    public boolean equals(IHabitacion<ComodidadBasica> otra_Habitacion) {
        return this.getTipo().equals(otra_Habitacion.getTipo()) && this.getPrecio() == otra_Habitacion.getPrecio();
    }

}
