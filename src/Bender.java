public class Bender {

    // DECLAREM VARIABLES DE CLASE
    char[][] plano;
    int robotX = 0;
    int robotY = 0;
    int finalX = 0;
    int finalY = 0;
    int numTele = 0;
    int[][] cordTele;
    String resultat = "";
    Transportador[] transportador;

    //Constructor que utilitza Robot i Item per heretar.
    public Bender(int robotX, int robotY, int finalX, int finalY, String resultat, char[][] plano, int[][] cordTele, Transportador[] transportador) {
        this.plano = plano;
        this.robotX = robotX;
        this.robotY = robotY;
        this.finalX = finalX;
        this.finalY = finalY;
        this.resultat = resultat;
        this.cordTele = cordTele;
        this.transportador = transportador;

    }

    //Constructor que utilitzam per la classe Item.
    public Bender() {
    }

    public static void main(String[] args) {
        String mapa = "" +
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

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        //ha de estar declarada com a variable de clase
        String[] posicio = mapa.split("\n");

        int logitudMapa = posicio[0].length();
        //determinar la longitut de la fila mes curta del mapa
        for (int i = 0; i < posicio.length - 1; i++) {
            if (logitudMapa > posicio[i + 1].length()) {
                logitudMapa = posicio[i].length();
            } else {
                logitudMapa = posicio[i + 1].length();
            }

        }
        //determina la distancia de el planol per casos
        // de mapas de longitut irregulars.
        plano = new char[posicio.length][logitudMapa];


        for (int i = 0; i < posicio.length; i++) {
            //Un bucle per cada posicio de Y i el altre per X
            plano[i] = posicio[i].toCharArray();
        }

       /* int filasN = posicio.length;
        int colN = posicio[0].length();
        plano = new char[filasN][colN];

        */
/*
        //Rellena el Array amb els valors de el String
        for (int Fila = 0; Fila < posicio.length; Fila++) {
            for (int Col = 0; Col < posicio[Fila].length(); Col++) {
                //Un bucle per cada posicio de Y i el altre per X
                plano[Fila][Col] = posicio[Fila].charAt(Col);
            }
        }

 */

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
        int ntele = cercaCantidadTele();
        //cordTele = arrayTele;
        numTele = ntele;

        // Arrays de cordenades Teletransportador('T')
        cordTele = new int[ntele][2];


        //Cridam a la funcio que pasant el planol torna un array amb les cordenades.

        // Cream un array de Objectes Transportador
        Transportador[] transportador = new Transportador[numTele];

        //Crida a la funci que guarda les cordenades de inici, les de final, i els tranportadors.
        trobarItems(plano, cordInicial, cordFinal, cordTele);

        //Bucle per crear els objectes Transportador,
        // i assignar valors x i y a cada transportador.
        for (int i = 0; i < cordTele.length; i++) {
            int telx = cordTele[i][0];
            int telY = cordTele[i][1];
            transportador[i] = new Transportador(telx, telY);

        }

        //Bucle per guardar dins cada Transportador les coordenades de el mes proxim.
        for (int i = 0; i < cordTele.length; i++) {
            Transportador t = trobaTeleProper(transportador, transportador[i]);
            transportador[i].xMesProper = t.x;
            transportador[i].yMesProper = t.y;

        }
        //Treim els valors de els arrays i les pasam a variables,
        // robotX i robotY marcara el punt de partida de el Robot per començar a moure en el mapa.
        robotX = cordInicial[0];
        robotY = cordInicial[1];
        finalX = cordFinal[0];
        finalY = cordFinal[1];


        //Cream el Robot i li pasa, les cordenades inicials.
        Robot robot = new Robot(robotX, robotY, finalX, finalY, resultat, plano, cordTele, transportador);
        return robot.walk();
    }

    // Funcio que troba el nombre de 'T' que hi ha a plano per saber la longitut de el Array de Transportadors.
    private int cercaCantidadTele() {
        for (int posFila = 0; posFila < plano.length; posFila++) {
            for (int posCol = 0; posCol < plano[posFila].length; posCol++) {
                if (plano[posFila][posCol] == 'T') {
                    numTele++;
                }
            }
        }
        return numTele;
    }

    public void trobarItems(char[][] plano, int[] cordInicial, int[] cordFinal, int[][] cordTele) {
        // Primer bucle yPos es la fila
        //Contador per sebre el numero de Transportador que hem trobat.
        int contemp = 0;
        for (int posFila = 0; posFila < plano.length; posFila++) {
            //Segon bucle per trobar la cordenada X columna
            for (int posCol = 0; posCol < plano[posFila].length; posCol++) {
                if (plano[posFila][posCol] == 'X') {
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
    }

/*
    public Transportador trobaTeleProper(Transportador[] transportador, Transportador transportadorActual) {
        double distanciaMinima = Double.MAX_VALUE;
        Transportador transportadorMasCercano = null;

        // forEach fa referencia a el array de Transportador
        for (Transportador t : transportador) {
            if (t != transportadorActual) {
                double distancia = calcularDistancia(t, transportadorActual);
                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    transportadorMasCercano = t;
                }
                if (distancia == distanciaMinima) {
                    //calcular distancia amb producte euclania que vagi en el sentit de les agulles de el rellotge
                    for (int i = 0; i < transportador.length; i++) {
                        //comparar x i segueix el ordre de el array per trobarlo.
                      transportador[i].x = transportadorActual.x;
                    }

                }
            }
        }
        // Actualitza el transportador actual per el mes proper
       // transportadorActual = transportadorMasCercano;

        return transportadorMasCercano;
    }


 */


    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public Transportador trobaTeleProper(Transportador[] transportadores, Transportador transportadorActual) {
        double distanciaMinima = Double.MAX_VALUE;
        double radiMenor = Double.MAX_VALUE;
        Transportador transportadorMesProper = null;

        // Calcula la posición del transportador actual
        double xActual = transportadorActual.getX();
        double yActual = transportadorActual.getY();

        for (Transportador t : transportadores) {
            if (t != transportadorActual) {
                double distancia = calcularDistancia(t, transportadorActual);
                double radi = calcularRadi(xActual, yActual, t.getX(), t.getY());

                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    radiMenor = radi;
                    transportadorMesProper = t;
                } else if (distancia == distanciaMinima && radi < radiMenor) {
                    radiMenor = radi;
                    transportadorMesProper = t;
                }
            }
        }
        return transportadorMesProper;
    }
    private double calcularDistancia(Transportador t1, Transportador t2) {
        double dx = t1.getX() - t2.getX();
        double dy = t1.getY() - t2.getY();
        //pitagores per comparar les distancies entre el transportador actual i els altres de el array.
        return Math.sqrt(dx * dx + dy * dy);
    }

    private double calcularRadi(double xActual, double yActual, double xDestino, double yDestino) {
        double dx = xDestino - xActual;
        double dy = yDestino - yActual;
        return dx != 0 ? dy / dx : Double.MAX_VALUE;
    }
    int bestRun() {
        return 0;
    }
}

