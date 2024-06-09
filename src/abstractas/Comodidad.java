package abstractas;

import java.time.LocalDate;

public abstract class Comodidad {
    protected String nombre;
    protected double precio;

    
    
    public Comodidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacio");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

}
