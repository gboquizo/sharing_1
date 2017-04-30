package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.DimensionNoValidaException;

/**
 * Clase que permite la creacion de un Triangulo Rectangulo
 * 
 * @author Guillermo
 * @version 2.0
 */
public class TrianguloRectangulo extends FigurasCerradas {

	private double base;
	private double altura;

	public TrianguloRectangulo(double base, double altura) throws DimensionNoValidaException {
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
	 * Metodo que permite calcular una raiz
	 * @return
	 */
	private double calcularRaiz() {
		return Math.sqrt(Math.pow(getBase(), 2)+ Math.pow(getAltura(), 2));
	}

	/**
	 * Metodo sobrescrito para calcular el area
	 */
	@Override
	protected double area() {
		return getBase() * getAltura()/2;
	
	}
	
	/**
	 * Metodo sobrescrito para calcular el perimetro
	 */
	@Override
	protected double perimetro() {
		return getBase() + getAltura() + calcularRaiz();
	}

	/**
	 * Metodo sobrescrito para mostrar el Triangulo Rectangulo
	 */
	@Override
	public String toString() {
		return super.toString() +  " base=" + (Math.round(getBase() * 100)/100d) + " altura=" + (Math.round(getAltura() * 100)/100d);
	}
}
