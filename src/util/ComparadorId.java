package util;
import java.util.Comparator;

import itens.Item;

/**
 * Classe responsável por implementar a interface Comparator e criar um critério de comparação de itens.
 * Critério pelo id do item. 
 * 
 * Laboratório de Programação 2 - Projeto Final.
 * 
 * @authors Dacio Bezerra, Felipe Nunes, Victor Paz e Wallyngson Guedes.
 *
 */
public class ComparadorId implements Comparator<Item>{

	@Override
	public int compare(Item arg0, Item arg1) {
		if (arg0.getIdItem() < arg1.getIdItem())
			return -1;
		
		if (arg0.getIdItem() > arg1.getQtdItem())
			return 1;
		
		return 0;
		
	}

}
