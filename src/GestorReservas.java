

import interfaces.ICliente;
import interfaces.IHabitacion;
import interfaces.IReserva;
import java.time.LocalDate;
import java.util.List;

public class GestorReservas {
    private List<IReserva> reservas;


    public GestorReservas(List<IReserva> reservas) {
        this.reservas = reservas;
    }

    public void realizarReserva(ICliente cliente, IHabitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin){
        try {
            IReserva nueva_reserva = new Reserva(cliente, habitacion, fechaInicio, fechaFin);     
            this.reservas.add(nueva_reserva);
            cliente.acumularPuntos(nueva_reserva);
        } catch (Exception e) {
            throw new Error("No se pudo realizar la reserva");
        }

    }

    public void cancelarReserva(IReserva reserva_cancelada){
        for (IReserva reserva : reservas) {
            if(reserva.equals(reserva_cancelada)){
                this.reservas.remove(reserva);
                reserva.cancelarReserva();
                break;
            }
        }
    }

    public void modificarReserva(IReserva reserva_dato, LocalDate fechaInicio, LocalDate fechaFin){
        for (IReserva reserva : reservas) {
            if(reserva.equals(reserva_dato)){
                reserva.modificarFechas(fechaInicio, fechaFin);
            }
        }
    }


    public double calcCostoReserva(Reserva reserva){
        return reserva.calcularCosto();
    };

    public void listarReservas(){
        for (IReserva reserva : reservas) {
            System.out.println(reserva.toString());
        }
    }

}
