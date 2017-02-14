package listadoEstructuraDatos3Ejercicio8v3;

import utiles.Teclado;

/**
 * ListaDeLaCompra. Implementa un programa que gestione una lista de la compra de forma automaÌ�tica. Se dispondraÌ� de una lista de artiÌ�culos y de sus existencias. En el momento en el que la cantidad de artiÌ�culos llegue a un liÌ�mite miÌ�nimo, dicho artiÌ�culo apareceraÌ� en la lista de la compra. Cada vez que el usuario utilice uno de los artiÌ�culos se decrementaraÌ�n las existencias de dicho artiÌ�culo. De igual forma, cada vez que el usuario compre el artiÌ�culo, se incrementaraÌ�n las existencias de dicho artiÌ�culo.
 *A modo de ejemplo, supongamos que del artiÌ�culo "latas de cerveza" se establece a un miÌ�nimo de 10 cervezas. Actualmente hay 14 y se consumen de golpe 5 cervezas.
 *<ul>
 *<li>a. ArtiÌ�culo: [nombre = latas de cerveza, cantidad miÌ�nima= 10, existencias = 14]</li>
 *<li>b. articulo.consumir(5)</li>
 *<li>c. ArtiÌ�culo: [nombre = latas de cerveza, cantidad miÌ�nima= 10, existencias = 9]</li>
 *<li>d. Como (articulo.getExistencias() <= articulo.getCantidadMin()) hay que comprar latas de cerveza.</li>
 *</ul>
 *QuizaÌ�s sea interesante anÌƒadir un campo coÌ�digo del artiÌ�culo para facilitar la gestioÌ�n de la lista. Este coÌ�digo ha de ser uÌ�nico (static...)
 *Para ello, genera un interfaz con el usuario que permita entre otras acciones:
 *<ul>
 *<li>e. AnÌƒadir un producto nuevo a la lista.</li>
 *<li>f. Eliminar un elemento de la lista.</li>
 *<li>g. Incrementar las existencias de un artiÌ�culo.</li>
 *<li>h. Decrementar las existencias de un artiÌ�culo.</li>
 *<li>i. Modificar la cantidad miÌ�nima del artiÌ�culo.</li>
 *<li>j. Mostrar la lista de todos los artiÌ�culos.</li>
 *<li>k. Mostrar la lista de la compra.</li>
 *Comienza analizando el disenÌƒo. Piensa en el total de clases que vas a utilizar y
 *aprovecha aquellas clases que puedas.
 * @author Javier Ponferrada Lopez
 * @version 3.0
 * */
public class Articulo {
	/**
	 * Nombre del articulo
	 * */
	private String nombre;

	/**
	 * Stock del articulo
	 * */
	private int stock;
	/**
	 * Stock minimo del articulo
	 * */
	private int stockMin;
	
	/**
	 * marca del articulo
	 * */
	private String marca;
	
	/**
	 * Generador de codigo automatico que incrementa en 1 cada articulo
	 * */
	private static int generadorCodigo = 1;
	/**
	 * Codigo identificador del articulo
	 * */
	private int codigo;
	
	/**
	 * Constructor Accesible para asignar un codigo al articulo
	 * */
	private Articulo(int codigo){
		this.codigo = codigo;
	}
	
	/**
	 * Constructor del articulo
	 * @param nombre, que corresponde al articulo
	 * @param marca, que corresponde al articulo
	 * @param stock, que corresponde al articulo
	 * @param stockMinimo, que corresponde al articulo
	 * */
	private Articulo(String nombre, String marca,int stockMinimo,int stock) {
		if(stockMinimo>stock){
			setStock(stockMinimo++);
			setStockMin(stockMinimo);
		}else{
			setStockMin(stockMinimo);
			setStock(stock);
		}	
		setNombre(nombre);
		setCodigo();
		setMarca(marca);
	}
	
