package jogoTabuleiro;

public abstract class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {		
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentosPossiveis();
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean algumMovimentoPossivel() {
		boolean[][] mat = movimentosPossiveis();
		for(int l = 0; l < mat.length; l++ ) {
			for (int c = 0; c < mat.length; c++) {
				if (mat[l][c]) {
					return true;
				}
			}
		}
		return false;
	}
}
