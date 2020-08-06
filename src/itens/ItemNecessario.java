package itens;

import java.io.Serializable;
import java.util.Arrays;

import util.Validador;

/**
 * Classe que representa um item necessario, apto a fazer parte da lista de itens necessarios aos receptores.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class ItemNecessario implements Item, Serializable {
	private String nome;
	private String[] tags;
	private Integer idItem;
	private int qtdItem;
	private String representacaoUsuario;
	private int pontuacao;
	private static final long serialVersionUID = 2L;
	
	private Validador validador = new Validador();
	
	/**
	 * Construtor da classe ItemNecessario.
	 * @param nome
	 * @param qtd
	 * @param tags
	 * @param idItem
	 * @param representacaoUsuario
	 */
	public ItemNecessario(String nome, int qtd, String tags, Integer idItem, String representacaoUsuario) {
		this.validador.quantidadeInvalida(qtd);
		this.nome = nome;
		this.tags = tags.split(",");
		this.qtdItem = qtd;
		this.idItem = idItem;
		this.representacaoUsuario = representacaoUsuario;
	}
	
	/**
	 * Metodo que retorna a representacao do usuario que possui esse item.
	 */
	public String getUsuarioVinculado() {
		return representacaoUsuario;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public String[] getTags() {
		return this.tags;
	}

	@Override
	public int getPontuacao() {
		return this.pontuacao;
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
	 * Metodo responsavel por atualizar os valores do item a ser mudado,
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
	 * toString da classe ItemNecessario.
	 */
	@Override
	public String toString() {
		return this.idItem + " - " + this.nome.toLowerCase() + ", tags: " + Arrays.toString(tags) + ", quantidade: " + this.qtdItem;
	}
	
	/**
	 * Comparador da classe ItemNecessario a partir da sua quantidade.
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
	 * Comparador da classe ItemNecessario a partir do seu nome.
	 */
	@Override
	public int compareToNome(Item i) {
		return this.getNome().compareTo(i.getNome());
	}
	
	/**
	 * Método toString utilizado para quando se vai realizar doações.
	 */
	public String toStringParaRealizarDoacao(int qtdDoados) {
		return this.nome.toLowerCase() + ", quantidade: " + qtdDoados;
	}
}
