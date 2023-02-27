import java.util.Arrays;

public class Bender {

    char[][] plano;

    public static void main(String[] args) {
        String mapa = "" +
                "#######\n" +
                "# X   #\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "# $   #\n" +
                "#     #\n" +
                "#######";

        Bender b = new Bender(mapa);
        System.out.println(b);

/*
        String[][] plano = new String[][]{mapa.split("\n")};
        for (int y = 0;y  < plano.length; y++) {
            for (int x = 0; x < plano[y].length; x++) {
                //Un bucle per cada posicio de X i el altre per Y
                System.out.println(Arrays.toString(plano[y][x].toCharArray()));
            }
        }


 */



    }
    //Hem de pasar el mapa a array bidimensional

    //per cada linea

    //String[][] planol= new String[][]{mapa.split("\n")};


    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        //ha de estar declarada com a variable de clase
        //planol= new String[][]{mapa.split("\n")};
        String[] posicio = mapa.split("\n");
        int filasN = posicio.length;
        int colN = posicio[0].length();
        plano = new char[filasN][colN];


        //Rellena el Array amb els valors de el String
        for (int Fila = 0; Fila < posicio.length; Fila++) {
            for (int Col = 0; Col < posicio[Fila].length(); Col++) {
                //Un bucle per cada posicio de Y i el altre per X
                plano[Fila][Col] = posicio[Fila].charAt(Col);
            }
        }
    }



    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir
    // els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.

    public String run() {


        //Antes de crear el robot hem de sebre quina posicio inicial te en el mapa
        //Bucle que averigua la posicio inicial

        // Arrays de cordenades Inicial('X')
        int[] cordInicial = new int[2];

        // Arrays de cordenades final('$')
        int[] cordFinal = new int[2];

        //Cridam a la funcio que pasant el planol torna un array amb les cordenades.
        trobaPosInicial(plano, cordInicial,cordFinal);

        int iniciX = cordInicial[0];
        int iniciY = cordInicial[1];
        int finalX = cordFinal[0];
        int finalY = cordFinal[1];
        String resultat="";

        //Cream el Robot i li pasa, les cordenades inicials.
        Robot robot = new Robot(iniciX,iniciY,finalX,finalY,resultat,plano);


/*
        boolean comparacion = haArribat(iniciY, iniciX, finalY, finalX);

        while (plano[iniciY][iniciX] != '#' || comparacion){
            iniciX += 1;
            resultat += "S";
        }


 */


        System.out.println("X :" + iniciX + "| Y =  "+ iniciY);

        System.out.println(" final X :" + finalX + "| final  Y =  "+ finalY);

        //ObjectiuItem objectiu = new ObjectiuItem();


        System.out.println(Arrays.toString(cordInicial));


        //Cream un item
        //Item item = new Item();

        //return resultat;

        //return new Bender();

        return resultat;
    }

    private void trobaPosInicial(char[][] plano, int[] cordInicial,int[] cordFinal) {
/*        // Buscar dentro de mapaChars donde esta la X
        // (doble for)
        int pix = 0;
        int piy = 0;
        int p$x = 0;
        int p$y = 0;
        String resultado = "";
        for (int i = 0; i < mapaChars.length; i++) { //fila
            for (int j = 0; j < mapaChars[0].length; j++) { // columna
                if (mapaChars[i][j] == 'X'){
                    pix = j;                //guarda la coordenada i fila
                    piy = i;                //guarda la coordenada j columna
                    System.out.println(mapaChars[i][j]);
                    System.out.println("x" + pix  + " " + "y" + piy);
                }
                if (mapaChars[i][j] == '$'){
                    p$x = j;                //guarda la coordenada i fila
                    p$y = i;                //guarda la coordenada j columna

                    System.out.println(mapaChars[i][j]);
                    System.out.println(p$x + " " + p$y);
                }
            }
        }
        boolean comparacion = comparacion(piy, pix, p$y, p$x);
        while (mapaChars[piy][pix] != '#' || comparacion){
            pix += 1;
            resultado += "S";
        }
        while (mapaChars[piy][pix] != '#' ){

        }

 */


        String resultat="";

        // Primer bucle yPos es la fila
        for (int posFila = 0; posFila < plano.length; posFila++) {
            //Segon bucle per trobar la cordenada X columna
            for (int posCol = 0; posCol < plano[posFila].length; posCol++) {
                if (plano[posFila][posCol] =='X') {
                    cordInicial[0] = posCol;
                    cordInicial[1] = posFila;

                    //return cordInici;
                }
                if (plano[posFila][posCol] == '$') {
                    cordFinal[0] = posCol;
                    cordFinal[1] = posFila;

                    //per deixar de recorre el mapa i optimitzar el programa.
                    break;
                }
            }
        }
    }

    private boolean haArribat(int y1, int x1, int y2, int x2) {
        return y2 == y1 && x2 == x1;

    }

    int bestRun() {


        return 0;
    }
}