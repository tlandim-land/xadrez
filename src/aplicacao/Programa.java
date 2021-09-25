package aplicacao;

import jogoTabuleiro.Posicao;

public class Programa {

	public static void main(String[] args) {
		System.out.println("BEM VINDO AO JOGO... QUE VENÇA O MELHOR!");
		System.out.println();
		
		Posicao pos = new Posicao(3, 4);
		
		System.out.println(pos);
	}

}
