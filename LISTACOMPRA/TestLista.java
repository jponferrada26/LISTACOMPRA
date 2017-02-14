package listadoEstructuraDatos3Ejercicio8v3;

import utiles.Teclado;
/**
 * CLASE QUE SE ENCUENTRA ENTRE LA LISTA GENERICA Y EL TESTLISTACOMPRA(CAPA PRESENTACION).
 * 
 * @author Javier Ponferrada Lopez
 * @version 3.0
 * */
public class TestLista {
	private static Lista<Articulo> listaArticulos = new Lista<Articulo>();
	private static StringBuilder listaCompra = new StringBuilder();
	
	/**
	 * ANADIR UN ARTICULO A LA LISTA
	 * */
	void annadirArticulo(){
		 listaArticulos.add(Articulo.crearProducto());
	}
	
	/**
	 * ELIMINAR ARTICULO DE LA LISTA 
	 * @return mensaje a mostrar al usuario.
	 * */
	String eliminarArticulo(){
		if (!listaArticulos.borrarElemento(pedirPosicion()))
			return "No he podido eliminar el articulo.";
		return "Articulo eliminado.";
	}
	
	/**
	 * MODIFICAR STOCK MINIMO
	 * @return mensaje a mostrar al usuario.
	 * */
	String modificarStockMinimo(){
		int posicion = pedirPosicion();
		if (listaArticulos.get(posicion) == null)
			return "No se ha podido modificar el stock minimo";
		else{
			listaArticulos.get(posicion).modificarStockMinimo(Teclado.leerEntero("StockMin:"));
			comprobarStockMinimos();
			return "Se ha modificado el stock minimo de: "+listaArticulos.get(posicion).getNombre(); 
		}
	}
	
	
	/**
	 * CONSUMIR ARTICULO
	 * @return mensaje a mostrar al usuario.
	 */
	String consumirArticulo() {
		int posicion = pedirPosicion();
		if (listaArticulos.get(posicion) == null)
			return "No se ha podido consumir articulo.";
		else{
			listaArticulos.get(posicion).derementoStock(Teclado.leerEntero("DecrementoStock:"));
			comprobarStockMinimos();
			return "Se ha consumido: "+listaArticulos.get(posicion).getNombre();
		}
	}
	
	/**
	 * RELLENAR STOCK DE LOS ARTICULOS DE LA LISTA
	 * @return mensaje a mostrar al usuario.
	 * */
	String rellenarStock() {
		int posicion = pedirPosicion();
		if (listaArticulos.get(posicion) == null)
			return "No se ha podido rellenar Stock del articulo.";
		else{
			listaArticulos.get(posicion).incrementarStock(Teclado.leerEntero("IncrementoStock:"));
			comprobarStockMinimos();
			return "Se ha incrementado el stock de: "+listaArticulos.get(posicion).getNombre();
		}
		
		
	}
	
	/**
	 * MOSTRAR LA LISTA DE ARTICULOS
	 * @return mensaje a mostrar al usuario.
	 * */
	String mostrarListaArticulos(){
		if(listaArticulos.size()>0){
			comprobarStockMinimos();
			return listaArticulos.toString();
		}
		return "La lista esta vacia";
	}
	
	/**
	 * MOSTRAR LA LISTA DE LA COMPRA
	 * @return mensaje a mostrar al usuario.
	 * */
	String mostrarListaCompra(){
		if(listaCompra.length()<1)
			return "Lista de la compra esta vacia";
		return listaCompra.toString();
	}
	
	/**
	 * comprueba que el stock de cada articulo no este por debajo del minimo
	 * predefinido
	 * @return mensaje a mostrar al usuario.
	 */
	private void comprobarStockMinimos() {
		for (int i = 0; i < listaArticulos.size(); i++) {
			if (listaArticulos.get(i).getStock() <= listaArticulos.get(i).getStockMin()) {
				listaCompra.append((i + 1) + ")- " + "("+(listaArticulos.get(i).getStockMin()-listaArticulos.get(i).getStock())+")"+listaArticulos.get(i).getNombre()+"\n");
				while (listaArticulos.get(i).getStock() <= listaArticulos.get(i).getStockMin()) {
					listaArticulos.get(i).incrementarStock(1);
				}
			} else {
				listaCompra.delete(0, listaCompra.length());
			}

		}
	}
	
	/**
	 * Pedir al usuario la posicion a modificar de la lista.
	 * 
	 * @return la posicion que se desea modificar de la lista
	 */
	private static int pedirPosicion() {
		int posicion;
		if (listaArticulos.size() > 0) {
			do {
				posicion = Teclado.leerEntero("Posicion nuevo elemento 1 y " + listaArticulos.size() + ":");
			} while (posicion > listaArticulos.size() || posicion < 1);
			return posicion-1;
		}
		return 0;
	}
	
}
