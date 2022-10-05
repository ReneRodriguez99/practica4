import java.util.Scanner;
public class IUCardShark
{
    private CardShark juego;
    
    public IUCardShark()
    {
        
    }
    
    public void iniciarJuego()
    {
        juego = new CardShark();
        juego.iniciarJuego();
    }
    
    //Envia las cartas seleccionadas al juego
    public Carta lanzarCartas(Jugador jugador)
    {
       Scanner scan = new Scanner(System.in);
       int op;
       System.out.println("Seleccione una carta (seleccione la posicion de la carta): ");
       jugador.mostrarMazo();
       op = scan.nextInt();
       
       Carta carta = new Carta();       
       
       carta = jugador.obtenerCartaSeleccionada(op,carta);
        
       return carta;
    }
    
    //mostrar puntuaciones de los jugadores en la interfaz
    public void mostrarPuntuaciones(Jugador jugador1,Jugador jugador2, Jugador jugador3)
    {
        System.out.println("\nPuntuación de jugadores");
        System.out.println("Jugador 1: " + jugador1.getPuntuacion());
        System.out.println("Jugador 2: " + jugador2.getPuntuacion());
        System.out.println("Jugador 3: " + jugador3.getPuntuacion());
    }
    
}
