package es.deusto.ingenieria.spq.sudoku.client.data;

import es.deusto.ingenieria.spq.sudoku.client.data.exceptions.CeldaInicialException;
import es.deusto.ingenieria.spq.sudoku.client.data.exceptions.SudokuException;
import es.deusto.ingenieria.spq.sudoku.client.data.exceptions.ValorErroneoException;

public class Sudoku
{
    private Tabla tabla;
    private Tabla solucion;
    private int nivel;
    private int numeroErrores;

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
    public void setValor(int i, int j, int n) throws SudokuException {
        if(!tabla.getCelda(i, j).isInicial())//Comprobamos que no sea una casilla inicial
        {
            if(solucion.getCelda(i, j).getNumero()==n){//Comprobamos si al introducir un número en una casilla no inicial se ha producido un error con la solución
                //Comprobado ya todo que es correcto introducimos el valor
                tabla.setCelda(solucion.getCelda(i, j), i, j);
            }
            else
            {
                numeroErrores++;
                throw new ValorErroneoException(i, j, n, solucion.getCelda(i, j).getNumero());
            }
        }
        else
        {
            throw new CeldaInicialException(i, j);
        }
    }
}
