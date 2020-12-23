package exercicio;

public class NoBinario<T> {
	private T info;
	private NoBinario<T> esquerda, direita;
	private int posicaoHorizontalDoNo;
	
	public int getPosicaoHorizontalDoNo() {
		return posicaoHorizontalDoNo;
	}
	public void setPosicaoHorizontalDoNo(int posicaoHorizontalDoNo) {
		this.posicaoHorizontalDoNo = posicaoHorizontalDoNo;
	}
	public NoBinario(T e) {
		info = e;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NoBinario<T> getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(NoBinario<T> esquerda) {
		this.esquerda = esquerda;
	}
	public NoBinario<T> getDireita() {
		return direita;
	}
	public void setDireita(NoBinario<T> direita) {
		this.direita = direita;
	}
	
	public String toString() {
		String s = "" + info;
		return s;
	}
	
}

