public class FueraDeRangoException extends Exception {
//Para que no se supere el limite a entregar m�s de 5 cartas a los jugadores
  public FueraDeRangoException(String message) {
    super(message);
  }
  
}
