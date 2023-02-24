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

        /*
        String[][] planol = new String[][]{mapa.split("\n")};
        for (int i = 0; i < planol.length; i++) {
            for (int j = 0; j < planol[i].length; j++) {
                //Un bucle per cada posicio de X i el altre per Y
                System.out.println(Arrays.toString(planol[i][j].toCharArray()));
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
        for (int x = 0; x < posicio.length; x++) {
            for (int y = 0; y < posicio[x].length(); y++) {
                //Un bucle per cada posicio de X i el altre per Y
                plano[x][y] = posicio[x].charAt(y);
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

        int[] cordInicial = new int[2];
        //Cridam a la funcio que pasant el planol torna un array amb les cordenades.
        trobaPosInicial(plano, cordInicial);
        System.out.println(Arrays.toString(cordInicial));

        //Cream el Robot i li pasa, les cordenades inicials.
        Robot robot = new Robot(cordInicial[0], cordInicial[1]);


        //Cream un item
        Item item = new Item();

        return null;
    }

    private int[] trobaPosInicial(char[][] planol, int[] cord) {
/*
// Buscar dentro de mapaChars donde esta la X
        // (doble for)
        int pix = 0;
        int piy = 0;
        int p$x = 0;
        int p$y = 0;
        String resultado = null;
        int posRobot = 0;
        for (int i = 0; i < mapaChars.length; i++) {
            for (int j = 0; j < mapaChars[0].length; j++) {
                if (mapaChars[i][j] == 'X'){
                    pix = i;
                    piy = j;
                    System.out.println(mapaChars[i][j]);
                    System.out.println(pix + " " + piy);
                }
                if (mapaChars[i][j] == '$'){
                    p$x = i;
                    p$y = j;
                    System.out.println(mapaChars[i][j]);
                }
            }
        }

        boolean comparacion = comparacion(piy, pix, p$y, p$x);
        while (mapaChars[piy][pix] != '#' || !comparacion){
            piy += 1;
            resultado += "S";

        }
 */
        for (int xPos = 0; xPos < planol.length; xPos++) {
            for (int yPos = 0; yPos < planol[xPos].length; yPos++) {
                if (planol[xPos][yPos] =='X') {
                    cord[0] = xPos;
                    cord[1] = yPos;
                    return cord;
                }
            }
        }

        return null;
    }

    int bestRun() {


        return 0;
    }


    /*
    //Constructor
    String mapa ="";
    Bender(String mapa){

    }

    String run(){

        return null;
    };
    int bestRun() {
        return 0;
    }
    public static void main(String[] args) {

    }

     */
}