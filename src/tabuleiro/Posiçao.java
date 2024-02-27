package tabuleiro;

/*
  Nessa classe irei colocar informaçoes sobre a posiçao COLUNA e LINHA do xadrez, por isso esta no pacote TABULEIRO.
 */

public class Posiçao {
	private int linha;
	private int coluna;
	
	public Posiçao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public void setValores(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	
	//Criando um toString para imprimir a posição no terminal.
	@Override
	public String toString() {
		return linha + ", " + coluna;
	}
	
}
