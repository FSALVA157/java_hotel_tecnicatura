

import abstractas.Comodidad;
import abstractas.HabitacionGeneral;
import interfaces.IReserva;
import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidad {
    private List<HabitacionGeneral<? extends Comodidad>> habitaciones;
    private List<IReserva> reservas;

    

    public GestorDisponibilidad(List<HabitacionGeneral<? extends Comodidad>> habitaciones, List<IReserva> reservas) {
        this.habitaciones = habitaciones;
        this.reservas = reservas;
    }

    public int contarReservas(HabitacionGeneral<?> hab, LocalDate fechaInicio, LocalDate fechaFin) {
        int cantReservas = 0;
        for (IReserva reserva : reservas) {
            if (reserva.getHabitacion().equals(hab) &&
                    (reserva.getFechaInicio().isBefore(fechaFin) && reserva.getFechaFin().isAfter(fechaInicio))) {
                cantReservas++;
            }
        }
        return cantReservas;
    }

}
