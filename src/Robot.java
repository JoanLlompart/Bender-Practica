public class Robot extends Bender {

    // hem de guardar la posicio inicial.
    public Robot(int iniciX, int iniciY, int finalX, int finalY, String resultat, char[][] plano, int[][] cordTele, Transportador[] transportador) {
        //Constructor crida a el contructor de Bender
        super(iniciX, iniciY, finalX, finalY, resultat, plano, cordTele, transportador);
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

    // haArribat variable boolean.
    boolean haArribat = haArribat(robotY, robotX, finalY, finalX);

    public boolean haArribat(int iniciY, int iniciX, int finalY, int finalX) {
        return finalY == iniciY && finalX == iniciX;
    }

    public String walk() {
        //ha de cambiar la seva posicio si pot.
        // si la posicio esta lliure podem avançar i cambiara la posicio de X i Y.

        //El enum direccio de tipus Orientacio sempre començara per el sud.
        Orientacio direccio = Orientacio.S;

        // Si el inversor esta activat altera el ordre de les prefrencias de direccio.
        //ordre Inversor N,W,S,E
        boolean inversor = false;

        //contador que evita els bucles infinits aturat a les 10.000 pasades
        int contadorMaxIntents = 0;

        while (!haArribat) {
            //aumentam el contador casa iteracio de el bucle.
            contadorMaxIntents++;

            //Sud
            if (contadorMaxIntents == 10000) return null;
            // El probrama cada vegada que troba una paret ha de tornar a comensar el ordre cap el sur.
            if (direccio == Orientacio.S) {
                //Si troba un inversor el la seguent casella
                if (plano[robotY + 1][robotX] == 'I') {
                    //Si el inversor ja esta activat se ha de desactivar.
                    if (inversor == true) {
                        inversor = false;
                    } else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    }
                }
                //Sud
                if (plano[robotY + 1][robotX] == 'T') {
                    //Troba un Transportador
                    robotY++;
                    resultat += Orientacio.S.name();
                    viatgeAmbTransportador();
                    // iniciY++;
                    // resultat += Orientacio.S.name();
                    //break;

                }
                // TROBA PARET
                if (plano[robotY + 1][robotX] == '#') {
                    //Si troba una paret i el inversor esta activat cambia tot el ordre
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, robotY, robotX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si hi ha una paret a la seguent posicio cambia de sentit
                        Orientacio novaDireccio = potAnarDireccio(plano, robotY, robotX, direccio);
                        direccio = novaDireccio;
                    }

                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    robotY++;
                    resultat += Orientacio.S.name();
                }
            }

            if (direccio == Orientacio.E) {
                if (plano[robotY][robotX + 1] == 'I') {
                    //Si esta activat el inversor i troba un altre se desactivara i
                    // tornara al sentit normal
                    if (inversor == true) {
                        inversor = false;
                    } else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    }
                    ;
                }
                //EAST
                if (plano[robotY][robotX + 1] == 'T') {
                    //Avançam la posicio per entrar al transportador
                    robotX++;
                    resultat += Orientacio.E.name();

                    viatgeAmbTransportador();

                    //break;
                }
                if (plano[robotY][robotX + 1] == '#') {
                    //Si troba una paret i el inversor esta activat cambia tot el ordre
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, robotY, robotX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si hi ha una paret a la seguent posicio cambia de sentit
                        Orientacio novaDireccio = potAnarDireccio(plano, robotY, robotX, direccio);
                        direccio = novaDireccio;
                    }

                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    robotX++;
                    resultat += Orientacio.E.name();
                }
            }

            //NORTH
            if (direccio == Orientacio.N) {
                if (plano[robotY - 1][robotX] == 'I') {
                    //Si esta activat el inversor i troba un altre se desactivara i
                    // tornara al sentit normal
                    if (inversor == true) {
                        inversor = false;
                    } else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    }
                }

                if (plano[robotY - 1][robotX] == 'T') {
                    //Troba un Transportador
                    //Avançam la posicio per entrar al transportador
                    robotY--;
                    resultat += Orientacio.N.name();
                    viatgeAmbTransportador();

                }
                if (plano[robotY - 1][robotX] == '#') {
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, robotY, robotX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si hi ha una paret a la seguent posicio cambia de sentit
                        Orientacio novaDireccio = potAnarDireccio(plano, robotY, robotX, direccio);
                        direccio = novaDireccio;
                    }
                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    robotY--;
                    resultat += Orientacio.N.name();
                }
            }

            if (direccio == Orientacio.W) {
                if (plano[robotY][robotX - 1] == 'I') {
                    if (inversor) {
                        inversor = false;
                    } else {
                        //Si el inversor no esta activat el activam.
                        //Activa boolean inversor
                        inversor = true;
                    }
                }
                //WEST
                if (plano[robotY][robotX - 1] == 'T') {
                    //Troba un Transportador
                    // Ja ha de estar creat i se ha de implementar una funcio que calculi la distancia
                    // amb el teorema de pitagoras
                    //Avançam la posicio per entrar al transportador
                    robotX--;
                    resultat += Orientacio.W.name();
                    //pasa a la posicio de el transportador mes proxim de el actual
                    viatgeAmbTransportador();


                }
                if (plano[robotY][robotX - 1] == '#') {
                    if (inversor) {
                        Orientacio novaInversa = direccioInversa(plano, robotY, robotX, direccio);
                        direccio = novaInversa;

                    } else {
                        // Si el inversor es false segueix amb el sentit normal
                        // Si hi ha una paret a la seguent posicio cambia de sentit

                        Orientacio novaDireccio = potAnarDireccio(plano, robotY, robotX, direccio);
                        direccio = novaDireccio;
                    }

                } else {
                    //Si esta buit podem seguir caminant cap aquella direccio
                    robotX--;
                    resultat += Orientacio.W.name();
                }
            }


            if ((plano[robotY][robotX] == '$')) {
                //Si la seguent posiucio es '$' avança i afegeix la direccio a resulat.
                haArribat = true;
            }
        }

        return resultat;

    }

    public void viatgeAmbTransportador() {

        for (int i = 0; i < transportador.length; i++) {
            //Si la posicio actual consideix amb la posicio de algun transportador entra perque ha trobat el transportador Actual
            // i aixi podrem accedir a la posicions xMesProper i yMesProper de aquest perque es teletransporti.
            if (transportador[i].x == robotX && transportador[i].y == robotY) {
                // Canviam els valors de iniciX i iniciY per els de el transportador mes proxim.
                robotX = transportador[i].xMesProper;
                robotY = transportador[i].yMesProper;
                break;
            }
        }
    }

    public Orientacio potAnarDireccio(char[][] plano, int iniciY, int iniciX, Orientacio direccio) {
        // Si hi ha una paret a la seguent posicio, busca primer cap al sud

        //ordre S,E,N,W

        if (plano[iniciY + 1][iniciX] != '#') {
            //si la següent posicio se pot anara a el sud, anar a el sud,
            return direccio = Orientacio.S;
        } else if (plano[iniciY][iniciX + 1] != '#') {
            // segona preferencia es el est
            return direccio = Orientacio.E;
        } else if (plano[iniciY - 1][iniciX] != '#') {
            //tercera preferencia es el nord
            return direccio = Orientacio.N;

        } else if (plano[iniciY][iniciX - 1] != '#') {
            // cuarta preferencia es el oest
            return direccio = Orientacio.W;
        }
        return direccio;
    }

    public Orientacio direccioInversa(char[][] plano, int iniciY, int iniciX, Orientacio direccio) {
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

}



