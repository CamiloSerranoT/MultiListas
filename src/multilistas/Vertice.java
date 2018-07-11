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
public class Vertice {

    private int dato;
    private Vertice sig;
    private Arista cabArista;
    private Arista finArista;

    public Vertice() {
        sig = null;
        cabArista = null;
        finArista = null;
    }

    public Vertice(int dato) {
        this.dato = dato;
        this.sig = null;
        this.cabArista = null;
        this.finArista = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Vertice getSig() {
        return sig;
    }

    public void setSig(Vertice sig) {
        this.sig = sig;
    }

    public Arista getCabArista() {
        return cabArista;
    }

    public void setCabArista(Arista cabArista) {
        this.cabArista = cabArista;
    }

    public Arista getFinArista() {
        return finArista;
    }

    public void setFinArista(Arista finArista) {
        this.finArista = finArista;
    }

    public boolean insertarArista(int valorDestino) {
        Arista nuevo = new Arista(valorDestino);
        Arista aux = cabArista;
        boolean aristaCreada = false;

        if (cabArista == null) {
            cabArista = nuevo;
            finArista = nuevo;
            aristaCreada = true;
        } else {
            if (cabArista.getSig() == null) {
                cabArista.setSig(nuevo);
                finArista = nuevo;
            } else {
                finArista.setSig(nuevo);
                finArista = nuevo;
            }
            aristaCreada = true;
        }

        return aristaCreada;
    }

}
