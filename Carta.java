public class Carta {
  //Clase que modela un objeto carta
  private int valor;
  
  public Carta()
  {
      
      
  }
  
  public int getValor() {
    return valor;
  }

  public Figura getFigura() {
    return figura;
  }
  private Figura figura;
  
  public boolean compararFigura(Carta otraCarta)
  {
      boolean esIgual = false;
      
      if(this.figura == otraCarta.getFigura())
       {
           esIgual = true;
       }
       
       return esIgual;
  }
  
  //Compara una carta(del objeto actual) con otra carta. Regresára x valor dependiendo de la comparación.
  public int compareTo(Carta otraCarta)
    {
       int resultado;
       if(this.valor > otraCarta.getValor())
       {
           resultado = 1;
       }
       else if(this.valor < otraCarta.getValor())
       {
           resultado = -1;
       }
       else
       {
           resultado = 0;
       }
       
       return resultado;
    }
  
  public Color getColor() {
    return((figura == Figura.CORAZONES || figura == Figura.DIAMANTES)? Color.ROJO : Color.NEGRO);
  }

  public Carta(int valor, Figura figura) throws FueraDeRangoException{
    if(valor <1 || valor > 13)
      throw new FueraDeRangoException("Valor "+valor+ " fuera de rango");
    this.valor = valor;
    this.figura = figura;
  }

  public Carta(String valor, Figura figura) throws FueraDeRangoException{
    valor = valor.toUpperCase();
    if(!valor.equals("K") && !valor.equals("Q") && !valor.equals("J") && !valor.equals("A"))
      throw new FueraDeRangoException("Cadena \""+valor+ "\" fuera de rango");
    this.valor = (valor.equals("K")?13:valor.equals("Q")?12:valor.equals("J")?11:1);
    this.figura = figura;
  }

  @Override
  public String toString() {
    String valorStr= String.valueOf(this.valor);
    if( valor == 1) valorStr = "A";
    if( valor == 11) valorStr = "J";
    if( valor == 12) valorStr = "Q";
    if( valor == 13) valorStr =  "K";
    
    return valorStr+" "+this.figura;
  }

}
