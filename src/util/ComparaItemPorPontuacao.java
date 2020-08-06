package util;
import java.util.Comparator;

import itens.Item;

/**
 * Classe responsável por implementar a interface Comparator e criar um critério de comparação de itens.
 * Critério pela pontuação do item.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class ComparaItemPorPontuacao implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return transforma(o2.getPontuacao()).compareTo(transforma(o1.getPontuacao()));
	}

	private Integer transforma(int pontuacao) {
		return new Integer(pontuacao);
	}

}
