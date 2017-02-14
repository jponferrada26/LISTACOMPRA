package listadoEstructuraDatos3Ejercicio8v3;

import java.util.*;
import utiles.Teclado;
/**
 * @author Javier Ponferrada Lopez
 * @version 3.0
 * */
public class Lista<E> {
	private ArrayList<E> arraylist = new ArrayList<E>();

	/**
	 * GET ArrayList
	 */
	private ArrayList<E> getArraylist() {
		return arraylist;
	}

	/**
	 * SET ArrayList
	 */
	private void setArraylist(ArrayList<E> arraylist) {
		this.arraylist = arraylist;
	}

	/**
	 * AÃ±adir nuevo elemento al final de la lista
	 * 
	 * @param elemento,
	 *            que deseamos anadir al final de la lista
	 */
	void add(E elemento) {
		getArraylist().add(elemento);
	}

	/**
	 * Insertar elemento en una posicion determinada sin aplastar el elemento
	 * que se se encuentrara en el mismo
	 * 
	 * @param elemento,
	 *            elemento que deseamos anadir a la lista
	 * @param posicion,
	 *            la en la que quieres anadir dicho elemento
	 */
	boolean add(E elemento, int posicion) {
		if (posicion < 0 || posicion > size())
			return false;
		getArraylist().add(posicion, elemento);
		return true;
	}

	/**
	 * reeemplazar un elemento de la lista por uno que indiquemos
	 * 
	 * @param elemSuplantar,
	 *            elemento que desea suplantar el usuario
	 * @param elemento,
	 *            elemento por el que quiere suplantarlo.
	 */
	E reemplazar(E elemSuplantar, E elemento) {
		int indice = getArraylist().indexOf(elemSuplantar);
		if (indice == -1)
			return null;
		return getArraylist().set(indice, elemento);

	}
	
	/**
	 * Longitud de la lista
	 * 
	 * @return longitud de la lista
	 */
	int size() {
		return getArraylist().size();
	}

	/**
	 * Borrar un elemento de la lista
	 * 
	 * @param eliminar,
	 *            elemento a eliminar
	 */
	boolean borrarElemento(int eliminar) {
		if(fueraDeRango(eliminar))
			return false;
		getArraylist().remove(eliminar);
		return true;
	}
	
	/**
	 * GET ELEMENT
	 * */
	E get(int posicion){
		if(fueraDeRango(posicion))
			return null;
		return this.arraylist.get(posicion);
	}

	/**
	 * @param posicion
	 * @return si se encuentra fuera de rango
	 */
	private boolean fueraDeRango(int posicion) {
		return posicion < 0 || posicion >= size();
	}
	
	
	/**
	 * Buscar y demostrar si existe el elemento
	 * 
	 * @param elemento,
	 *            elemento que deseamos buscar para comprobar si existe en la
	 *            lista
	 * @return si existe o no el elemento.
	 */
	boolean buscaElementos(E elemento) {
		if (getArraylist().contains(elemento))
			return true;
		return false;
	}
	/**
	 * COMPROBAR QUE LA LISTA ESTE VACIA
	 */
	boolean isEmpty(){
		return this.arraylist.isEmpty();
	}
	
	/**
	 * ITERA LA LISTA
	 * */
	Iterator<E> iterator(){
		return this.arraylist.iterator();
	}
	/**
	 * COPIA DE UN ARRAYLIST
	 * 
	 * @return copia de la lista.
	 */
	Object copiaLista() {
		return getArraylist().clone();
	}

	/**
	 * Mostrar la lista
	 * 
	 * @return la lista
	 */
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("------LISTA-----\n");
		int i=1;
		for (Object elemento : getArraylist()) {
			cadena.append((i++)+"-"+elemento + "\n");
		}
		return cadena.toString();
	}
	

	

}
