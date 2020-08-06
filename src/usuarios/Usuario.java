package usuarios;

import java.io.Serializable;
import java.util.List;

import itens.Item;
import util.Validador;

/**
 * Classe abstrata que representa um Usuario do sistema de doacoes, podendo ser Receptor ou Doador.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public abstract class Usuario implements Comparable<Usuario>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] classes = { "PESSOA_FISICA", "IGREJA", "ORGAO_PUBLICO_MUNICIPAL", "ORGAO_PUBLICO_ESTADUAL",
			"ORGAO_PUBLICO_FEDERAL", "ONG", "ASSOCIACAO", "SOCIEDADE" };

	private String id, nome, email, celular, classe, status;
	private Validador validador = new Validador();

	/**
	 * Construtor da classe Usuario.
	 * 
	 * @param id
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * 
	 */
	public Usuario(String id, String nome, String email, String celular, String classe) {
		this.validador.parametrosUsuarioInvalidos(id, nome, email, celular, classe, classes);

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.classe = classe;
		this.status = getStatus();
	}

	public String nomeItem(Integer id) {
		return null;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * Esse metodo deve ser sobscrito nos doadores, pois ira cadastrar todos os itens de cada doador.
	 * 
	 * @param descritor
	 * @param qtd
	 * @param tags
	 */
	public void adicionaItem(Integer idItem, Item item) {}

	/**
	 * Esse metodo deve ser sobscrito pelo metodo de doador que exibe um item cadastrado.
	 * 
	 * @param descritor
	 * @return
	 */
	public String exibeItem(Integer idItem) {
		return null;
	}
	
	/**
	 * Metodo que remove itens de um doador, deve ser subscrito por um metodo em doador.
	 * 
	 * @param descritor
	 */
	public void removeItem(Integer idItem) {}
	
	/**
	 * Método que valida os itens de um usuario.
	 * @param idItem
	 */
	public void validaItem(Integer idItem) {}
	
	/**
	 * Método auxiliar para retornar a lista de itens.
	 * @return
	 */
	public List<Item> retornaItens() {
		return null;
	}
	
	/**
	 * Método toString da classe Usuario.
	 */
	@Override
	public String toString() {
		return this.nome + "/" + this.id + ", " + this.email + ", " + this.celular + ", " + "status: " + this.status;
	}
	
	/**
	 * hashCode da classe Usuario.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	/**
	 * equals da classe Usuario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Ordena os Usuarios em ordem decrescente de ID.
	 *
	 */
	@Override
	public int compareTo(Usuario outroUsuario) {
		return this.id.compareTo(outroUsuario.getId());
	}

}
