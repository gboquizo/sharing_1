package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.DimensionNoValidaException;


/**
 * Clase que permite la creacion de un Cuadrado
 * 
 * @author Guillermo
 * @version 2.0
 */
public class Cuadrado extends FigurasCerradas {

	private double lado;

	public Cuadrado(double lado) throws DimensionNoValidaException {
		super();
		setLado(lado);
	}

	private void setLado(double lado) throws DimensionNoValidaException {
		comprobarDimension(lado);
		this.lado = lado;
	}

	protected double getLado() {
		return lado;
	}

	
	/**
	 * Metodo sobrescrito para calcular el perimetro
	 */
	@Override
	protected double perimetro() {
		return (4 * getLado());
	 
	}
	
	/**
	 * Metodo sobrescrito para calcular el area
	 */
	@Override
	protected double area() {
		return Math.pow(getLado(), 2);
	}

	/**
	 * Metodo sobrescrito que permite mostrar un cuadrado
	 */
	@Override
	public String toString() {
		return super.toString() + " lado=" + (Math.round(getLado() * 100)/100d) + "]";
	}
}
