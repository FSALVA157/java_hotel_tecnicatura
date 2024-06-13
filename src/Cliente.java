
import interfaces.ICliente;
import interfaces.IReserva;

public class Cliente implements  ICliente{
    private String nombre;
    private Integer puntos;

    
    public Cliente(String nombre, Integer puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Integer getPuntos() {
        return this.puntos;
    }

    @Override
    public void acumularPuntos(IReserva reserva) {
        this.puntos += (int) reserva.calcularCosto() / 100;
    }

}
