package collections;

public class ABB<N extends Nodo> implements IABB<N> {

	private N r;
	
	public ABB(N r) {
		this.setR(r);
	}
	
	public N getR() {
		return r;
	}

	public void setR(N r) {
		this.r = r;
	}
	
	@Override
	public void agregarNodo(N n) {
		agregarNodo(r, n);
	}

	private <T extends Comparable<T>, N extends Nodo<T>>void agregarNodo(N current, N newNodo) {
		if(current == null) {
			current = newNodo;
		} else if(current.compareTo(newNodo) > 0) {
			agregarNodo(current.darIzquierdo(), newNodo);
		} else {
			agregarNodo(current.darDerecho(), newNodo);
		}
	}

	public void eliminarNodo(N n) {
		
	}

	public <T> N buscarNodo(T t) {
		return null;
	}

}
