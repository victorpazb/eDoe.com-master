package sistema;

import java.io.IOException;
import easyaccept.EasyAccept;
import sistema.EDoeController;

/**
 * Classe de fachada que apenas recebe os metotos e chama os do controller.
 * Padrao de Projeto Facade.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class Facade {

	public static void main(String[] args) {
		args = new String[] { "sistema.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt", "acceptance_test/use_case_6.txt", "acceptance_test/use_case_7.txt" };
		EasyAccept.main(args);
	}

	EDoeController controller = new EDoeController();

	// CASE1

	public void lerReceptores(String arquivo) throws IOException {
		this.controller.lerReceptores(arquivo);
	}

	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		return this.controller.adicionaDoador(id, nome, email, celular, classe);
	}

	public String pesquisaUsuarioPorNome(String nome) {
		return this.controller.pesquisaUsuarioPorNome(nome);
	}

	public String pesquisaUsuarioPorId(String id) {
		return this.controller.pesquisaUsuarioPorId(id);
	}

	public String atualizaUsuario(String id, String nome, String email, String celular) {
		return this.controller.atualizaUsuario(id, nome, email, celular);
	}

	public boolean removeUsuario(String id) {
		return this.controller.removeUsuario(id);
	}

	// CASE2

	public void adicionaDescritor(String descritor) {
		this.controller.adicionaDescritor(descritor);
	}

	public Integer adicionaItemParaDoacao(String idDoador, String descritor, int qtd, String tags) {
		return this.controller.adicionaItemParaDoacao(idDoador, descritor, qtd, tags);
	}

	public String exibeItem(Integer idItem, String id) {
		return this.controller.exibeItem(idItem, id);
	}

	public void removeItemParaDoacao(Integer idItem, String id) {
		this.controller.removeItem(idItem, id);
	}

	public String atualizaItemParaDoacao(Integer idItem, String id, int qtd, String tags) {
		return this.controller.atualizaItem(idItem, id, qtd, tags);
	}

	// CASE3

	public String listaDescritorDeItensParaDoacao() {
		return this.controller.listaDescritorDeItensParaDoacao();
	}
		
	public String listaItensParaDoacao() { 
		return this.controller.listaItensParaDoacao();
	}
		
	public String pesquisaItemParaDoacaoPorDescricao(String desc) {
		return this.controller.pesquisaItemPorDescricao(desc);
	}
		
	// CASE4
		
	public Integer adicionaItemNecessario(String idReceptor, String descritor, int qtd, String tags) {
		return this.controller.adicionaItemNecessario(idReceptor, descritor, qtd, tags);
	}
	public String listaItensNecessarios() {
		return this.controller.listaItensNecessarios();
	}
	public String atualizaItemNecessario(String IdReceptor, Integer idItem, int qtd, String tags) {
		return this.controller.atualizaItem(idItem, IdReceptor, qtd, tags);
	}
	public void removeItemNecessario(String id, Integer idItem) {
		this.controller.removeItem(idItem, id);
	}
		
	//CASE 5
		
	public String match(String idReceptor, Integer idItem) {
		return this.controller.match(idReceptor, idItem);
	}
	
	// CASE 6
	
	public String realizaDoacao(Integer idItemNec, Integer idItemDoado, String data) {
		return controller.realizaDoacao(idItemNec, idItemDoado, data);
	}
	
	public String listaDoacoes() {
		return controller.listaDoacoes();
	}
	
	// CASE 7
	
	public void iniciaSistema() {
		this.controller.iniciaSistema();
	}
	
	public void finalizaSistema() {
		this.controller.finalizaSistema();
	}
}
