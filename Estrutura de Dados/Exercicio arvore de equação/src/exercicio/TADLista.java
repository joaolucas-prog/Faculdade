package exercicio;

public interface TADLista<T> {
	public void add(T e); //Adicionar elemento a lista
	public boolean remove(T e); //Remove o elemento da lista
	public boolean contains(T e); //Verifica se certo elemento esta na lista
	public int indexOf(T e); //Posiçao do elemento na lista
	public T get(int i);
	public void print();
	public int size(); //Numero de elementos da lista
}
