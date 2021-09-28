package xadrez;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Peao;
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
	
	private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocandoPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void configuracaoInicial() {
		// monta peças pretas
		lugarNovaPeca('a', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarNovaPeca('h', 8, new Torre(tabuleiro, Cor.BLACK));
		
		//for (int i = 0; i < 8; i++) {
		//	tabuleiro.colocandoPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao(1, i));
		//}
	}
}
