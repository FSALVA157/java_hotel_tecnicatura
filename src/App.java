
import abstractas.Comodidad;
import abstractas.HabitacionGeneral;
import interfaces.IReserva;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static GestorDisponibilidad gestorDisp;
    private static GestorReservas gestorReservas;

    public static void main(String[] args) {

        // inicializar lista de habitaciones
        List<HabitacionGeneral<? extends Comodidad>> habitaciones = new ArrayList<>();

        // inicializar lista de reservas
        List<IReserva> reservas = new ArrayList<>();

        // inicializar lista de comodidades basicas
        List<ComodidadBasica> comodidadesBasicas = new ArrayList<>();

        // inicializar lista de comodidades premium
        List<ComodidadPremium> comodidadesPremium = new ArrayList<>();

        // creamos 6 instancias de comodidades
        ComodidadBasica basica_1 = new ComodidadBasica("toallas extra", 50);
        ComodidadBasica basica_2 = new ComodidadBasica("wifi", 100);
        ComodidadBasica basica_3 = new ComodidadBasica("TV", 200);
        ComodidadPremium premium_1 = new ComodidadPremium("Spa", 500, "Spa");
        ComodidadPremium premium_2 = new ComodidadPremium("jacuzzi", 500, "Spa");
        ComodidadPremium premium_3 = new ComodidadPremium("piscina", 500, "Spa");

        // creamos tres instancias de habitaciones
        comodidadesBasicas.add(basica_1);
        comodidadesBasicas.add(basica_2);
        HabitacionSimple habitacionSimple = new HabitacionSimple("Simple", 100, comodidadesBasicas);

        comodidadesBasicas.clear();

        comodidadesBasicas.add(basica_1);
        comodidadesBasicas.add(basica_3);
        HabitacionDoble habitacionDoble = new HabitacionDoble("Doble", 200, comodidadesBasicas);

        comodidadesPremium.add(premium_1);
        comodidadesPremium.add(premium_2);
        comodidadesPremium.add(premium_3);
        HabitacionSuite habitacionSuite = new HabitacionSuite("Suite", 300, comodidadesPremium);

        // generamos dos instancias de clientes
        Cliente cliente_1 = new Cliente("Jorge Alvarez", 0);
        Cliente cliente_2 = new Cliente("Maria Rodriguez", 0);

        // instancia unica de GestorDisponibilidad
        gestorDisp = new GestorDisponibilidad(habitaciones, reservas);

        // instancia unica del GestorReservas
        gestorReservas = new GestorReservas(reservas);

        // generamos 5 reservas para cada cliente
        LocalDate fechaInicio = LocalDate.of(2025, 1, 1);
        LocalDate fechaFin = LocalDate.of(2025, 1, 31);
        boolean bandera = habitacionSimple.estaDisponible(fechaInicio, fechaFin);
        if (!bandera) {            
            throw new Error("La habitación no se encuentra disponible");
        }
        gestorReservas.realizarReserva(cliente_1, habitacionSimple, fechaInicio, fechaFin);
        //cliente_1.acumularPuntos(reservas.get(reservas.size() - 1));
        
        

        
        fechaInicio = LocalDate.of(2024, 4, 1);
        fechaFin = LocalDate.of(2024, 4, 10);
        bandera = habitacionDoble.estaDisponible(fechaInicio, fechaFin);
        if (!bandera) {            
            throw new Error("La habitación no se encuentra disponible");
        }        
        gestorReservas.realizarReserva(cliente_1, habitacionDoble, fechaInicio, fechaFin);
        //cliente_1.acumularPuntos(reservas.get(reservas.size() - 1));
        

        fechaInicio = LocalDate.of(2024, 12, 20);
        fechaFin = LocalDate.of(2024, 12, 29);
        bandera = habitacionSuite.estaDisponible(fechaInicio, fechaFin);
        if (!bandera) {            
            throw new Error("La habitación no se encuentra disponible");
        }        
        gestorReservas.realizarReserva(cliente_1, habitacionSuite, fechaInicio, fechaFin);
        //cliente_1.acumularPuntos(reservas.get(reservas.size() - 1));
        

        fechaInicio = LocalDate.of(2025, 2, 1);
        fechaFin = LocalDate.of(2025, 2, 28);
        bandera = habitacionDoble.estaDisponible(fechaInicio, fechaFin);
        if (!bandera) {            
            throw new Error("La habitación no se encuentra disponible");
        }        
        gestorReservas.realizarReserva(cliente_2, habitacionDoble, fechaInicio, fechaFin);
        

        fechaInicio = LocalDate.of(2026, 5, 24);
        fechaFin = LocalDate.of(2026, 6, 25);
        bandera = habitacionSuite.estaDisponible(fechaInicio, fechaFin);
        if (!bandera) {            
        System.out.println("La habitación no se encuentra disponible");
        }        
        gestorReservas.realizarReserva(cliente_2, habitacionSuite, fechaInicio, fechaFin);
        

        System.out.println("********* Reservas realizadas ***********");
        gestorReservas.listarReservas();


        System.out.println("********* Puntos de clientes ***********");
        System.out.println("Jorge: " + cliente_1.getPuntos());
        System.out.println("Maria: " + cliente_2.getPuntos());


    }

    public static GestorDisponibilidad getGestorDisp() {
        return gestorDisp;
    }

    public static GestorReservas getGestorRes() {
        return gestorReservas;
    }

}
