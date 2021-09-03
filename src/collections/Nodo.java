package collections;

public class Nodo<T> {
	
	private T t;
	private Nodo<T> izquierdo;
	private Nodo<T> derecho;
	
	Nodo(T t){
		this.t = t;
		derecho = null;
		izquierdo = null;	
	}
	
	private void cambiarValor(T t) {
		this.t = t;
	}
	
	private T mostrarValor() {
		return t;
	}
	
	private Nodo<T> darIzquierdo() {
		return izquierdo;
	}
	
	private Nodo<T> darDerecho() {
		return derecho;
	}
	
}
