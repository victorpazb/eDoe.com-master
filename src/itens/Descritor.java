package itens;
import java.io.Serializable;

/**
 * Classe responsável por armazenar descritores.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class Descritor implements Comparable<Descritor>, Serializable {
	
	private int qtdItens = 0;
	private String descritor;
	private static final long serialVersionUID = 3L;
	
	/**
	 * Método construtor da classe descritor.
	 * @param descritor
	 */
	public Descritor(String descritor) {
		this.parametroInvalido(descritor);
		this.descritor = descritor;
	}
	
	public void setQtdItens(int qtd) {
		this.qtdItens = qtd;
	}
	
	public String nomeDescritor() {
		return this.descritor;
	}
	
	/**
	 * Verifica se o descritor eh invalido.
	 * 
	 * @param descritor
	 */
	private void parametroInvalido(String descritor) {
		if (descritor == null || descritor.trim().isEmpty())
			throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");
	}
	
	/**
	 * toString da classe Descritor.
	 */
	@Override
	public String toString() {
		return this.qtdItens + " - " + this.descritor;
	}
	
	/**
	 * Comparador da classe Descritor pelo nome do mesmo.
	 */
	@Override
	public int compareTo(Descritor other) {
		return this.descritor.compareTo(other.nomeDescritor());
	}
	
	/**
	 * hashCode da classe Descritor.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descritor == null) ? 0 : descritor.hashCode());
		return result;
	}
	
	/**
	 * equals da classe Descritor.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Descritor other = (Descritor) obj;
		if (descritor == null) {
			if (other.descritor != null)
				return false;
		} else if (!descritor.equals(other.descritor))
			return false;
		return true;
	}
	
	

}
