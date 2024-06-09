

import abstractas.Comodidad;
import java.time.LocalDate;

public class ComodidadPremium extends Comodidad{
    private String especialidad;

    public ComodidadPremium(String nombre, double precio, String especialidad) {
        super(nombre, precio);
        this.especialidad = especialidad;
    }

    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantidad_dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        double costo_base = cantidad_dias * this.getPrecio();
        double costo_final = costo_base + (costo_base * 0.25) ;
        return costo_final;   
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    


}
