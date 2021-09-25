package aplicacao;

import xadrez.PecaXadrez;

public class UI {
	
	public static void imprimeTabuleiro(PecaXadrez[][] pecas) {
		for (int l = 0; l < pecas.length; l++ ) {
			
			System.out.print((8 - l) + " ");
			
			for (int c = 0; c < pecas.length; c++ ) {
				imprimePeca(pecas[l][c]);
			}

			System.out.println(); 
		}
		System.out.print("  A B C D E F G H"); 
	}
	
	private static void imprimePeca(PecaXadrez peca) { 
		if (peca == null) {
			System.out.print("-");
		} else {
			System.out.print(peca);
		}
		System.out.print(" ");
	}
}
