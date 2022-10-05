//Clase que lleva la parte lógica y funcional del juego
public class CardShark{
    
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Baraja b;
    private Carta cartaj1;
    private Carta cartaj2;
    private Carta cartaj3;
    private IUCardShark iu;

    public CardShark()
    {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        jugador3 = new Jugador();
        cartaj1 = new Carta();
        cartaj2 = new Carta();
        cartaj3 = new Carta();
    }
    
    public void iniciarJuego() 
    {
        iu = new IUCardShark();
        b = new Baraja();
        b.barajar();
        repartirCartas();
        
        //Los mazos de los jugadores deben quedar vacios para que finalize el juego.
        //Todos los jugadores tienen la misma cantidad de cartas.
        while(jugador1.getTamanoMazo() != 0)
        {
            iniciarRonda();
            mostrarCartasLanzadas();
            compararCartas();
        }
        comprobarGanador();
        iu.mostrarPuntuaciones(jugador1,jugador2,jugador3);
    }
    
    public void repartirCartas()
    {
        jugador1.darleMazoDe5(b);
        jugador2.darleMazoDe5(b);
        jugador3.darleMazoDe5(b);
    }
  
    public void iniciarRonda()
    {
        System.out.println("\nJugador 1");
        cartaj1 = iu.lanzarCartas(jugador1);
        System.out.println("\nJugador 2");
        cartaj2 = iu.lanzarCartas(jugador2);
        System.out.println("\nJugador 3");
        cartaj3 = iu.lanzarCartas(jugador3);
    }
    
    public void mostrarCartasLanzadas()
    {
        System.out.println("Cartas tiradas:");
        System.out.println(cartaj1.toString());
        System.out.println(cartaj2.toString());
        System.out.println(cartaj3.toString()); 
    }
    
    //Comparación de las cartas tiradas
    public void compararCartas()
    {
        if(cartaj1.compareTo(cartaj2) > 0 && cartaj1.compareTo(cartaj3) > 0)
        {
            jugador1.setPuntuacion(2);
            System.out.println("\nEl jugador 1 gana esta ronda");
    
        }
        else if(cartaj2.compareTo(cartaj1) > 0 && cartaj2.compareTo(cartaj3) > 0)
        {
            jugador2.setPuntuacion(2);  
            System.out.println("\nEl jugador 2 gana esta ronda");
            
        }
        else if(cartaj3.compareTo(cartaj1) > 0 && cartaj3.compareTo(cartaj2) > 0)
        {
            jugador3.setPuntuacion(2);
            System.out.println("\nEl jugador 3 gana esta ronda");
            
        }
        else
        {   System.out.println("\nEmpataron en puntuación");
            System.out.println("Se vuelve a lanzar una carta\n");
            
            
            iniciarRonda();
            
            if(cartaj1.compareTo(cartaj2) > 0 && cartaj1.compareTo(cartaj3) > 0)
            {
                jugador1.setPuntuacion(2);
                System.out.println("\nEl jugador 1 gana esta ronda");
                
            }
            else if(cartaj2.compareTo(cartaj1) > 0 && cartaj2.compareTo(cartaj3) > 0)
            {
                jugador2.setPuntuacion(2);  
                System.out.println("\nEl jugador 2 gana esta ronda");
                
            }
            else if(cartaj3.compareTo(cartaj1) > 0 && cartaj3.compareTo(cartaj2) > 0)
            {
                jugador3.setPuntuacion(2);
                System.out.println("\nEl jugador 3 gana esta ronda");
                
            }
            else
            {
                jugador1.setPuntuacion(1);
                jugador2.setPuntuacion(1);
                jugador3.setPuntuacion(1);
                System.out.println("\nLos jugadores volvieron a empatar, todos ganan 1 punto");
            }
        
        }
        
        
    }
    
    //Determina el ganador al final del juego
    public void comprobarGanador()
    {
        if(jugador1.getPuntuacion() > jugador2.getPuntuacion() && jugador1.getPuntuacion() > jugador3.getPuntuacion())
        {
            System.out.println("\n¡El jugador 1 es el ganador!");            
        }
        else if(jugador2.getPuntuacion() > jugador1.getPuntuacion() && jugador2.getPuntuacion() > jugador3.getPuntuacion())
        {
            System.out.println("\n¡El jugador 2 es el ganador!");   
        }
        else if(jugador3.getPuntuacion() > jugador1.getPuntuacion() && jugador3.getPuntuacion() > jugador1.getPuntuacion())
        {
            System.out.println("\n¡El jugador 3 es el ganador!");   
        }
        else
        {
            System.out.println("\nHubo empate");
        }
  
    }
    
}
