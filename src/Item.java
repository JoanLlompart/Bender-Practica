public class Item extends Bender{
    //item no es un Robot

   // public final char[][] plano;
    //private final int[] cordInicial;
   // private final int[] cordFinal;


    public Item(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano,int[][] cordTele) {
        super(iniciX, iniciY, finalX, finalY, resultat, plano,cordTele);
    }

}
/*
class ParetItem extends Item {

    public ParetItem(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano, char[][] plano1, int[] cordInicial, int[] cordFinal) {
        super(iniciX, iniciY, finalX, finalY, resultat, plano, plano1, cordInicial, cordFinal);
    }
}


class ObjectiuItem extends Item{
/*
    public ObjectiuItem(char[][] plano, int[] cordInicial, int[] cordFinal) {
        super(plano, cordInicial, cordFinal);
    }

    //trobar el '$'

    // Primer bucle yPos es la fila

    for (int posFila = 0; posFila < plano.length; posFila++) {
        //Segon bucle per trobar la cordenada X columna
        for (int posCol = 0; posCol < plano[posFila].length; posCol++) {
            if (plano[posFila][posCol] =='X') {
                cordInicial[0] = posFila;
                cordInicial[1] = posCol;
                //return cordInici;
            }
            if (plano[posFila][posCol] == '$') {
                int[] cordFinal = new int[2];
                cordFinal[0] = posFila;
                cordFinal[1] = posCol;
                //per deixar de recorre el mapa i optimitzar el programa.
                break;
            }
        }
    }



 */

//}
/*
class ComençaItem extends Item {
    //posicio inicial de el robot




}
class Inversor extends Item {


}


 */

class Transportador {

    private int x;
    private int y;
    private static int[][] coordenadas;

   public Transportador(int x,int y) {
       this.x = x;
        this.y = y;

    }
    public void setCoordenadas(int[][] coordenadas) {
        //coordenadas = array;
        for (int i = 0; i < coordenadas.length; i++) {
            coordenadas[i][0] = x;
            coordenadas[i][0] = y;
        }

    }

    public static int[][] getCoordenadas() {
        return coordenadas;
    }

    /*
    public Transportador calcularMasCercano(){
        Transportador masCercano = null;
        double distanciaMasCercana = Double.MAX_VALUE;
        for (int i = 0; i < coordenadas.length; i++) {
            int x2 = coordenadas[i][0];
            int y2 = coordenadas[i][1];
            double distancia = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
            if (distancia < distanciaMasCercana) {
                distanciaMasCercana = distancia;
                masCercano = new Transportador(x2, y2);
            }
        }
        return masCercano;
    }


     */

    /*public int trobarTele(int numTele, int[][] cordTele) {


        for (int posFila = 0; posFila < plano.length; posFila++) {
            //Segon bucle per trobar la cordenada X columna
            for (int posCol = 0; posCol < plano[posFila].length; posCol++) {
                if (plano[posFila][posCol] == 'T') {
                    // Guarda la posicio X
                    cordTele[numTele][0] = posCol;
                    // Guarda la posicio Y
                    cordTele[numTele][1] = posFila;
                    //Num de els teletransportadors que tenim
                    numTele++;
                    //Item tele = new Transportador(iniciX,iniciY,finalX,finalY,resultat,plano);
                }
            }

        }
        return numTele;
    }


     */
}


