public class Robot extends Bender {

    // hem de guardar la posicio inicial.
    public Robot(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano, int[][] cordTele,Transportador[] transportador) {
        //Constructor crida a el contructor de Bender
        super(iniciX, iniciY, finalX, finalY, resultat, plano,cordTele,transportador);
    }


    //Orientacions (S,E,N,W)
    enum Orientacio {
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
    boolean haArribat = haArribat(iniciY, iniciX, finalY, finalX);

    public boolean haArribat(int iniciY, int iniciX, int finalY, int finalX) {
        return finalY == iniciY && finalX == iniciX;
    }


    private void canviSentit(int iniciY, int iniciX, Orientacio orientacio) {

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
    public String walk() {
        //ha de cambiar la seva posicio si pot.
        // si la posicio esta lliure podem avançar i cambiara la posicio de X i Y.

        //El enum direccio de tipus Orientacio sempre començara per el sud.
        Orientacio direccio = Orientacio.S;

        // Si el inversor esta activat altera el ordre de les prefrencias de direccio.
        //ordre Inversor N,W,S,E
        boolean inversor = false;
        while (!haArribat) {
            // El probrama cada vegada que troba una paret ha de tornar a comensar el ordre cap el sur.


            if (direccio == Orientacio.S) {
                //Si troba un inversor el la seguent casella
                if (plano[iniciY + 1][iniciX] =='I') {
                    //Si el inversor ja esta activat se ha de desactivar.
                    if (inversor== true) {
                        inversor = false;
                    }else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    }
                }
                //S
                if (plano[iniciY + 1][iniciX] =='T') {
                    //Troba un Transportador
                    //transportador= new Transportador[]{calcularMasCercano()};
                    //Transportador transportadorActual = new Transportador(iniciX, iniciY+1);
                    //transportador= new Transportador[]{trobaTeleProper(transportador,transportadorActual)};
                    //Transportador transportador1 = trobaTeleProper(transportador,transportadorActual);
                    iniciY++;
                    resultat += Orientacio.S.name();
                    viatgeAmbTransportador();
                   // iniciY++;
                   // resultat += Orientacio.S.name();
                    //break;

                }
                // TROBA PARET
                if (plano[iniciY + 1][iniciX] == '#') {
                    //Si troba una paret i el inversor esta activat cambia tot el ordre
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, iniciY, iniciX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si hi ha una paret a la seguent posicio cambia de sentit
                        Orientacio novaDireccio = potAnarDireccio(plano, iniciY, iniciX, direccio);
                        direccio = novaDireccio;
                    }

                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    iniciY++;
                    resultat += Orientacio.S.name();
                }
            }

            if (direccio == Orientacio.E) {
                if (plano[iniciY][iniciX+1] =='I') {
                    if (inversor== true) {
                        inversor = false;
                    }else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    };
                }
                //EAST
                if (plano[iniciY][iniciX+1] =='T') {
                    //Troba un Transportador
                    //Transportador transportar= calcularMasCercano();
                    //System.out.println(transportar + "Est transport");
                    //Transportador transportadorActual = new Transportador(iniciX+1, iniciY);
                    //transportador= new Transportador[]{trobaTeleProper(transportador,transportadorActual)};

                    //Avançam la posicio per entrar al transportador
                    iniciX++;
                    resultat += Orientacio.E.name();
                    viatgeAmbTransportador();

                    //break;
                }
                if (plano[iniciY][iniciX + 1] == '#') {
                    //Si troba una paret i el inversor esta activat cambia tot el ordre
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, iniciY, iniciX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si hi ha una paret a la seguent posicio cambia de sentit
                        Orientacio novaDireccio = potAnarDireccio(plano, iniciY, iniciX, direccio);
                        direccio = novaDireccio;
                    }

                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    iniciX++;
                    resultat += Orientacio.E.name();
                }
            }

            //NORTH
            if (direccio == Orientacio.N) {
                if (plano[iniciY -1][iniciX] =='I') {
                    if (inversor== true) {
                        inversor = false;
                    }else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    }
                }

