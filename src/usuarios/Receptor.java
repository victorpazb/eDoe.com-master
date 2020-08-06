package usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import itens.Item;
import util.Validador;

/**
 * Classe que representa um Receptor de Doacoes.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class Receptor extends Usuario {
	
	
	private Map<Integer, Item> itens;
	private Validador validador = new Validador();
	private static final long serialVersionUID = 4L;
	
	/**
	 * Construtor do Receptor.
	 * 
	 * @param id
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * 
	 */
	public Receptor(String id, String nome, String email, String celular, String classe) {
		super(id, nome, email, celular, classe);
		super.setStatus("receptor");
		this.itens = new HashMap<>();
	}
	
	/**
	 * Sobscreve o metodo que esta em usuario, adicionando um item passado por parametro ao receptor.
	 */
	@Override
	public void adicionaItem(Integer idItem, Item item) {
		this.itens.put(idItem, item);
	}
	
	/**
	 * Exibe um item cadastrado no receptor.
	 */
	@Override
	public String exibeItem(Integer idItem) {
		this.validador.validaItem(idItem, itens);
		
		return this.itens.get(idItem).toString();
	}
	/**
	 * Valida um item do receptor.
	 */
	
	@Override
	public void validaItem(Integer idItem) {
		this.validador.validaItem(idItem, itens);
	}
	
	/**
	 * Método auxiliar que retorna a lista de itens.
	 * @return
	 */
	public Map<Integer, Item> getItens(){
		return this.itens;
	}
	
	/**
	 * Remove um item passado por parametro do usuario doador.
	 * 
	 * @param descritor
	 */
	@Override
	public void removeItem(Integer idItem) {
		this.validador.semItensCadastrados(itens);
		this.validador.validaItem(idItem, itens);
		
		this.itens.remove(idItem);
	}
	
	/**
	 * Retorna os itens do receptor.
	 */
	@Override
	public List<Item> retornaItens() {
		List<Item> itensDoUsuario = new ArrayList<>();
		itensDoUsuario.addAll(this.itens.values());
		
		return itensDoUsuario;
	}
	
	/**
	 * Retorna o nome de algum item vinculado.
	 */
	@Override
	public String nomeItem(Integer id) {
		return this.itens.get(id).getNome();
	}

}