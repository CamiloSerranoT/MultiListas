/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilistas;

/**
 *
 * @author CAMILO
 */
public class Cola {

    private Nodo inicioCola;
    private Nodo finCola;

    public Cola() {
        inicioCola = null;
        finCola = null;
    }

    public Nodo getInicioCola() {
        return inicioCola;
    }

    public void setInicioCola(Nodo inicioCola) {
        this.inicioCola = inicioCola;
    }

    public Nodo getFinCola() {
        return finCola;
    }

    public void setFinCola(Nodo finCola) {
        this.finCola = finCola;
    }

    public void add(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (inicioCola == null) {
            inicioCola = nuevo;
            finCola = nuevo;
        } else {
            finCola.setSig(nuevo);
            finCola = nuevo;
        }
    }

    public Nodo atender() {
        Nodo aux = new Nodo();

        if (inicioCola.getSig() == null || inicioCola == null) {
            aux = inicioCola;
            inicioCola = null;
            finCola = null;
        } else {
            aux = inicioCola;
            inicioCola = inicioCola.getSig();
        }

        return aux;
    }

}
