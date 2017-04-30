package pgn.poo.examenMarzo2017.estructuras;

import java.util.ArrayList;
import java.util.ListIterator;

import pgn.poo.examenMarzo2017.jerarquiaFiguras.Circulo;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.FigurasCerradas;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.TrianguloRectangulo;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.FiguraNoExisteException;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.FiguraYaExisteException;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.ListaVaciaException;
import pgn.poo.utiles.Menu;
import pgn.poo.utiles.Teclado;


/**
 * Clase envoltorio de un arrayList de Figuras Cerradas
 * 
 * @author Guillermo
 * @version 2.0
 */
public class Figuritas {
	
	/**
	 * Envoltorio de un arrayList de figuras
	 */
	private ArrayList<FigurasCerradas> figuritas;
	private Menu menuBorrar;

	public Figuritas() {
		figuritas = new ArrayList<FigurasCerradas>();
	}
	
	/**
	 *Metodo que permite annadir figuras. 
	 * @param figuras figuras cerradas
	 * @throws FiguraYaExisteException si la figura existe
	 */
	public void add(FigurasCerradas figuras) throws FiguraYaExisteException {
		if (figuritas.contains(figuras))
			throw new FiguraYaExisteException("Error al annadir, la figura ya existe");
		figuritas.add(figuras);
	}
	
	/**
	 * Metodo que permite generar un numero de manera aleatoria
	 * @return numero aleatorio
	 */
	public double generarAleatorio() {
		return Math.random();
	}
	
	/**
	 * Metodo que permite borrado por id
	 * @param id identificador de la figura
	 * @throws FiguraNoExisteException si la figura no existe
	 */
	public void removeid(int id) throws FiguraNoExisteException {

		try {
			if (figuritas.remove(new Circulo(id)))
				;
			System.out.println("Eliminada la figura con id " + id);
		} catch (IndexOutOfBoundsException e) {
			throw new FiguraNoExisteException("ERROR al eliminar la figura");
		}

	}
	
	/**
	 * Metodo que permite borrar por indice
	 * @throws FiguraNoExisteException
	 */
	public void removeIndex() throws FiguraNoExisteException {
		int indice;
		do {
			menuBorrar = new Menu("** Elige una de las figuras a borrar", generarOpcionesPorFiguras());
			indice = menuBorrar.gestionar();
			remove(indice);
		} while (indice != menuBorrar.SALIR && continuar("¿Desea eliminar otra figura? S/N"));
	}

	/**
	 * 	Metodo que permite generar opciones a partir del total de las figuras existentes
	 * @return opciones, opciones generadas
	 */
	public String[] generarOpcionesPorFiguras() {
		String[] opciones = new String[figuritas.size()];
		for (int i = 0; i < figuritas.size(); i++) {
			opciones[i] = figuritas.get(i).toString();
		}
		return opciones;
	}

	/**
	 * Metodo que permite el borrado por indice
	 * @param indice indice por el que se realiza el borrad
	 * @throws FiguraNoExisteException si la figura no existe
	 */
	private void remove(int indice) throws FiguraNoExisteException {

		try {
			FigurasCerradas figura = figuritas.get(indice - 1);
			if (figuritas.remove(figura))
				System.out.println("Eliminada:\n" + figura);
		} catch (IndexOutOfBoundsException e) {
			throw new FiguraNoExisteException("ERROR al eliminar la figura");
		}
	}

	/**
	 * Metodo que permite continuar o no en funcion de la opcion
	 * @param mensaje mensaje a mostrar al usuario
	 * @return true o false en funcion de la eleccion
	 */
	private static boolean continuar(String mensaje) {
		switch (Teclado.leerCaracter(mensaje)) {
		case 'N':
		case 'n':
			return false;
		default:
			return true;
		}
	}

	
	/**
	 * Metodo que permite recorrer al reves la lista de figuras
	 * @return
	 * @throws ListaVaciaException
	 */
	public StringBuilder listarFigurasInverso() throws ListaVaciaException {
		StringBuilder cadena = new StringBuilder();

		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista esta vacia");

		ListIterator<FigurasCerradas> it = figuritas.listIterator(figuritas.size());
		while (it.hasPrevious()) {
			FigurasCerradas m = it.previous();
			if (m instanceof Object)
				cadena.append(" \n" + m);
		}

		return cadena;

	}

	/**
	 * Metodo que permite contar el numero de triangulos que hay
	 * 
	 * @throws ListaVaciaException si la lista esta vacia
	 */
	public void contarTriangulos() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista esta vacia");

		int contador = 0;
		for (FigurasCerradas triangulo : figuritas) {
			if (triangulo instanceof TrianguloRectangulo)
				contador++;
		}

		System.out.println("\n Total de triángulos: " + contador + ". ");
	}
	
	
	/**
	 * Metodo que devuelve el tamanyo de la lista
	 * @return tamanyo de la lista
	 */
	int size() {
		return figuritas.size();
	}

	/**
	 * Metodo que comprueba si la lista esta vacia
	 * @return la validacion de la lista vacia o no
	 */
	boolean isEmpty() {
		return figuritas.isEmpty();

	}

	
	/**
	 * Metodo que permite comprobar si la lista contiene a determinada figura
	 * @param figuras
	 * @return
	 * @throws FiguraNoExisteException
	 */
	protected boolean contains(FigurasCerradas figuras) throws FiguraNoExisteException {
		if (!figuritas.contains(figuras))
			throw new FiguraNoExisteException("La figura no existe");
		return true;
	}
	
	/**
	 * MEtodo que permite limpiar la lista de figuras
	 */
	public void clear() {
		figuritas.clear();
	}
	
	/**
	 * Metodo toString sobreescrito, que muestra el conjunto de figuras
	 */
	@Override
	public String toString() {
		return size() + " Figuritas" + figuritas;
	}
}
