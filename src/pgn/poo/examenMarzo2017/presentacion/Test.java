package pgn.poo.examenMarzo2017.presentacion;


import pgn.poo.examenMarzo2017.estructuras.Figuritas;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.Circulo;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.Cuadrado;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.Rectangulo;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.TrianguloRectangulo;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.DimensionNoValidaException;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.FiguraNoExisteException;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.FiguraYaExisteException;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.excepciones.ListaVaciaException;
import pgn.poo.utiles.Menu;
import pgn.poo.utiles.Teclado;

/**
 * Clase test para la comunicacion con el usuario
 * @author Guillermo
 * @author Javier Ponferrada López
 * @version 2.0
 */
public class Test {

	private static String[] opcionesGenerales = { "Altas", "Bajas", "Listar" };
	private static Menu MenuGeneral = new Menu("*General***\n", opcionesGenerales);
	private static String[] opcionesAltas = { "Masivas (dimensiones aleatorias, 3 figuras de cada tipo)",
			"Selectivas (dimensiones por teclado)" };
	private static Menu MenuAltas = new Menu("*Altas***\n", opcionesAltas);
	private static String[] opcionesAltasSelectivas = { "Circulo", "Cuadrado", "Rectángulo", "Triángulo Rectángulo" };
	private static Menu MenuSelectivas = new Menu("Elige la figura a crear\n", opcionesAltasSelectivas);
	private static String[] opcionesBajas = { "Por identificador", "Por indice en la lista", "Limpiar" };
	private static Menu MenuBajas = new Menu("*Bajas", opcionesBajas);
	private static String[] opcionesListas = { "Todos", "Triangulos", "Del reves" };
	private static Menu MenuListas = new Menu("*Listar", opcionesListas);
	static Figuritas figuritas = new Figuritas();

	public static void main(String[] args) {

		gestionarMenuGeneral();
	}

	// ---Menú General---//
	
	/**
	 * Metodo que recoge las opciones un menu general
	 */
	private static void gestionarMenuGeneral() {
		int opcion;

		do {
			opcion = MenuGeneral.gestionar();
			switch (opcion) {
			case 1:
				gestionarAltas();
				break;
			case 2:
				gestionarBajas();
				break;
			case 3:
				gestionarListas();
				break;

			default:

				break;
			}
		} while (opcion != MenuGeneral.SALIR);
	}

	// ----Gestión de altas---//
	
	
	/**
	 * Metodo que recoge las opciones un menu de altas
	 */
	private static void gestionarAltas() {
		int opcion;
		do {
			opcion = MenuAltas.gestionar();
			switch (opcion) {
			case 1:

				gestionarMasivas();
				System.out.println(figuritas.toString());

				break;
			case 2:
				gestionarSelectivas();
				break;
			default:
				break;
			}

		} while (opcion != MenuAltas.SALIR);

	}

	/**
	 * Metodo que gestiona la creacion de varias figuras de forma masiva
	 */
	public static void gestionarMasivas() {
		for (int i = 0; i < 3; i++) {

			addRectangulo();
			addCuadrado();
			addCirculo();
			addTrianguloRectangulo();

		}
	}

