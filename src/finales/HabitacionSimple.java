package finales;

import abstractas.HabitacionGeneral;
import java.time.LocalDate;
import java.util.List;
import javax.security.auth.login.AppConfigurationEntry;

    

public class HabitacionSimple<ComodidadBasica> extends HabitacionGeneral{
    

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
    public List getComodidades() {
        return this.comodidades;
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantidad_reservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        return cantidad_reservas < 4;
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecioTotal'");
    }

}
