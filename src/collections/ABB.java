package collections;

public class ABB<N extends Nodo> implements IABB<N> {

	private N raiz;
	
	public ABB(N r) {
		this.raiz = r;
	}
	
	public N getR() {
		return raiz;
	}

	@Override
	public void agregarNodo(N n) {
		agregarNodo(raiz, n, null);
	}

	private <T extends Comparable<T>, N extends Nodo<T>>void agregarNodo(N current, N newNodo, N parent) {
		
		//if(parent != null && current != null) {
			//System.out.println(current.mostrarValor() + " " + newNodo.mostrarValor() + " " + parent.mostrarValor());
		//}
		
		if(current == null) {
			newNodo.agregarPadre(parent);
			
			if(newNodo.compareTo(parent) > 0) {
				parent.agregarDerecho(newNodo);
			} else {
				parent.agregarIzquierdo(newNodo);
			}
			
		} else if(current.compareTo(newNodo) > 0) {
			agregarNodo(current.darIzquierdo(), newNodo, current);
		} else {
			agregarNodo(current.darDerecho(), newNodo, current);
		}
	}

	public void eliminarNodo(N n) {
		if (n != null) {
			
			if(n.darIzquierdo() == null && n.darDerecho() == null) {
				
				if(n == raiz) {
					raiz = null;
				} else if(n.compareTo(n.darPadre()) <= 0) {
					n.darPadre().agregarIzquierdo(null); 
				} else {
					n.darPadre().agregarDerecho(null);
				}
				
				n.agregarPadre(null);
			} else if(n.darIzquierdo() == null || n.darDerecho() == null) {
				
				N hijo;
				if(n.darIzquierdo() == null) {
					hijo = (N) n.darDerecho();
				} else {
					hijo = (N) n.darIzquierdo();
				}
				
				hijo.agregarPadre(n.darPadre());
				
				if(n == raiz) {
					raiz = hijo;
				}else if (n.compareTo(n.darPadre()) <= 0) {
					n.darPadre().agregarIzquierdo(hijo);
				} else {
					n.darPadre().agregarDerecho(hijo);
				}
			} else {
				
				N sucesor = minimo((N) n.darDerecho());
				n.cambiarValor(sucesor.mostrarValor());
				eliminarNodo(sucesor);
			}
			
		}
	}
	
	public N minimo(N n){
		if(n.darIzquierdo() == null) {
			return n;
		}else {
			return minimo((N) n.darIzquierdo());
		}
	}

	public <T> N buscarNodo(T t) {
		N nodo = null;
		if(raiz != null) {
			if(raiz.mostrarValor().equals(t)) {
				nodo = raiz;
			}else {
				nodo = buscarNodo(t, raiz);
			}
		}
		return nodo;
	}

	private <T> N buscarNodo(T t, N current) {
		N nodo = null;
		if(current.mostrarValor().compareTo(t) > 0) {
			if(current.darIzquierdo() != null) {
				if(current.mostrarValor().equals(t)) {
					nodo = (N) current.darIzquierdo();
				}else {
					nodo = buscarNodo(t, (N) current.darIzquierdo());
				}
			}
		}else if(current.mostrarValor().compareTo(t) <= 0) {
			if(current.darDerecho() != null) {
				if(current.darDerecho().mostrarValor().equals(t)) {
					nodo = (N) current.darDerecho();
				}else {
					nodo = buscarNodo(t, (N) current.darDerecho());
				}
			}
		}
		return nodo;
	}

}
