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




    private void canviSentit(int iniciY, int iniciX,orientacio orientacio) {

        switch (orientacio) {
            case S:
                iniciY += 1;
                resultat += orientacio.S.name();
                break;
            case E:
                iniciX++;
                resultat += orientacio.E.name();
                break;
            case N:
                iniciY -= 1;
                resultat += orientacio.N.name();
                break;
            case W:
                resultat += orientacio.W.name();
                iniciX -= 1;
                break;

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
               //canviSentit(iniciY,iniciX,orientacio.S);
               //resultat += orientacio.S.name();
           }
       }
       if (finalY==iniciY) {
            while (!(iniciX ==finalX)) {
                iniciX++;
                resultat += orientacio.E.name();
            }
       }


       //Si no consideix cap cordenada.

       while (!comparacion) {
           //canviOrientacio(iniciY,iniciX,cont);
           if(plano[iniciY][iniciX] =='#') {
               //Amb el contador cridarem a una funcio amb un switch canviOrientacio que fara que avansi segons
               // la preferencia de el programa
               //canviSentit(iniciY,iniciX,orientacio.E);
               cont++;
               canviOrientacio(iniciY,iniciX,cont);
           } else {
               System.out.println("Seguir mateixa direcció ");
               break;
           }
           //iniciX += 1;
           //resultat += orientacio.E.name();


       }

     /*  while (plano[iniciY][iniciX] != '#') {
           canviSentit(iniciY,iniciX,orientacio.E);
           if (plano[iniciY][iniciX] =='#') {
               canviSentit(iniciY,iniciX,orientacio.N);
           }


       }

      */


     /*   while (plano[iniciY][iniciX] != '#'|| comparacion){
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

    private void canviOrientacio(int iniciY, int iniciX, int cont) {
        switch (cont) {
            case 0:
                iniciY++;
                resultat += orientacio.S.name();
                break;
            case 1:
                iniciX += 1;
                resultat += orientacio.E.name();
                break;
        }
    }

}
