package controller;

/**
 * Created by Fiser on 25/2/15.
 */
public class Sudoku
{
    private Tabla tabla;
    private Tabla solucion;
    private int nivel;
    private Tabla destino;

    public Sudoku(int nivel)
    {
        this.nivel = nivel;
        generarTabla();
        generarSolucion();
    }
    private void generarTabla()
    {
        Generator generator = new Generator();
        generator.generateBoard(this.nivel);
        this.tabla = generator.getTabla();

    }
    private void generarSolucion()
    {
        Tabla solveBoard = new Tabla();
        solveBoard.copy(this.tabla);
        solveBoard.reset();
        Solver solver = new Solver(solveBoard);
        solver.solveBoard();
        this.solucion = solver.getBoard();
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
    public void showEjercicio()
    {
        tabla.printBoard();
    }
    public void showSolucion()
    {
        solucion.printBoard();
    }
}