                if (plano[iniciY - 1][iniciX] =='T') {
                    //Troba un Transportador
                    //Transportador transportar= calcularMasCercano();
                    //System.out.println(transportar + "North transport");

                    //Transportador transportadorActual = new Transportador(iniciX, iniciY-1);
                    //transportador= new Transportador[]{trobaTeleProper(transportador,transportadorActual)};

                    //Avançam la posicio per entrar al transportador
                    iniciY--;
                    resultat += Orientacio.N.name();

                    viatgeAmbTransportador();

                   // break;
                }
                if (plano[iniciY - 1][iniciX] == '#') {
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, iniciY, iniciX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si hi ha una paret a la seguent posicio cambia de sentit
                        Orientacio novaDireccio = potAnarDireccio(plano, iniciY, iniciX, direccio);
                        direccio = novaDireccio;
                    }

                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    iniciY--;
                    resultat += Orientacio.N.name();
                }
            }

            if (direccio == Orientacio.W) {

                if (plano[iniciY][iniciX-1] =='I') {
                    if (inversor== true) {
                        inversor = false;
                    }else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    }
                }
                //WEST
                if (plano[iniciY][iniciX-1] =='T') {
                    //Troba un Transportador
                    // Ja ha de estar creat i se ha de implementar una funcio que calculi la distancia
                    // amb el teorema de pitagoras

                    //implementar el constructor
                   // Transportador transportar= calcularMasCercano();
                   // System.out.println(transportar + "west transport");
                    //Transportador transportadorActual = new Transportador(iniciX, iniciY);
                    //transportador= new Transportador[]{trobaTeleProper(transportador,transportadorActual)};

                    //Avançam la posicio per entrar al transportador
                    iniciX--;
                    resultat += Orientacio.W.name();
                    viatgeAmbTransportador();


                }
                if (plano[iniciY][iniciX - 1] == '#') {
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, iniciY, iniciX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si hi ha una paret a la seguent posicio cambia de sentit
                        Orientacio novaDireccio = potAnarDireccio(plano, iniciY, iniciX, direccio);
                        direccio = novaDireccio;
                    }

                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    iniciX--;
                    resultat += Orientacio.W.name();
                }
            }


            if ((plano[iniciY][iniciX] == '$')) {
                //Si la seguent posiucio es '$' avança i afegeix la direccio a resulat.
                haArribat = true;
            }
        }

        return resultat;

    }

    public void viatgeAmbTransportador() {
        Transportador  transportadorActual = new Transportador(iniciX,iniciY);
        for (int i = 0; i < cordTele.length; i++) {
            int x2 = cordTele[i][0];
            int y2 = cordTele[i][1];
            if (iniciX != x2 && iniciY != y2 ) {
                iniciX = x2;
                iniciY = y2;
                break;
            } else {
                //trobaTeleProper(transportador,transportadorActual);
                //throw new RuntimeException("NO SE POT TELETRANSPORTAR PER ARA");
            }
        }
    }

    public Orientacio potAnarDireccio(char[][] plano, int iniciY, int iniciX, Orientacio direccio) {
        // Si hi ha una paret a la seguent posicio, busca primer cap al sud

        //ordre S,E,N,W
        if (plano[iniciY + 1][iniciX] != '#') {
            return direccio = Orientacio.S;
        } else if (plano[iniciY][iniciX + 1] != '#') {
            return direccio = Orientacio.E;
        } else if (plano[iniciY - 1][iniciX] != '#') {
            return direccio = Orientacio.N;

        } else if (plano[iniciY][iniciX - 1] != '#') {
            return direccio = Orientacio.W;
        }
        return direccio;
    }

    public Orientacio direccioInversa (char[][] plano, int iniciY, int iniciX, Orientacio direccio) {
        // Si hi ha una paret a la seguent posicio, busca primer cap al sud

        //ordre N,W,S,E
        if (plano[iniciY - 1][iniciX] != '#') {
            return direccio = Orientacio.N;
        } else if (plano[iniciY][iniciX - 1] != '#') {
            return direccio = Orientacio.W;
        } else if (plano[iniciY + 1][iniciX] != '#') {
            return direccio = Orientacio.S;
        } else if (plano[iniciY][iniciX + 1] != '#') {
            return direccio = Orientacio.E;
        }
        return direccio;
    }









   /* public Transportador calcularMasCercano(){
        Transportador masCercano = null;
        double distanciaMasCercana = Double.MAX_VALUE;
        for (int i = 0; i < cordTele.length; i++) {
            int x2 = cordTele[i][0];
            int y2 = cordTele[i][1];
            double distancia = Math.sqrt(Math.pow(x2 - iniciX, 2) + Math.pow(y2 - iniciY, 2));
            if (distancia < distanciaMasCercana) {
                distanciaMasCercana = distancia;
                masCercano = new Transportador(x2, y2);
            }
        }
        return masCercano;
    }

    */

/*
        } else if (orientacio == orientacio.E) {
            //EST
            if (plano[iniciY][iniciX + 1] == '#') {
                //Si esta amb una paret canvi de sentit
                direccio = orientacio.N;

            } else if (plano[iniciY][iniciX + 1] == ' ') {
                //Si esta buit podem seguir caminant cap aquella direccio
                iniciX++;
                resultat += orientacio.E.name();

            } else if ((plano[iniciY][iniciX + 1] == '$')) {
                //Si la seguent posiucio es '$' avança i afegeix la direccio a resulat.

                iniciX++;
                resultat += orientacio.E.name();
                return resultat;
            }

        } else if (orientacio == orientacio.N) {
            //N
            if (plano[iniciY - 1][iniciX] == '#') {
                direccio = orientacio.W;

            } else if ((plano[iniciY - 1][iniciX] == ' ')) {
                //Si esta buit podem seguir caminant cap aquella direccio
                iniciY--;
                resultat += orientacio.N.name();


            } else if ((plano[iniciY - 1][iniciX] == '$')) {
                //Si la seguent posiucio es '$' avança i afegeix la direccio a resulat.

                iniciY--;
                resultat += orientacio.N.name();
                return resultat;
            }

        } else if (orientacio == orientacio.W) {
            //W
            if (plano[iniciY][iniciX - 1] == '#') {
                direccio = orientacio.S;

            } else if (plano[iniciY][iniciX - 1] == ' ') {
                //Si esta buit podem seguir caminant cap aquella direccio
                iniciX--;
                resultat += orientacio.W.name();

            } else if ((plano[iniciY][iniciX - 1] == '$')) {
                //Si la seguent posiucio es '$' avança i afegeix la direccio a resulat.

                iniciX--;
                resultat += orientacio.W.name();
                return resultat;
            }
 */

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
    private void canviOrientacio(Orientacio direccio, int cont) {
        if (cont == 4) {
            cont = 0;
        }
        switch (cont) {
            case 0:
                direccio = Orientacio.S;
                break;
            case 1:
                direccio = Orientacio.E;
                break;
            case 2:
                direccio = Orientacio.N;
                break;
            case 3:
                direccio = Orientacio.W;
                break;
        }
    }
}



