package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.DimensionNoValidaException;

/**
 * Clase que permite la creacion de un Rectangulo
 * 
 * @author Guillermo
 * @version 2.0
 */
public class Rectangulo extends FigurasCerradas {

	
	private double base;
	private double altura;

	
	public Rectangulo(double base, double altura) throws DimensionNoValidaException {
		super();
			setBase(base);
			setAltura(altura);
	}
	
	
	protected double getBase() {
		return base;
	}
	
	
	private void setBase(double base) throws DimensionNoValidaException {
		comprobarDimension(base);
		this.base = base;
	}

	protected double getAltura() {
		return altura;
	}

	private void setAltura(double altura) throws DimensionNoValidaException {
		comprobarDimension(altura);
		this.altura = altura;
	}

	/**
	 * Metodo sobrescrito de la clase padre para calcular el perimetro del rectangulo
	 */
	@Override
	protected double perimetro() {
	return 2 * getBase() + 2 * getAltura();
	
	}

	/**
	 * Metodo sobrescrito para calcular el area del rectangulo
	 */
	@Override
	protected double area() {
	return getBase() * getAltura();
	
	}

	/**
	 * Metodo toString sobreescrito de la clase padre
	 */
	@Override
	public String toString() {
		return super.toString() + " base=" + (Math.round(getBase() * 100)/100d) + " altura=" + (Math.round(getAltura() * 100)/100d);
	}
 	
}
