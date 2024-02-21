package Chess;

import tabuleiro.Posiçao;

public class XadrezPosiçao {

	private char coluna;
	private int linha;

	public XadrezPosiçao(char coluna, int linha) {

		// Colocando um if pra saber se passa no padrao do tabuleiro:

		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezExceçao("Erro de instanciar a posiçao do xadrez. Valido valores de ate a1 a h8!");
		}

		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}
	public int getLinha() {
		return linha;
	}
	
	// mostrando a posiçao:
	protected Posiçao toPosiçao() {
		return new Posiçao (8 - linha, coluna - 'a' );
	}
	
	protected static XadrezPosiçao LugarDaPosiçao(Posiçao posiçao) {
		return new XadrezPosiçao((char) ('a' - posiçao.getColuna()), 8 - posiçao.getLinha());
	}
	@Override 
	public String toString(){
		return "" + coluna + linha;
	}
}
