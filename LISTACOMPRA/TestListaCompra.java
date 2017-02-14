package listadoEstructuraDatos3Ejercicio8v3;
import utiles.Menu;
/**
 * ListaDeLaCompra. Implementa un programa que gestione una lista de la compra
 * de forma automatica. Se dispondra de una lista de articulos y de sus
 * existencias. En el momento en el que la cantidad de articulos llegue a un
 * limite minimo, dicho articulo aparecera en la lista de la compra.
 * Cada vez que el usuario utilice uno de los articulos se decrementaran las
 * existencias de dicho articulo. De igual forma, cada vez que el usuario
 * compre el articulo, se incrementaran las existencias de dicho articulo.
 * A modo de ejemplo, supongamos que del articulo "latas de cerveza" se
 * establece a un minimo de 10 cervezas. Actualmente hay 14 y se consumen de
 * golpe 5 cervezas.
 * <ul>
 * <li>a. Articulo: [nombre = latas de cerveza, cantidad minima= 10, existencias
 * = 14]</li>
 * <li>b. articulo.consumir(5)</li>
 * <li>c. Articulo: [nombre = latas de cerveza, cantidad minima= 10, existencias
 * = 9]</li>
 * <li>d. Como (articulo.getExistencias() <= articulo.getCantidadMin()) hay que
 * comprar latas de cerveza.</li>
 * </ul>
 * Quizas sea interesante anÌƒadir un campo codigo del articulo para facilitar
 * la gestion de la lista. Este codigo ha de ser unico (static...) Para ello,
 * genera un interfaz con el usuario que permita entre otras acciones:
 * <ul>
 * <li>e. AnÌƒadir un producto nuevo a la lista.</li>
 * <li>f. Eliminar un elemento de la lista.</li>
 * <li>g. Incrementar las existencias de un articulo.</li>
 * <li>h. Decrementar las existencias de un articulo.</li>
 * <li>i. Modificar la cantidad minima del articulo.</li>
 * <li>j. Mostrar la lista de todos los articulos.</li>
 * <li>k. Mostrar la lista de la compra.</li> Comienza analizando el disenÌƒo.
 * Piensa en el total de clases que vas a utilizar y aprovecha aquellas clases
 * que puedas.
 * 
 * @author Javier Ponferrada Lopez
 * @version 3.0
 */
public class TestListaCompra {
	private static TestLista testLista = new TestLista();
	
	public static void main(String[] args) {
		Menu menu = new Menu("---MENU---", new String[] { "AnadirArticulo", "BorrarArticulo", "Incrementar Stock",
				"Decrementar Stock", "Modificar stockMinimo", "Mostrar Articulos", "Mostrar lista Compra", "Salir" });
		int opcion;
		do {
			opcion = menu.gestionar();
			gestionarMenu(opcion);
		} while (opcion != menu.getSALIR());

	}

	private static void gestionarMenu(int opcion) {
		switch (opcion) {// Anadir un producto nuevo a la lista.

		case 1:// Anade a la lista de la compra el articulo deseado
			annadirArticulo();
			break;
		case 2:// Eliminar un elemento de la lista.
			eliminarArticulo();
			break;
		case 3:// Incrementar las existencias de un artiÌ�culo.
			rellenarStock();
			break;
		case 4:// Decrementar las existencias de un articulo.
			consumirArticulo();
			break;
		case 5:// Modificar la cantidad minima del articulo.
			cambiarStockMinimo();
			break;
		case 6:// Mostrar la lista de todos los articulos.
			mostrarListaArticulos();
			break;
		case 7:// Mostrar la lista de la compra.
			System.out.println(testLista.mostrarListaCompra());
			break;
		case 8:// Salir
			System.out.println("bye.");
			break;
		}
	}

	/**
	 * MOSTRAR LISTA DE ARTICULOS
	 */
	private static void mostrarListaArticulos() {
		System.out.println(testLista.mostrarListaArticulos());
	}

	/**
	 * CAMBIAR STOCK MINIMO
	 */
	private static void cambiarStockMinimo() {
		System.out.println(testLista.mostrarListaArticulos());
		System.out.println(testLista.modificarStockMinimo());
	}

	/**
	 * CONSUMIR ARTICULO
	 */
	private static void consumirArticulo() {
		System.out.println(testLista.mostrarListaArticulos());
		System.out.println(testLista.consumirArticulo());
	}

	/**
	 * RELLENAR STOCK
	 */
	private static void rellenarStock() {
		System.out.println(testLista.mostrarListaArticulos());
		System.out.println(testLista.rellenarStock());
	}

	/**
	 * ELIMINAR ARTICULO
	 */
	private static void eliminarArticulo() {
		System.out.println(testLista.mostrarListaArticulos());
		System.out.println(testLista.eliminarArticulo());
	}

	/**
	 * ANNADIR ARTICULO
	 */
	private static void annadirArticulo() {
		testLista.annadirArticulo();
	}

	

}
