public class Transportador extends Bender {

    int x;
    int y;
    int xMesProper;
    int yMesProper;

    public Transportador(int x, int y, int xMesProper, int yMesProper) {
        this.x = x;
        this.y = y;
        this.xMesProper = xMesProper;
        this.yMesProper = yMesProper;

    }

    //Contructor que guarda x i y
    public Transportador(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}


