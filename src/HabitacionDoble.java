

import abstractas.HabitacionGeneral;
import interfaces.IHabitacion;
import java.time.LocalDate;
import java.util.List;

    

public class HabitacionDoble extends HabitacionGeneral<ComodidadBasica>{
    

    public HabitacionDoble(String tipo, double precio, List<ComodidadBasica> comodidades) {
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
        int verifica_reservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        int noches = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        return verifica_reservas == 0 && noches >= 2;
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double precio_comodidades = 0;
        for (Object comodidad : this.comodidades) {
            ComodidadBasica comodidad_aux = (ComodidadBasica) comodidad;
            precio_comodidades +=  comodidad_aux.getPrecio();  
        }
        int noches = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        double precio_diario = this.getPrecio() + precio_comodidades;
        double precio_total = noches * precio_diario;
        if (noches > 3){
            return precio_total * 0.9;
        }
        return precio_total;
    }

    public boolean equals(IHabitacion<ComodidadBasica> otra_Habitacion) {
        return this.getTipo().equals(otra_Habitacion.getTipo()) && this.getPrecio() == otra_Habitacion.getPrecio();
    }

}

