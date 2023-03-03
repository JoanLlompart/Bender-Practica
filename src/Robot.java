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
    boolean haArribat = haArribat(iniciY, iniciX, finalY, finalX);

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

       orientacio direccio=orientacio.S;

       while (!haArribat) {

           orientacio orientacio = Robot.orientacio.S;

           if (orientacio ==orientacio.S) {
               //S
               if (plano[iniciY+1][iniciX] == '#') {
                   // Si hi ha una paret a la seguent posicio cambia de sentit
                   direccio= orientacio.E;
               } else if ((plano[iniciY+1][iniciX] == ' ')) {
                   //Si esta buit podem seguir caminant cap aquella direccio
                   iniciY++;
                   resultat += orientacio.S.name();

                  /* while (direccio == orientacio.S){
                   }

                   */

               } else if ((plano[iniciY+1][iniciX] == '$')) {
                   iniciY++;
                   resultat += orientacio.S.name();
                   return resultat;
               }

              // iniciY++;


           } else if (orientacio ==orientacio.E) {
               //EST
               if (plano[iniciY][iniciX+1] == '#') {
                   direccio= orientacio.N;


               }

           } else if (orientacio ==orientacio.N) {
               //N
               if (plano[iniciY-1][iniciX] == '#') {
                   direccio= orientacio.W;

               }


           }else if (orientacio ==orientacio.W) {
               //W
               if (plano[iniciY][iniciX-1] == '#') {
                   direccio= orientacio.S;
               }


           }


       }



/*
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
           //ha de cambiar comprobar antes de caminar si pot avançar i si
           //pot avança, si no ,torna a cambiar la direccio
           if(plano[iniciY][iniciX] =='#') {
               //Amb el contador cridarem a una funcio amb un switch canviOrientacio que fara que avansi segons
               // la preferencia de el programa
               //canviSentit(iniciY,iniciX,orientacio.E);
               cont++;
               canviOrientacio(iniciY,iniciX,cont);
           } else if (comparacion){
               return resultat;

           } else {
               canviOrientacio(iniciY,iniciX,cont);
               break;

           }
           //iniciX += 1;
           //resultat += orientacio.E.name();
       }


 */

//------------------------------------------------------------
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
        //int[] camina = new int[2];
        switch (cont) {
            case 0:
                iniciY++;
                //Y++;
                resultat += orientacio.S.name();
                break;
            case 1:
                iniciX += 1;
                //X++;
                resultat += orientacio.E.name();
                break;
            case 2:
                iniciY -= 1;
                //Y--;
                resultat += orientacio.N.name();
                break;
            case 3:
                resultat += orientacio.W.name();
                iniciX -= 1;
                //X++;
                break;
        }
       // camina[0] = iniciX;
        //camina[1] = iniciY;
        //return camina;
    }



}