	/**
	 * INSTANCIA UN NUEVO ARTICULO SI NO ES NULO
	 * @param nombre, que corresponde al articulo
	 * @param marca, que corresponde al articulo
	 * @param stock, que corresponde al articulo
	 * @param stockMinimo, que corresponde al articulo
	 * */
	static Articulo getInstance(String nombre,String marca, int cantMinima, int existencias) {

		if (existencias < cantMinima)
			return null;

		return new Articulo(nombre,marca,cantMinima,existencias);

	}

//	Si creamos
//
//	un getInstance() y privatizamos el constructor, dentro
//
//	del getInstance() podemos controlar que cada vez que se cree un artículo, se haga correctamente y asi lo obligamos en el main(). 
//
//	Así en el main podremos hacer lo siguiente:
	
	/**
	 * Crear un producto(articulo), con sus respectivos atributos
	 * @return Articulo creado
	 * */
	static Articulo crearProducto() {
		String nombre = Teclado.leerCadena("Nombre de nuevo producto: ");
		String marca = Teclado.leerCadena("Marca del nuevo producto: ");
		int cantMinima;
		int existencias;
		
		Articulo articulo;
		
		do {
			cantMinima = Teclado.leerEnteroPositivo("Introduzca una cantidad minima: ");
			existencias = Teclado.leerEnteroPositivo("Introduzca las existencias del producto: ");
			articulo = Articulo.getInstance(nombre, marca, cantMinima, existencias);
		} while (articulo == null);
		
		return articulo;
	}
	
	/**
	 * @return nombre del articulo
	 * */
	String getNombre() {
		return nombre;
	}
	
	/**
	 * Asigna al articulo un nombre
	 * @param nuevo nombre para el articulo
	 * */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return codigo del articulo
	 * */
	private int getCodigo() {
		return codigo;
	}
	
	/**
	 * 
	 * */
	private void setCodigo() {
		this.codigo = Articulo.generadorCodigo++;
	}
	
	/**
	 * @return marca del articulo
	 * */
	private String getMarca() {
		return marca;
	}
	/**
	 * @param marca, que se asignara al producto
	 * */
	private void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * @return stock minimo del producto
	 * */
	int getStockMin() {
		return stockMin;
	}
	
	/**
	 * @param stockMin, que se le asignara al producto
	 * */
	private void setStockMin(int stockMin) {
		if(stockMin<0)
			this.stockMin = 0;
		else
			this.stockMin = stockMin;
	}
	
	/**
	 * @return stock que dispone el articulo
	 * */
	int getStock() {
		return stock;
	}

	/**
	 * @param stock, que se le asignara al articulo
	 * */
	private void setStock(int stock) {
		if(stock<0)
			this.stock = getStockMin()+1;
		else
			this.stock = stock;
	}
	
	/**
	 * Incrementa el stock actual del articulo
	 * @param incremento, de stock al ya actual del articulo
	 * */
	void incrementarStock(int incremento){//Incrementar las existencias de un articulo
			setStock(getStock()+incremento);	
	}
	
	/**
	 * Decremento el stock actual del articulo
	 * @param aDecrementar, de stock al ya actual del articulo
	 * */
	void derementoStock(int aDecrementar){// Decrementar las existencias de un articulo.
		int decremento = getStock()-aDecrementar;
		if(decremento>0){
			setStock(decremento);
		}		
	}
	
	/**
	 * Modifica el stock minimo del articulo
	 * @param modificacion, del stockminimo del articulo
	 * */
	void modificarStockMinimo(int modificacion){//Modificar la cantidad miÌ�nima del artiÌ�culo.
		if(modificacion>0)
			setStockMin(modificacion);
	}
	
	/**
	 * TOSTRING del articulo
	 * @return toString
	 * */
	public String toString() {
		return getNombre()+"["+getCodigo()+" | "+getMarca()+" | "+ getStockMin() + " | "+ getStock()+"]";
	}
	
	
}


