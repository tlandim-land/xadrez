package xadrez;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Rainha;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for (int l = 0; l < tabuleiro.getLinhas(); l++) {
			for (int c = 0; c < tabuleiro.getColunas(); c++) {
				mat[l][c] = (PecaXadrez) tabuleiro.peca(l, c);
			}
		}
		return mat;
	}
	
	private void configuracaoInicial() {
		// monta peças pretas
		tabuleiro.colocandoPeca(new Torre(tabuleiro, Cor.BLACK), new Posicao(0,0));
		tabuleiro.colocandoPeca(new Torre(tabuleiro, Cor.BLACK), new Posicao(0,7));
		tabuleiro.colocandoPeca(new Cavalo(tabuleiro, Cor.BLACK), new Posicao(0,1));
		tabuleiro.colocandoPeca(new Cavalo(tabuleiro, Cor.BLACK), new Posicao(0,6));
		tabuleiro.colocandoPeca(new Bispo(tabuleiro, Cor.BLACK), new Posicao(0,2));
		tabuleiro.colocandoPeca(new Bispo(tabuleiro, Cor.BLACK), new Posicao(0,5));
		tabuleiro.colocandoPeca(new Rei(tabuleiro, Cor.BLACK), new Posicao(0,3));
		tabuleiro.colocandoPeca(new Rainha(tabuleiro, Cor.BLACK), new Posicao(0,4));
	}
}
