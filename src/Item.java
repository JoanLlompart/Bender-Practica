public class Item extends Robot{
    //item no es un Robot

   // public final char[][] plano;
    //private final int[] cordInicial;
   // private final int[] cordFinal;



    public Item(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano) {
        super(iniciX, iniciY, finalX, finalY, resultat, plano);
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

class Transportador extends Item {

    public Transportador(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano) {
        super(iniciX, iniciY, finalX, finalY, resultat, plano);
    }


}


