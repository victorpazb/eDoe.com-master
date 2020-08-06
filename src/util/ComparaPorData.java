package util;
import java.util.Comparator;

import itens.Doacao;

/**
 * Classe responsável por implementar a interface Comparator e criar um critério de comparação de Doações.
 * Critério pela data da realização da doação, e pelo descritor do item doado.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class ComparaPorData implements Comparator<Doacao> {

	@Override
	public int compare(Doacao o1, Doacao o2) {
		if (o1.formataData() > o2.formataData())
			return -1;
		
		if (o1.formataData() < o2.formataData())
			return 1;
		
		return o1.getItemDoado().compareTo(o2.getItemDoado());
	}

}
