package itens;

import java.io.Serializable;
import java.util.Arrays;

import util.Validador;

/**
 * Classe que representa um item que pode ser doado e adicionado na lista de itens doaveis do doador.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class ItemDoavel implements Item, Serializable {
	private String nome;
	private String[] tags;
	private Integer idItem;
	private int qtdItem;
	private String representacaoUsuario;
	private int pontuacao;
	private static final long serialVersionUID = 1L;
	
	private Validador validador = new Validador();
	
	/**
	 * Construtor da classe ItemDoavel.
	 * @param nome
	 * @param qtd
	 * @param tags
	 * @param idItem
	 * @param representacaoUsuario
	 */
	public ItemDoavel(String nome, int qtd, String tags, Integer idItem, String representacaoUsuario) {
		this.validador.quantidadeInvalida(qtd);

		this.nome = nome;
		this.tags = tags.split(",");
		this.qtdItem = qtd;
		this.idItem = idItem;
		this.representacaoUsuario = representacaoUsuario;
	}

	public int getIdItem() {
		return this.idItem;
	}
	
	public String getUsuarioVinculado() {
		return this.representacaoUsuario;
	}
	
	public String[] getTags() {
		return this.tags;
	}

	@Override
	public int getPontuacao() {
		return this.pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getQtdItem() {
		return qtdItem;
	}
	
	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}
	
	/**
	 * Retorna a descricao completa do item.
	 */
	public String descricaoCompleta() {
		return this.nome + " - " + Arrays.toString(tags);
	}

	/**
	 * Metodo responsavel por atualizar os valores do item a ser mudado.
	 * 
	 * @param qtd
	 * @param tags
	 * @return
	 */
	public String atualizaItem(int qtd, String tags) {
		if (tags != null && !tags.trim().isEmpty())
			this.tags = tags.split(",");
		if (qtd > 0)
			this.setQtdItem(qtd);
		
		return this.toString();
	}
	
	/**
	 * toString auxiliar para quando se vai realizar uma doação.
	 */
	public String toStringParaRealizarDoacao(int qtdDoados) {
		return null;
	}
	
	/**
	 * Método toString da classe ItemDoavel.
	 */
	@Override
	public String toString() {
		return this.idItem + " - " + this.nome + ", tags: " + Arrays.toString(tags) + ", quantidade: " + this.qtdItem;
	}
	
	/**
	 * Método comparador da classe ItemDoavel a partir de sua quantidade.
	 */
	@Override
	public int compareTo(Item other) {
		if (this.qtdItem < other.getQtdItem())
			return 1;
		
		if (this.qtdItem > other.getQtdItem())
			return -1;
		
		return compareToNome(other);
	}
	
	/**
	 * Método comparador da classe ItemDoavel a partir do seu nome.
	 */
	@Override
	public int compareToNome(Item i) {
		return this.getNome().compareTo(i.getNome());
	}
	
	
	
	/**
	 * hashCode da classe ItemDoavel.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
		return result;
	}
	
	/**
	 * equals da classe ItemDoavel.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoavel other = (ItemDoavel) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		return true;
	}
	
	
}