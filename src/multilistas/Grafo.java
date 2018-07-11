/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilistas;

/**
 *
 * @author D&S2
 */
public class Grafo {

    private Vertice inicio = new Vertice();
    private Vertice fin = new Vertice();

    public Grafo() {
        inicio = null;
        fin = null;
    }

    public void insertarVertice(int dato) {
        Vertice nuevo = new Vertice(dato);
        Vertice aux = inicio;

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (inicio.getSig() == null) {
                if (inicio.getDato() == nuevo.getDato()) {
                    inicio = nuevo;
                    fin = nuevo;
                } else {
                    inicio.setSig(nuevo);
                    fin = nuevo;
                }
            } else {
                if (buscarVer(dato) != null) {
                    aux = buscarVer(dato);
                    Vertice aux2 = inicio;

                    if (aux.getSig() == null) {
                        aux2.setSig(nuevo);
                        fin = nuevo;
                    } else {
                        if (aux == inicio) {
                            nuevo.setSig(aux.getSig());
                        } else {
                            do {
                                if (aux2.getSig() != aux) {
                                    aux2 = aux2.getSig();
                                }
                            } while (aux2.getSig() != aux);

                            aux2.setSig(nuevo);
                            nuevo.setSig(aux.getSig());
                        }
                    }
                } else {
                    fin.setSig(nuevo);
                    fin = nuevo;
                }
            }
        }
    }

    //Metodo de busqueda de un vertice especifico, o si no se encuentra
    private Vertice buscarVer(int valor) {
        Vertice aux = inicio;
        boolean com = false;

        do {
            if (aux.getDato() == valor) {
                com = true;
            } else {
                aux = aux.getSig();
            }
        } while (aux != null && com != true);

        if (com == false) {
            aux = null;
        }

        return aux;
    }

    public void insertarArista(int valorOrigen, int valorDestino) {
        Vertice origen = buscarVer(valorOrigen);
        Vertice destino = buscarVer(valorDestino);
        boolean aristaCreada;

        //Ve si ambos vertices existen
        if (buscarVer(valorOrigen) != null && buscarVer(valorDestino) != null) {

            if (comprobarArista(origen, valorDestino) == false) {
                aristaCreada = origen.insertarArista(valorDestino);

                if (aristaCreada == true) {
                    System.out.println("\n _________________________________________");
                    System.out.println("|                                         |");
                    System.out.println("| Se creo exitosamente la arista: (" + valorOrigen + " , " + valorDestino + ") |");
                    System.out.println("|_________________________________________|");
                } else {
                    System.out.println("\n ______________________________________________");
                    System.out.println("|                                              |");
                    System.out.println("| Ocurrio un error, la arista no se pudo crear |");
                    System.out.println("|______________________________________________|");
                }
            } else {
                System.out.println("\n _______________________________________");
                System.out.println("|                                       |");
                System.out.println("| La arista (" + valorOrigen + " , " + valorDestino + " ) ya se habia creado |");
                System.out.println("|_______________________________________|");
            }
        } else {
            System.out.println("\n _____________________________________________");
            System.out.println("|                                             |");
            System.out.println("| Alguno de las vertices, o ambas. NO EXISTEN |");
            System.out.println("|_____________________________________________|");
        }
    }

    //Metodo para saber si la arista ya fue creada, anteriormente 
    private boolean comprobarArista(Vertice origen, int valorDestino) {
        Arista aux = origen.getCabArista();
        boolean com = false;

        if (origen.getCabArista() != null) {
            do {
                if (aux.getDatoDest() == valorDestino) {
                    com = true;
                } else {
                    aux = aux.getSig();
                }
            } while (aux != null && com == false);
        }

        return com;
    }

    public void imprimir(int recibe) {
        Vertice aux = buscarVer(recibe);

        if (aux != null) {
            System.out.println("\n _______________________________");
            System.out.println("|                               |");
            System.out.println("|  IMPRESION DE LA MULTI-LISTA  |");
            Cola cola = new Cola();
            Cola colaOpcional = new Cola();
            cola.add((int) aux.getDato());
            colaOpcional.add((int) aux.getDato());
            Nodo recorreCola = new Nodo();
            Arista aris = new Arista();
            Nodo imprime = new Nodo();

            recorreCola = cola.getInicioCola();
            if (aux.getCabArista() == null) {
                do {
                    imprime = cola.atender();
                    System.out.println("|         VERTICE:    " + imprime.getDato() + "         |");
                    recorreCola = recorreCola.getSig();
                } while (recorreCola != cola.getFinCola());
            } else {
                boolean com = false;
                //Agrega los valores a la cola, pasando por cada vertice
                do {
                    aux = buscarVer(recorreCola.getDato());
                    aris = aux.getCabArista();

                    //Recorre cada arista que se conecta a un vertice especifico
                    if (aris != null) {
                        do {
                            if (vecticeIgualEnCola(aris, colaOpcional) == false) {
                                cola.add(aris.getDatoDest());
                                colaOpcional.add(aris.getDatoDest());
                            }
                            aris = aris.getSig();
                        } while (aris != null);
                    }

                    imprime = cola.atender();
                    System.out.println("|         VERTICE:    " + imprime.getDato() + "         |");
                    recorreCola = recorreCola.getSig();
                } while (recorreCola != null);
            }
            System.out.println("|_______________________________|");
        } else {
            System.out.println("\n _______________________________________");
            System.out.println("|                                       |");
            System.out.println("| El vertice con el cual desea imprimir |");
            System.out.println("|              NO EXISTE                |");
            System.out.println("|_______________________________________|");
        }

    }

    private boolean vecticeIgualEnCola(Arista aris, Cola colaOpcional) {
        boolean comprobar = false;

        Nodo reco = colaOpcional.getInicioCola();

        do {
            if (reco.getDato() == aris.getDatoDest()) {
                comprobar = true;
            } else {
                reco = reco.getSig();
            }
        } while (reco != null && comprobar != true);

        return comprobar;
    }

}
