package finales;

import interfaces.ICliente;
import interfaces.IHabitacion;
import interfaces.IReserva;
import java.time.LocalDate;

public class Reserva implements IReserva {
    private ICliente cliente;
    private IHabitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    

    public Reserva(ICliente cliente, IHabitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public double calcularCosto() {
        throw new Error("metodo calcularCosto sin implementar");
    }

    @Override
    public void cancelarReserva() {
        throw new Error("metodo cancelarReserva sin implementar");
        
    }

    @Override
    public ICliente getCliente() {
        return this.cliente;
    }

    @Override
    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    @Override
    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    @Override
    public IHabitacion getHabitacion() {
        return this.habitacion;
    }

    @Override
    public void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        if(fechaInicio.isAfter(fechaFin)){
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        if(fechaInicio.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a la fecha actual");
        }
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean equals(IReserva otra_Reserva) {
        return this.cliente.equals(otra_Reserva.getCliente()) &&
                this.habitacion.equals(otra_Reserva.getHabitacion()) &&
                this.fechaInicio.equals(otra_Reserva.getFechaInicio()) &&
                this.fechaFin.equals(otra_Reserva.getFechaFin());
    }


}
