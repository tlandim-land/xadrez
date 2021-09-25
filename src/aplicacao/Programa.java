package aplicacao;

import jogoTabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;

public class Programa {

	public static void main(String[] args) {
		System.out.println("BEM VINDO AO JOGO... QUE VENÇA O MELHOR!");
		System.out.println();
		
		Tabuleiro tabuleiro = new Tabuleiro(8, 8);
		
		PartidaXadrez partida = new PartidaXadrez();
		UI.imprimeTabuleiro(partida.getPecas());
	}
}
