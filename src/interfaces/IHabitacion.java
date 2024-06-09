package interfaces;

import java.time.LocalDate;
import java.util.List;


public interface IHabitacion<T> {
     String getTipo();     
     double getPrecio();
     List<T> getComodidades();
     boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin);
     double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin);
}



