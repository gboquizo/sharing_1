package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.DimensionNoValidaException;


/**
 * Clase que permite la creacion de un Circulo
 * 
 * @author Guillermo
 * @version 2.0
 */
public class Circulo extends FigurasCerradas {

	private double radio;

	public Circulo(double radio) throws DimensionNoValidaException {
		super();
			setRadio(radio);
	}

	/**
	 * Constructor sobrecargado para borrar de la lista por identificador
	 * @param id
	 */
	public Circulo(int id) {
		super(id);
		
	}
	
	double getRadio() {
		return radio;
	}

	private void setRadio(double radio) throws DimensionNoValidaException {
		comprobarDimension(radio);
		this.radio = radio;
	}

	/**
	 * Metodo sobrescrito para calcular el area
	 */
	@Override
	protected double area() {
		 return Math.PI * (Math.pow(getRadio(), 2));
	}
	
	/**
	 * Metodo sobrescrito para calcular el perimetro
	 */
	@Override
	protected double perimetro() {
		return (2 * Math.PI * getRadio());
	}

	/**
	 * Metodo sobrescrito para mostrar el Circulo
	 */
	@Override
	public String toString() {
		return super.toString() + " radio=" + (Math.round(getRadio() * 100)/100d);
	}
}
