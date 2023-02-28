import java.util.Arrays;

public class Bender {

    char[][] plano;
    int iniciX = 0;
    int iniciY = 0;
    int finalX = 0;
    int finalY = 0;
    String resultat = "";

    public Bender(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano) {
        this.plano = plano;
        this.iniciX = iniciX;
        this.iniciY = iniciY;
        this.finalX = finalX;
        this.finalY = finalY;
        this.resultat = resultat;
    }

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


        String[][] plano = new String[][]{mapa.split("\n")};
        for (int y = 0;y  < plano.length; y++) {
            for (int x = 0; x < plano[y].length; x++) {
                //Un bucle per cada posicio de X i el altre per Y
                System.out.println(Arrays.toString(plano[y][x].toCharArray()));
            }
        }






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

        iniciX = cordInicial[0];
        iniciY = cordInicial[1];
        finalX = cordFinal[0];
        finalY = cordFinal[1];
        //String resultat="";

        //Cream el Robot i li pasa, les cordenades inicials.
        Robot robot = new Robot(iniciX,iniciY,finalX,finalY,resultat,plano);


/*
        boolean comparacion = haArribat(iniciY, iniciX, finalY, finalX);

        while (plano[iniciY][iniciX] != '#' || comparacion){
            iniciY += 1;
            resultat += "S";
        }


 */




        System.out.println("X :" + iniciX + "| Y =  "+ iniciY);

        System.out.println(" final X :" + finalX + "| final  Y =  "+ finalY);

        //ObjectiuItem objectiu = new ObjectiuItem();
        int llargY = plano.length;
        int llargX = plano[0].length;
        System.out.println("Llarg de Y" + llargY  + " ||  Llarg de X :" + llargX );




        System.out.println(Arrays.toString(cordInicial));

        return robot.walk();
    }

    private void trobaPosInicial(char[][] plano, int[] cordInicial,int[] cordFinal) {
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

   /* private boolean haArribat(int y1, int x1, int y2, int x2) {
        return y2 == y1 && x2 == x1;

    }

    */

    int bestRun() {


        return 0;
    }
}