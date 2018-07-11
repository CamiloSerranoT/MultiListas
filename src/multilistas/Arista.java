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
public class Arista {

    private int datoDest;
    private Arista sig;

    public Arista() {
        sig = null;
    }

    public Arista(int datoDest) {
        this.datoDest = datoDest;
        this.sig = null;
    }

    public int getDatoDest() {
        return datoDest;
    }

    public void setDatoDest(int datoDest) {
        this.datoDest = datoDest;
    }

    public Arista getSig() {
        return sig;
    }

    public void setSig(Arista sig) {
        this.sig = sig;
    }

}
