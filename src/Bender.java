import java.util.Arrays;

public class Bender {
    public static void main(String[] args) {
       /* Bender b = new Bender("\"\" +\n" +
                "                \"#######\\n\" +\n" +
                "                \"# X   #\\n\" +\n" +
                "                \"#     #\\n\" +\n" +
                "                \"#     #\\n\" +\n" +
                "                \"#     #\\n\" +\n" +
                "                \"# $   #\\n\" +\n" +
                "                \"#     #\\n\" +\n" +
                "                \"#######\"");


        */
        String mapa = "" +
                "#######\n" +
                "# X   #\n" +
                "#     #\n" +
                "#     #\n" +
                "#     #\n" +
                "# $   #\n" +
                "#     #\n" +
                "#######";


        String[][] planol= new String[][]{mapa.split("\n")};
        for (int i = 0; i < planol.length; i++) {
            for (int j = 0; j < planol[i].length; j++) {
                //Un bucle per cada posicio de X i el altre per Y
                System.out.println(Arrays.toString(planol[i][j].toCharArray()));
            }
        }

        


    }
/*
    String mapa = "" +
            "#######\n" +
            "# X   #\n" +
            "#     #\n" +
            "#     #\n" +
            "#     #\n" +
            "# $   #\n" +
            "#     #\n" +
            "#######";;

 */
    //Hem de pasar el mapa a array bidimensional

    //per cada linea

    //String[][] planol= new String[][]{mapa.split("\n")};



        // Constructor: ens passen el mapa en forma d'String
        public Bender(String mapa) {
            //String[][] planol= new String[][]{mapa.split("\n")};



        }
        // Navegar fins a l'objectiu («$»).
        // El valor retornat pel mètode consisteix en una cadena de
        // caràcters on cada lletra pot tenir
        // els valors «S», «N», «W» o «E»,
        // segons la posició del robot a cada moment.
        public String run() {

            return null; }

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