import java.util.Arrays;

public class Bender {

    // DECLAREM VARIABLES DE CLASE
    char[][] plano;
    int iniciX = 0;
    int iniciY = 0;
    int finalX = 0;
    int finalY = 0;
    int numTele = 0;
    int[][] cordTele;
    String resultat = "";
    Transportador[] transportador;

    //Constructor que utilitza Robot i Item per heretar.
    public Bender(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano,int[][] cordTele,Transportador[] transportador) {
        this.plano = plano;
        this.iniciX = iniciX;
        this.iniciY = iniciY;
        this.finalX = finalX;
        this.finalY = finalY;
        this.resultat = resultat;
        this.cordTele = cordTele;
        this.transportador = transportador;

    }

    public Bender() {
    }

    public static void main(String[] args) {
        String mapa =  "" +
                "###########\n" +
                "#         #\n" +
                "#  ########\n" +
                "#$        #\n" +
                "#   X     #\n" +
                "# #####  T#\n" +
                "#       ###\n" +
                "#         #\n" +
                "###########";

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
        //Crear un mapa de items de les mateixes dimensions que el mapa de caracters
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

        //calcula la cantidad de transportador
        int ntele =cercaCantidadTele();
        //cordTele = arrayTele;
        numTele = ntele;

        // Arrays de cordenades Teletransportador('T')
        cordTele = new int[ntele][2];
        int teleX;
        int teleY;
        //Cridam a la funcio que pasant el planol torna un array amb les cordenades.

        // Cream un array de Objectes Transportador
        Transportador[] transportador = new Transportador[numTele];
        

        int[][] cordTeleT = trobarItems(plano, cordInicial,cordFinal,cordTele);
        cordTele = cordTeleT;

        //Bucle per crear els objectes Transportador,
        // i assignar valors x i y a cada transportador.
        for (int i = 0; i < cordTele.length; i++) {
           int telx= cordTele[i][0];
           int telY =cordTele[i][1];
           transportador[i] = new Transportador(telx,telY);
        }


        /*
        for (int i = 0; i < cordTele.length; i++) {
            //proba
           // transportador = new Transportador[]{new Transportador(cordTele[i][0], cordTele[i][1])};
            teleX = cordTele[i][0];
            teleY = cordTele[i][1];
            transportador[i] = new Transportador(teleX, teleY);
        }


         */





        //System.out.println(cordTele[0][0] + cordTele[0][1] );

        //int[][] cordTele = trobarItems(plano, cordInicial,cordFinal);

        iniciX = cordInicial[0];
        iniciY = cordInicial[1];
        finalX = cordFinal[0];
        finalY = cordFinal[1];


/*
        //Guardar les cordenades de el nombre de teletransportadors
        for (int i = 0; i < cordTele.length; i++) {
                teleX = cordTele[i][0];
                teleY = cordTele[i][1];
                transportador[i] = new Transportador(teleX, teleY);

        }


 */


        //String resultat="";

        //Cream el Robot i li pasa, les cordenades inicials.
        Robot robot = new Robot(iniciX,iniciY,finalX,finalY,resultat,plano,cordTele,transportador);

        System.out.println("X :" + iniciX + "| Y =  "+ iniciY);
        System.out.println(" final X :" + finalX + "| final  Y =  "+ finalY);

        int llargY = plano.length;
        int llargX = plano[0].length;
        System.out.println("Llarg de Y" + llargY  + " ||  Llarg de X :" + llargX );


        System.out.println(Arrays.toString(cordInicial));


        return robot.walk();
    }

    private int cercaCantidadTele() {

        for (int posFila = 0; posFila < plano.length; posFila++) {
            for (int posCol = 0; posCol < plano[posFila].length; posCol++) {
                if (plano[posFila][posCol] == 'T'){
                    numTele++;
                }
            }
        }
        return numTele;
    }
    public int[][] trobarItems(char[][] plano, int[] cordInicial, int[] cordFinal, int[][] cordTele) {
        // Primer bucle yPos es la fila
        //Contador per sebre el numero de Transportador que hem trobat.
        int contemp =0;
        for (int posFila = 0; posFila < plano.length; posFila++) {
            //Segon bucle per trobar la cordenada X columna
            for (int posCol = 0; posCol < plano[posFila].length; posCol++) {
                if (plano[posFila][posCol] =='X') {
                    cordInicial[0] = posCol;
                    cordInicial[1] = posFila;

                }
                if (plano[posFila][posCol] == '$') {
                    // Guarda la posicio X
                    cordFinal[0] = posCol;
                    // Guarda la posicio Y
                    cordFinal[1] = posFila;

                    //per deixar de recorre el mapa i optimitzar el programa.
                }
                if (plano[posFila][posCol] == 'T') {
                    // Guarda la posicio X
                    cordTele[contemp][0] = posCol;
                    // Guarda la posicio Y
                    cordTele[contemp][1] = posFila;
                    //Aumenta el contador temporal per pasar a la següent posicio de el array,
                    // ja que es un nou transportador i se guardara a una fila diferent.
                    contemp++;
                }



            }
        }
        return cordTele;
    }
    int bestRun() {
        return 0;
    }
}

