package util;
import java.util.Comparator;

import itens.Item;

/**
 * Classe responsável por implementar a interface Comparator e criar um critério de comparação de itens.
 * Critério pelo nome do item.
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class ComparadorNome implements Comparator<Item>{
		public int compare(Item i1, Item i2) {
			return i1.getNome().compareTo(i2.getNome());
		}
}