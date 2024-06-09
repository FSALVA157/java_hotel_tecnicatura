

import abstractas.HabitacionGeneral;
import interfaces.IHabitacion;
import java.time.LocalDate;
import java.util.List;

    

public class HabitacionSuite extends HabitacionGeneral<ComodidadPremium>{
    

    public HabitacionSuite(String tipo, double precio, List<ComodidadPremium> comodidades) {
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
    public List<ComodidadPremium> getComodidades() {
        return this.comodidades;
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int verifica_reservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        int noches = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        return (verifica_reservas < 5) && (noches >= 3);
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double precio_comodidades = 0;
        for (Object comodidad : this.comodidades) {
            ComodidadPremium comodidad_aux = (ComodidadPremium) comodidad;
            precio_comodidades +=  comodidad_aux.getPrecio();  
        }
        int noches = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        double precio_diario = this.getPrecio() + precio_comodidades;
        double precio_total = noches * precio_diario;
        if (noches > 5){
            return precio_total * 0.85;
        }
        return precio_total;
    }

    public boolean equals(IHabitacion<ComodidadPremium> otra_Habitacion) {
        return this.getTipo().equals(otra_Habitacion.getTipo()) && this.getPrecio() == otra_Habitacion.getPrecio();
    }

}


