package exercicio;

import exercicio.NoLista;
import exercicio.TADLista;

public class ListaLigada<T> implements TADLista<T> {

		protected NoLista<T> inicio; //Criando um objeto da classe NoLista
		protected int quantidade; 
		
		public void add(T e) { //Adicionar um elemento na lista
			NoLista<T> novo = new NoLista<T>(e); //Objeto da classe NoLista
			novo.setProximo(inicio);
			inicio = novo;
			quantidade++;
		}

		public boolean remove(T e) {//Remover um elemento
			boolean r = false;
			if (inicio != null && inicio.getInfo().equals(e)) { //Se tiver alguma coisa no inicio e essa coisa for o elemento que estamos procurando
				inicio = inicio.getProximo(); //Inicio vai começar no proximo, removendo o elemento
				quantidade--;// Diminui a quantidade de elementos na lista
				r = true;
			} else {// Se o elemento procurado nao estiver no inicio
				NoLista<T> p = inicio;// Cria-se um objeto, no qual vai ser o inicio
				while (p.getProximo() != null) { //Faça isso enquanto o proximo tiver algum elemento
					if (p.getProximo().getInfo().equals(e)) {//Se o proximo for o elemento procurado
						p.setProximo(p.getProximo().getProximo());
						quantidade--;//Diminui a quantidade de elementos da lista
						r = true;
					} else {//Se o proximo nao for o elemento procurado
						p = p.getProximo();//Pula para o proximo
					}
					
				}
			}
			return r;
		}

		public boolean contains(T e) {//Verificar se o elemento esta na lista
			boolean r = false;
			NoLista<T> aux = inicio;//Vai varrer a lista desde o inicio
			while (aux != null) {//Faça isso enquanto tiver elemento
				if (aux.getInfo().equals(e)) {//Se o elemento procurado for esse
					r = true;// Vai dizer que o elemento esta contido
					break;//Se achou o elemento ele para o laço
				}
				aux = aux.getProximo();//Se o elemento nao foi aquele procurado, ele ira procurar no proximo
			}
			return r;
		}

		public int indexOf(T e) { //Informar qual o indice que o elemento esta contido
			int r = -1, i = 0;
			NoLista<T> aux = inicio;
			while (aux != null) {//Faça isso enquanto tiver elemento
				if (aux.getInfo().equals(e)) {//Se o elemento procurado for esse
					r = i;//r vai ver igual ao numero da casa que o elemento esta contido
					break;//Se achou o elemento ele para o laço
				}
				aux = aux.getProximo();//Se o elemento nao foi aquele procurado, ele ira procurar no proximo
				i++;
			}
			return r;
		}

		public T get(int i) { //Vai informar qual elemento esta naquele determinado indice
			T r = null;
			int contador = 0;
			NoLista<T> aux = inicio;
			while (aux != null && contador <= i) {//Enquanto houver elementos e o contador for menor ou igual ao i(numero da casa aonde o elemento procurado esta)
				if (contador == i) {//Se o contador for igual ao numero do elemento
					r = aux.getInfo();// Pega o elemento que esta naquele indice
					break;//Se achou o elemento ele para o laço
				}
				aux = aux.getProximo();//Se o contador ainda nao for igual ao indice do elemento, ele vai para o proximo
				contador++;//Vai aumentando o contador de um em um
			}
			return r;
		}
		
		public void set(int i, T e) {
			int contador = 0;
			NoLista<T> aux = inicio;
			while (aux != null && contador <= i) {//Enquanto houver elementos e o contador for menor ou igual ao i(numero da casa aonde o elemento procurado esta)
				if (contador == i) {//Se o contador for igual ao numero do elemento
					aux.setInfo(e);
					break;//Se achou o elemento ele para o laço
				}
				aux = aux.getProximo();//Se o contador ainda nao for igual ao indice do elemento, ele vai para o proximo
				contador++;//Vai aumentando o contador de um em um
			}
		}

		public String toString() {
			String r = "";
			for(NoLista<T> aux=inicio; aux != null; aux = aux.getProximo()) {//Vai varrer a lista desde o inicio, e enquanto o elemento nao for nulo, ele vai pulando para o proximo
				r += aux.getInfo() + " -> ";// A cada indice, vai se mostrar o elemento presente nele
			}
			r += "null";
			return r;
		}
		
		public void print() {
			System.out.println(this);//Chama a toString
		}

		public int size() { //Mostra a quantidade de elementos na lista
			return quantidade;
		}

	
}
