package controller;

/**
 * Created by Fiser on 25/2/15.
 */
public class Sudoku
{
    private Tabla tabla;
    private Tabla solucion;
    private int nivel;
    public Sudoku(int nivel)
    {
        this.nivel = nivel;
        generarTabla();
        generarSolucion();
    }
    private void generarTabla()
    {

    }
    private void generarSolucion()
    {

    }
    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public Tabla getSolucion() {
        return solucion;
    }

    public void setSolucion(Tabla solucion) {
        this.solucion = solucion;
    }
    public boolean estaResuelto()
    {
        return this.tabla.equals(solucion);
    }
    public void resolver()
    {
        this.tabla = this.solucion;
    }
}
