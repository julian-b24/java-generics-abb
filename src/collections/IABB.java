package collections;

public interface IABB<N> {
	
	public void aņadirNodo(N n);

	public void eliminarNodo(N n);
	
	public <T> N buscarNodo(T t);
	
}
