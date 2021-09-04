package collections;

public class Nodo<T extends Comparable<T>> {
	
	private T t;
	private Nodo<T> izquierdo;
	private Nodo<T> derecho;
	private Nodo<T> padre;
	
	public Nodo(T t){
		this.t = t;
		derecho = null;
		izquierdo = null;	
	}
	
	public void cambiarValor(T t) {
		this.t = t;
	}
	
	public T mostrarValor() {
		return t;
	}
	
	public Nodo<T> darIzquierdo() {
		return izquierdo;
	}
	
	public Nodo<T> darDerecho() {
		return derecho;
	}
	
	public void agregarDerecho(Nodo<T> der) {
		derecho = der;
	}
	
	public void agregarIzquierdo(Nodo<T> izq) {
		izquierdo = izq;
	}

	public int compareTo(Nodo<T> n) {
		return t.compareTo(n.mostrarValor());
	}

	public void agregarPadre(Nodo<T> padre) {
		this.padre = padre;
	}

	public Nodo<T> darPadre() {
		return padre;
	}
}
