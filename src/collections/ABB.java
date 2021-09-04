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
		if (n != null) {
			
			if(n.darIzquierdo() == null && n.darDerecho() == null) {
				
				if(n == r) {
					r = null;
				} else if(n.compareTo(n.darPadre()) <= 0) {
					n.darPadre().agregarIzquierdo(null); 
				} else {
					n.darPadre().agregarDerecho(null);
				}
				
				n.agregarPadre(null);
			} else if(n.darIzquierdo() == null || n.darDerecho() == null) {
				
				N hijo;
				if(n.darIzquierdo() == null) {
					hijo = n.darDerecho();
				} else {
					hijo = n.darIzquierdo();
				}
				
				hijo.agregarPadre(n.darPadre());
				
				if(n == r) {
					r = hijo;
				}else if (n.compareTo(n.darPadre()) <= 0) {
					n.darPadre().agregarIzquierdo(hijo);
				} else {
					n.darPadre().agregarDerecho(hijo);
				}
			} else {
				
				N sucesor = minimo(n.darDerecho());
				n.cambiarValor(sucesor.mostrarValor());
				eliminarNodo(sucesor);
			}
			
		}
	}
	
	public N minimo(N n){
		if(n.darIzquierdo() == null) {
			return n;
		}else {
			return minimo(n.darIzquierdo());
		}
	}

	public <T> N buscarNodo(T t) {
		return null;
	}

}
