package xadrez;

import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
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
	
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoEncontrada(origem);
		Peca pecaCapturada = fazerMovimento(origem, destino);
		return(PecaXadrez)pecaCapturada;
		
	}
	
	private Peca fazerMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.colocandoPeca(p, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoEncontrada(Posicao posicao) {
		if (!tabuleiro.posicaoExistente(posicao)) {
			throw new XadrezException("N�O EXISTE PE�A NA POSICAO DE ORIGEM!");
		}
		if (tabuleiro.peca(posicao).algumMovimentoPossivel()) {
			throw new XadrezException("N�O EXISTE MOVIMENTO POSSIVEL PARA PE�A ESCOLHIDA");
		}
	}
	
	private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocandoPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void configuracaoInicial() {
		// monta pe�as pretas
		//lugarNovaPeca('a', 8, new Torre(tabuleiro, Cor.BLACK));
		//lugarNovaPeca('h', 8, new Torre(tabuleiro, Cor.BLACK));
		
		lugarNovaPeca('c', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('c', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('d', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('e', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarNovaPeca('e', 1, new Torre(tabuleiro, Cor.WHITE));
        lugarNovaPeca('d', 1, new Rei(tabuleiro, Cor.WHITE));

        lugarNovaPeca('c', 7, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('c', 8, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('d', 7, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('e', 7, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('e', 8, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('d', 8, new Rei(tabuleiro, Cor.BLACK));		
        
		//for (int i = 0; i < 8; i++) {
		//	tabuleiro.colocandoPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao(1, i));
		//}
	}
}
