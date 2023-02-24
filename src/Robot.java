public class Robot {
    Robot (int x,int y) {
        this.x = x;
        this.y = y;
    }
    // hem de guardar la posicio inicial.
    int posInicial;
    int x;
    int y;

    //Orientacions (S,E,N,W)
    enum orientacio {
        SUD,
        EAST,
        NORTH,
        WEST;
    }

    //char sud = 'S';

    //char east = 'E';

    //char north = 'N';

   // char west = 'W';
    boolean haArribat = false;

    void walk() {
        //ha de cambiar la seva posicio si pot.
        // si la posicio esta lliure podem avançar i cambiara la posicio de X i Y.



    }

}
