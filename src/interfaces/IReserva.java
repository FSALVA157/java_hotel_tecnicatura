package interfaces;

import java.time.LocalDate;

public interface IReserva {
    ICliente getCliente();
    IHabitacion getHabitacion();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    double calcularCosto();
    void cancelarReserva();
    void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin);

}
