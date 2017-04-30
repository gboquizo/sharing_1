package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.DimensionNoValidaException;

/**
 * Clase abstracta de figuras cerradas.
 * 
 * @author Guillermo Boquizo Sanchez
 * @version 1.0
 */
public abstract class FigurasCerradas {

	/**
	 * Campo id
	 */
	private int id;

	/**
	 * campo estático empleado para incrementar el id
	 */
	private static int contador = 0;

	/**
	 * Constructor de la figura cerrada, a partir de un id
	 * 
	 * @param id
	 *            id de la figura
	 */
	public FigurasCerradas() {
		setId();
	}

	/**
	 * Constructor sobrecargado para permitir el borrado por identificador
	 * @param id el id de la figura
	 */
	public FigurasCerradas(int id) {
		this.id = id;
	}

	protected int getId() {
		return id;
	}

	private void setId() {

		this.id = contador++;
	}
	
	protected void comprobarDimension(double dimension) throws DimensionNoValidaException {
		if (dimension < 0.5) {
			throw new DimensionNoValidaException("Error al crear el " + getClass().getSimpleName().toLowerCase() + ": "
					+ dimension + ":" + " La dimension ha de tener un minimo de 0.5");
		}
	}

	/**
	 * Metodo abstracto que permite obtener un area
	 * 
	 * 
	 */
	protected abstract double area();

	/**
	 * Metodo abstracto que permite obtener un perimetro
	 * 
	 */
	protected abstract double perimetro();

	/**
	 * Metodo de la clase abstracta que comprueba si una dimension es valida
	 * 
	 * @param dimension
	 * @throws DimensionNoValidaException
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Metodo equals implementado para permitir el borrado por id mediante
	 * sobrecarga de constructores
	 */
	@Override
	public boolean equals(Object obj) {
		FigurasCerradas other = (FigurasCerradas) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Metodo sobrescrito de Object para mostrar Figuras Cerradas
	 */
	@Override
	public String toString() {
		return "\n\t" + getClass().getSimpleName() + "\t" + "[identificador=" + getId() + " area="
				+ (Math.round(area() * 100) / 100d) + " perimetro=" + (Math.round(perimetro() * 100) / 100d) + "]";
	}
}
