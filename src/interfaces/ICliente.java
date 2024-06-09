package interfaces;

public interface ICliente {
    String getNombre();
    Integer getPuntos();
    void acumularPuntos(IReserva reserva);
}
