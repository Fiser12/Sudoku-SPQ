package controller;

/**
 * Created by Fiser on 25/2/15.
 */
public class Celda {
    private int numero;
    public Celda(){
        numero = 0;
    }
    public Celda(int num)
    {
        numero = num;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String toString(){
        return ""+this.numero;
    }
    public boolean equals(int numero)
    {
        return numero == this.numero;
    }
}
