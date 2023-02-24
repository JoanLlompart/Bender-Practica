import java.util.Arrays;

public class Bender {

    char[][] planol;

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
        planol = new char[filasN][colN];


        //Rellena el Array amb els valors de el String
        for (int x = 0; x < posicio.length; x++) {
            for (int y = 0; y < posicio[x].length(); y++) {
                //Un bucle per cada posicio de X i el altre per Y
                planol[x][y] = posicio[x].charAt(y);
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
        trobaPosInicial(planol, cordInicial);
        System.out.println(Arrays.toString(cordInicial));

        Robot robot = new Robot(cordInicial[0], cordInicial[1]);



        return null;
    }

    private int[] trobaPosInicial(char[][] planol, int[] cord) {

        for (int xPos = 0; xPos < planol.length; xPos++) {
            for (int yPos = 0; yPos < planol[xPos].length; yPos++) {
                if (planol[xPos][yPos] =='X') {
                    System.out.println("ha entrat");
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