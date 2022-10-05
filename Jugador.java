import java.util.ArrayList;
//Clase que modela un jugadir para el juego
public class Jugador
{
    private int puntuacion;
    private ArrayList <Carta> mano;
    
    public Jugador()
    {
       puntuacion = 0;
       mano = new ArrayList();
    }
    
    //Tiene a su mano un mazo de 5 cartas
    public void darleMazoDe5(Baraja baraja)
    {
        mano = baraja.repartir(5);
    }
    
    public int getTamanoMazo()
    {
        return mano.size();
    }
    
    public void mostrarMazo()
    {
        int i2 = 1;
        for(int i = 0;i<mano.size();i++)
        {
            System.out.println(i2 + ". " + mano.get(i));
            i2++;
        }
        
    }
    
    public Carta obtenerCartaSeleccionada(int posicion, Carta cartaObtenida)
    {
        //Debido que las opciones de seleccionar carta son de 1-5, se le resta
        //la opcion por -1 para que se seleccione la posición de manera correcta
        posicion = posicion - 1;
        cartaObtenida = mano.remove(posicion);
        return cartaObtenida;
    }
    
    public int getPuntuacion()
    {
        return puntuacion;
    }
    
    public void setPuntuacion(int puntuacion)
    {
        this.puntuacion+= puntuacion;        
    }
    
}
