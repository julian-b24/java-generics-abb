package collections;

public interface IABB<N> {
	
	public void a�adirNodo(N n);

	public void eliminarNodo(N n);
	
	public <T> N buscarNodo(T t);
	
}
