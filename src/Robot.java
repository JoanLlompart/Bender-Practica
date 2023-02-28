public class Robot extends Bender{

    /*
    private int iniciX = 0;
    private int iniciY = 0;
    private int finalX = 0;
    private int finalY = 0;
    private String resultat = "";
    private char[][] plano;



     */



    // hem de guardar la posicio inicial.
    public Robot(int iniciX, int iniciY, int finalX, int finalY, String resultat,char[][] plano) {
        super(iniciX,iniciY,finalX,finalY,resultat,plano);
    }


    //Orientacions (S,E,N,W)
    enum orientacio {
        // SUD
        S,
        //EAST
        E,
        // NORTH
        N,

        //WEST
        W;
    }

    //char sud = 'S';

    //char east = 'E';

    //char north = 'N';

   // char west = 'W';


    // haArribat variable boolean.
    //boolean haArribat = false;
    boolean comparacion = haArribat(iniciY, iniciX, finalY, finalX);

    public boolean haArribat(int iniciY, int iniciX, int finalY, int finalX) {
        return finalY == iniciY && finalX == iniciX;
    }




    private void dirreccions(int iniciY, int iniciX,orientacio orientacio) {

        switch (orientacio) {
            case S -> iniciY += 1;
            case E -> iniciX += 1;
            case N -> iniciY -= 1;
            case W -> iniciX -= 1;
        }
    }

    public String  walk() {
        //ha de cambiar la seva posicio si pot.
        // si la posicio esta lliure podem avançar i cambiara la posicio de X i Y.
       int cont =0;
       if (finalX==iniciX) {
           while (!(iniciY ==finalY)) {
               iniciY++;
               resultat += orientacio.S.name();
           }
       }
       while (plano[iniciY][iniciX] == '#') {

       }


        /*while (plano[iniciY][iniciX] != '#'|| comparacion){
                iniciY += 1;
                resultat += orientacio.S.name();
        }

         */




        /*while (plano[iniciY][iniciX] == '#'){
            // Prioritats S (South), E (East), N (North), W (West).

        }

         */
        return resultat;
    }

}
