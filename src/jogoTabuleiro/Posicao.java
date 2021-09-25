package jogoTabuleiro;

public class Posicao {
	private Integer linha;
	private Integer coluna;
	
	// construtores da classe
	public Posicao() {
	}
	
	public Posicao(Integer linha, Integer coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	// getters e setters 
	public Integer getLinha() {
		return linha;
	}
	
	public void setLinha(Integer linha) {
		this.linha = linha;
	}
	
	public Integer getColuna() {
		return coluna;
	}
	
	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}
	
	@Override
	public String toString() {
		return linha + ", " + coluna;
	}
}