	/**
	 * Metodo que permite anyadir un Triangulo Rectangulo de manera aleatoria
	 */
	private static void addTrianguloRectangulo() {
		try {
			figuritas.add(new TrianguloRectangulo(figuritas.generarAleatorio(), figuritas.generarAleatorio()));
		} catch (DimensionNoValidaException | FiguraYaExisteException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	
	/**
	 * Metodo que permite anyadir un Circulo de manera aleatoria
	 */
	private static void addCirculo() {
		try {
			figuritas.add(new Circulo(figuritas.generarAleatorio()));
		} catch (DimensionNoValidaException | FiguraYaExisteException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	/**
	 * Metodo que permite anyadir un Cuadrado Rectangulo de manera aleatoria
	 */	
	private static void addCuadrado() {
		try {
			figuritas.add(new Cuadrado(figuritas.generarAleatorio()));
		} catch (DimensionNoValidaException | FiguraYaExisteException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	/**
	 * Metodo que permite anyadir un Rectangulo de manera aleatoria
	 */
	private static void addRectangulo() {
		try {
			figuritas.add(new Rectangulo(figuritas.generarAleatorio(), figuritas.generarAleatorio()));
		} catch (DimensionNoValidaException | FiguraYaExisteException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * Metodo que gestiona la creacion de figuras por teclado
	 */
	private static void gestionarSelectivas() {
		int opcion;
		do {
			opcion = MenuSelectivas.gestionar();
			switch (opcion) {
			case 1:
				try {
					annadirCirculo();
				} catch (DimensionNoValidaException | FiguraYaExisteException e) {
					System.err.println(e.getLocalizedMessage());
				}
				break;
			case 2:
				try {
					annadirCuadrado();
				} catch (FiguraYaExisteException | DimensionNoValidaException e) {
					System.err.println(e.getLocalizedMessage());
				}
				break;
			case 3:
				try {
					annadirRectangulo();
				} catch (FiguraYaExisteException | DimensionNoValidaException e) {
					System.err.println(e.getLocalizedMessage());
				}
				break;
			case 4:
				try {
					annadirTrianguloRectangulo();
				} catch (FiguraYaExisteException | DimensionNoValidaException e) {
					System.err.println(e.getLocalizedMessage());
				}
				break;

			default:
				break;
			}

		} while (opcion != MenuSelectivas.SALIR);

	}

	
	/**
	 * Metodo que permite crear un Triangulo Rectangulo
	 * 
	 * @throws FiguraYaExisteException si la figura existe ya en la lista de figuras
	 * @throws DimensionNoValidaException si la dimension introducida es menor de 0.5
	 */
	private static void annadirTrianguloRectangulo() throws FiguraYaExisteException, DimensionNoValidaException {
		figuritas.add(new TrianguloRectangulo(Teclado.leerDecimal("Dame la base del Triángulo Rectángulo"),
				Teclado.leerDecimal("Dame la altura del Triángulo Rectángulo")));
	}

	
	/**
	 * Metodo que permite crear un Rectangulo
	 * 
	 * @throws FiguraYaExisteException si la figura existe ya en la lista de figuras
	 * @throws DimensionNoValidaException si la dimension introducida es menor de 0.5
	 */
	private static void annadirRectangulo() throws FiguraYaExisteException, DimensionNoValidaException {
		figuritas.add(new Rectangulo(Teclado.leerDecimal("Dame la base del Rectángulo"),
				Teclado.leerDecimal("Dame la altura del Rectángulo")));

	}

	
	/**
	 * Metodo que permite crear un Cuadrado
	 * 
	 * @throws FiguraYaExisteException si la figura existe ya en la lista de figuras
	 * @throws DimensionNoValidaException si la dimension introducida es menor de 0.5
	 */
	private static void annadirCuadrado() throws FiguraYaExisteException, DimensionNoValidaException {
		figuritas.add(new Cuadrado(Teclado.leerDecimal("Dame el lado del Cuadrado")));

	}
	
	
	/**
	 * Metodo que permite crear un Circulo
	 * 
	 * @throws FiguraYaExisteException si la figura existe ya en la lista de figuras
	 * @throws DimensionNoValidaException si la dimension introducida es menor de 0.5
	 */
	private static void annadirCirculo() throws DimensionNoValidaException, FiguraYaExisteException {
		figuritas.add(new Circulo(Teclado.leerDecimal("Dame el radio del Círculo")));

	}

	// ---Gestión de bajas---//
	
	
	/**
	 * Metodo que recoge las opciones un menu de bajas
	 */
	private static void gestionarBajas() {
		int opcion;
		do {
			opcion = MenuBajas.gestionar();
			switch (opcion) {
			case 1:
				 borrarPorIdentificador();
				break;
			case 2:
				borrarPorIndice();
				break;
			case 3:
				figuritas.clear();
				break;
			}

		} while (opcion != MenuBajas.SALIR);

	}


	
	/**
	 * Metodo que permite el borrado por identificador o id
	 */
	private static void borrarPorIdentificador() {
		try {
			System.out.println(figuritas.toString());
			figuritas.removeid(Teclado.leerEntero("Dame el identificador de la figura: "));
		} catch (FiguraNoExisteException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
	}
	
	
	/**
	 * Metodo que permite el borrado por indice de una lista de figuras existentes
	 */
	private static void borrarPorIndice() {
		try {
			figuritas.removeIndex();
		} catch (FiguraNoExisteException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
	}

	// -------Sección de presentación------//
	
	
	/**
	 * Metodo que recoge las opciones un menu de presentacion
	 */
	private static void gestionarListas() {
		int opcion;
		do {
			opcion = MenuListas.gestionar();
			switch (opcion) {
			case 1:
				System.out.println(figuritas.toString());
				break;
			case 2:
				try {
					figuritas.contarTriangulos();
				} catch (ListaVaciaException e) {
					System.err.println(e.getLocalizedMessage());
				}
				break;
			case 3:
				try {
					System.out.println(figuritas.listarFigurasInverso().toString());
				} catch (ListaVaciaException e) {
					System.err.println(e.getLocalizedMessage());
				}
				break;
			default:
				break;
			}

		} while (opcion != MenuListas.SALIR);

	}
}
