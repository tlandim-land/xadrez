package jogoTabuleiro;

public class Tabuleiro {
	
	private Integer linhas;
	private Integer colunas;
	private Peca[][] pecas;

	public Tabuleiro(Integer linhas, Integer colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("ERRO AO CRIAR TABULEIRO: DEVE TER PELO MENOS 1 LINHA E 1 COLUNA");
		}		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public Integer getLinhas() {
		return linhas;
	}

	public Integer getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExistente(linha, coluna)) {
			throw new TabuleiroException("POSIÇÃO NÃO EXISTENTE NO TABULEIRO");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExistente(posicao)) {
			throw new TabuleiroException("POSIÇÃO NÃO EXISTENTE NO TABULEIRO");
		}		
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocandoPeca(Peca peca, Posicao posicao) {
		if (posicaoOcupada(posicao)) {
			throw new TabuleiroException("POSIÇÃO OCUPADA " + posicao);
		}		
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;		
	}
	
	public boolean posicaoExistente(int linha, int coluna) {
		return linha >= 0 && linha < linhas && 
			   coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean posicaoOcupada(Posicao posicao) {
		if (!posicaoExistente(posicao)) {
			throw new TabuleiroException("POSIÇÃO NÃO EXISTENTE NO TABULEIRO");
		}
		return peca(posicao) != null;
	}
}
