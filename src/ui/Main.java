package ui;

import collections.ABB;
import collections.Nodo;

public class Main {

	public static void main(String[] args) {

		Nodo<Integer> inicio = new Nodo<Integer>(10);
		ABB<Nodo> arbol = new ABB<Nodo>(inicio);
		
		Nodo<Integer> otro1 = new Nodo<Integer>(12);
		Nodo<Integer> otro2 = new Nodo<Integer>(20);
		Nodo<Integer> otro3 = new Nodo<Integer>(30);
		Nodo<Integer> otro4 = new Nodo<Integer>(25);
		
		arbol.agregarNodo(otro1);
		arbol.agregarNodo(otro2);
		arbol.agregarNodo(otro3);
		
		arbol.eliminarNodo(otro2);

		otro2 = new Nodo<Integer>(20);
		arbol.agregarNodo(otro2);
		arbol.agregarNodo(otro4);

		arbol.eliminarNodo(otro1);
		
		Nodo<Integer> otro5 = new Nodo<Integer>(8);
		
		arbol.agregarNodo(otro5);
		arbol.buscarNodo(12);
		
	}

}
